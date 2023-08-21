package me.haroldmartin.gradle.caffeinate

import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class CaffeinatePlugin : Plugin<Project> {
    @Suppress("AvoidVarsExceptWithDelegate")
    private var caffeinateProcess: Process? = null

    override fun apply(project: Project) {
        project.gradle.taskGraph.whenReady {
            val shouldCaffeinate = project.rootProject.findProperty("caffeinate")
            if (shouldCaffeinate == null || shouldCaffeinate == "false") return@whenReady

            project.gradle.taskGraph.allTasks.first().doFirst {
                val pid = tryGetPid()
                val os = System.getProperty("os.name")
                if (os.contains("Mac")) {
                    caffeinateProcess = if (pid != null) {
                        // we want to manually kill the process in doLast since the PID is the daemon's
                        // -t flag provides a fallback if the daemon is killed before the task is complete
                        Runtime.getRuntime().exec("caffeinate -i -m -t $pid")
                    } else {
                        Runtime.getRuntime().exec("caffeinate -i -m")
                    }
                } else {
                    project.logger.error(
                        "caffeinate does not yet support $os, please open an issue on GitHub\n" +
                            "https://github.com/hbmartin/gradle-plugin-caffeinate/issues",
                    )
                }
            }
            // n.b. this is not guaranteed to be the last task, but it's the best I can find
            project.gradle.taskGraph.allTasks.last().doLast {
                caffeinateProcess?.destroyForcibly()
                caffeinateProcess = null
            }
        }
    }

    @Suppress("TooGenericExceptionCaught", "SwallowedException")
    private fun tryGetPid() = try {
        ProcessHandle.current().pid()
    } catch (e: Exception) {
        null
    }
}
