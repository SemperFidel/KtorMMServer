plugins {
    id("buildsrc.convention.kotlin-jvm")

    application
}

dependencies {
    implementation(project(":utils"))
    implementation(project(":database"))
    implementation(project(":network"))

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.contentNegotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.mongodb.bson.kotlinx)

    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)

    implementation(libs.logback.classic)
}

application {
    mainClass = "ru.test.app.AppKt"
}
