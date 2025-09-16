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

    implementation(libs.r2dbc.postgresql)
    implementation(libs.exposed.core)
    implementation(libs.exposed.r2dbc)
    implementation(libs.exposed.kotlin.datetime)

    implementation(platform(libs.netty.bom))
    implementation(libs.netty.common)
    implementation(libs.netty.buffer)
    implementation(libs.netty.transport)
    implementation(libs.netty.handler)

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