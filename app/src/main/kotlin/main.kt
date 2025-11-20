import config.configureKoin
import config.configureSerialization
import domain.controller.productController
import io.ktor.server.application.Application
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer

fun main() {
    embeddedServer(
        CIO,
        port = 8080,
        host = "127.0.0.1",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureSerialization()
    productController()
}