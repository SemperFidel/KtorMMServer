plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

group = "ru.test"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinxCoroutines)
    implementation(libs.kotlinxCoroutinesReactive)

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)

    implementation(libs.mongodb.bson.kotlinx)

    implementation(libs.koin.core)

    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    implementation(project(":database"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}