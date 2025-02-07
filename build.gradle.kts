import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.reload.ComposeHotRun
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose-hot-reload") version "1.0.0-dev-39" // <- add this additionally
}

group = "natan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    maven("https://packages.jetbrains.team/maven/p/firework/dev")
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(17)
        // Fixes Hidpi issues, has better hot reload support.
        vendor = JvmVendorSpec.JETBRAINS
    }
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "GraphicsTests"
            packageVersion = "1.0.0"
        }
    }
}
composeCompiler {
    featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
}

tasks.register<ComposeHotRun>("runHot") {
    mainClass.set("MainKt")
}