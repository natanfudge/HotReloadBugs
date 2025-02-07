pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
    }

    plugins {
        kotlin("jvm").version(extra["kotlin.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("org.jetbrains.kotlin.plugin.compose").version(extra["kotlin.version"] as String)
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }
}
dependencyResolutionManagement {
    repositories {
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
    }
}
rootProject.name = "GraphicsTests"
