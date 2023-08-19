# Caffeinate gradle plugin ☕️🐘

## How to use

1. Apply plugin to root project
2. Either set environment variable `export ORG_GRADLE_PROJECT_caffeinate="true"` or run gradle with the argument `-Pcaffeinate=true`

Once created don't forget to update the:
- [gradle.properties](plugin-build/gradle.properties)
- Plugin Usages (search for [com.ncorti.kotlin.gradle.template](https://github.com/cortinico/kotlin-gradle-plugin-template/search?q=com.ncorti.kotlin.gradle.template&unscoped_q=com.ncorti.kotlin.gradle.template) in the repo and replace it with your ID).

### `preMerge` task

A `preMerge` task on the top level build is already provided in the template. This allows you to run all the `check` tasks both in the top level and in the included build.

You can easily invoke it with:

```
./gradlew preMerge
```

If you need to invoke a task inside the included build with:

```
./gradlew -p plugin-build <task-name>
```


### Dependency substitution

Please note that the project relies on module name/group in order for [dependency substitution](https://docs.gradle.org/current/userguide/resolution_rules.html#sec:dependency_substitution_rules) to work properly. If you change only the plugin ID everything will work as expected. If you change module name/group, things might break and you probably have to specify a [substitution rule](https://docs.gradle.org/current/userguide/resolution_rules.html#sub:project_to_module_substitution).


## Publishing 🚀

This template is ready to let you publish to [Gradle Portal](https://plugins.gradle.org/).

The [![Publish Plugin to Portal](https://github.com/cortinico/kotlin-gradle-plugin-template/workflows/Publish%20Plugin%20to%20Portal/badge.svg?branch=1.0.0)](https://github.com/cortinico/kotlin-gradle-plugin-template/actions?query=workflow%3A%22Publish+Plugin+to+Portal%22) Github Action will take care of the publishing whenever you **push a tag**.

Please note that you need to configure two secrets: `GRADLE_PUBLISH_KEY` and `GRADLE_PUBLISH_SECRET` with the credetials you can get from your profile on the Gradle Portal.

## Development Environment 🛠

- Based on [kotlin-gradle-plugin-template](https://github.com/cortinico/kotlin-gradle-plugin-template)
- 100% Kotlin including Gradle DSL.
- Plugin build setup with **composite build**.
- Dependency versions managed via Gradle Versions Catalog (`libs.versions.toml`).
- CI Setup with GitHub Actions.
- Kotlin Static Analysis via `ktlint` and `detekt`.
- This is using a [Gradle composite build](https://docs.gradle.org/current/userguide/composite_builds.html) to build, test and publish the plugin.
-

## CI ⚙️

This template is using [**GitHub Actions**](https://github.com/cortinico/kotlin-android-template/actions) as CI. You don't need to setup any external service and you should have a running CI once you start using this template.

There are currently the following workflows available:
- [Validate Gradle Wrapper](.github/workflows/gradle-wrapper-validation.yml) - Will check that the gradle wrapper has a valid checksum
- [Pre Merge Checks](.github/workflows/pre-merge.yaml) - Will run the `preMerge` tasks as well as trying to run the Gradle plugin.
- [Publish to Plugin Portal](.github/workflows/publish-plugin.yaml) - Will run the `publishPlugin` task when pushing a new tag.

## Contributing 🤝

Feel free to open an issue or submit a pull request for any bugs/improvements.

## License 📄

This template is licensed under the MIT License - see the [License](License) file for details.
