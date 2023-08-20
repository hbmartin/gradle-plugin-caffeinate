# Caffeinate gradle plugin ☕️🐘

![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/me.haroldmartin.gradle.caffeinate)
[![Pre Merge Checks](https://github.com/hbmartin/gradle-plugin-caffeinate/actions/workflows/pre-merge.yaml/badge.svg)](https://github.com/hbmartin/gradle-plugin-caffeinate/actions/workflows/pre-merge.yaml)
[![CodeFactor](https://www.codefactor.io/repository/github/hbmartin/gradle-plugin-caffeinate/badge)](https://www.codefactor.io/repository/github/hbmartin/gradle-plugin-caffeinate)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=hbmartin_gradle-plugin-caffeinate&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=hbmartin_gradle-plugin-caffeinate)


## How to Use 🎉

### Install

- Apply plugin to root project. Ensure you have `gradlePluginPortal()` in your `repositories` block.
- Your project must be built with a minimum of Java 1.9
- Be sure to activate the plugin as described below.
- Choose 1 of the 3 options (apply to root project):

**Version catalog:**

```toml
[versions]
caffeinate = "0.0.1"
[plugins]
caffeinate = { id = "me.haroldmartin.gradle.caffeinate", version.ref = "caffeinate" }
```

```kotlin
plugins {
    alias(libs.plugins.caffeinate)
}
```

**Kotlin:**

```kotlin
plugins {
  id("me.haroldmartin.gradle.caffeinate") version "0.0.1"
}
```

**Groovy:**

```groovy
plugins {
  id "me.haroldmartin.gradle.caffeinate" version "0.0.1"
}
```

### Activate

Either set environment variable `export ORG_GRADLE_PROJECT_caffeinate="true"` or run gradle with the argument `-Pcaffeinate=true`

## Development Environment 🛠

- Based on [kotlin-gradle-plugin-template](https://github.com/cortinico/kotlin-gradle-plugin-template)
- 100% Kotlin including Gradle DSL.
- Plugin build setup with [Gradle composite build](https://docs.gradle.org/current/userguide/composite_builds.html).
- Dependency versions managed via Gradle Versions Catalog (`libs.versions.toml`).
- CI Setup with GitHub Actions.
- Kotlin Static Analysis via `ktlint` and `detekt`.
- This is using GitHub action to build, test and publish the plugin.
- `preMerge` task to run all the checks before pushing.

### Contributing 🤝

* [PRs](https://github.com/hbmartin/gradle-plugin-caffeinate/pulls) and [bug reports or feature requests](https://github.com/hbmartin/gradle-plugin-caffeinate/issues) are all welcome!
* Treat other people with helpfulness, gratitude, and consideration! See the [JetBrains CoC](https://confluence.jetbrains.com/display/ALL/JetBrains+Open+Source+and+Community+Code+of+Conduct)

### License 📄

This template is licensed under the MIT License - see the [License](License) file for details.
