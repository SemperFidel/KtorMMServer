import domain.controller.ProductController
import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val controller: ProductController by inject()

    routing {
        controller.run {
            routes()
        }
    }
}