plugins {
    kotlin("jvm")
}

group = "ru.test"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinxCoroutines)
    implementation(libs.kotlinxCoroutinesReactive)
    implementation(libs.kotlinxSerialization)

    implementation(libs.mongodb.driver.reactivestreams)
    implementation(libs.mongodb.driver.kotlin.extensions)
    implementation(libs.mongodb.driver.kotlin.coroutine)
    implementation(libs.mongodb.bson.kotlinx)

    implementation(libs.h2)
    implementation(libs.postgresql)
    implementation(libs.jimmer.core)
    implementation(libs.jimmer.sql)

    implementation(libs.koin.core)

    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}