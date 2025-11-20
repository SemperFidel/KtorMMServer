plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlinPluginSerialization) apply false
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    // Add a dependency on the Kotlin Gradle plugin, so that convention plugins can apply it.
    implementation(libs.kotlinGradlePlugin)
}
