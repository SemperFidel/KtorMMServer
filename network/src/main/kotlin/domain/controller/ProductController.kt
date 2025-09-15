package domain.controller

import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.http.*
import kotlinx.coroutines.flow.toList
import data.entity.ProductDTO
import domain.service.ProductService

class ProductController(private val service: ProductService) {

    fun Route.routes() {
        route("/products") {

            get {
                val products = service.getAll().toList()
                call.respond(products)
            }

            get("{id}") {
                val id = call.parameters["id"] ?: return@get call.respondText(
                    "Missing id", status = HttpStatusCode.BadRequest
                )

                service.getById(id).fold(
                    ifLeft = { e -> call.respondText(e.message ?: "Error",
                        status = HttpStatusCode.NotFound) },
                    ifRight = { product -> call.respond(product) }
                )
            }

            post {
                val productDto = call.receive<ProductDTO>()
                service.create(productDto).fold(
                    ifLeft = { e -> call.respondText(e.message ?: "Error",
                        status = HttpStatusCode.InternalServerError) },
                    ifRight = { call.respondText("Created", status = HttpStatusCode.Created) }
                )
            }

            put("{id}") {
                val idParam = call.parameters["id"] ?: return@put call.respondText(
                    "Missing id", status = HttpStatusCode.BadRequest
                )

                val productDto = call.receive<ProductDTO>().copy(id = idParam)

                service.update(productDto).fold(
                    ifLeft = { e -> call.respondText(e.message ?: "Error",
                        status = HttpStatusCode.InternalServerError) },
                    ifRight = { call.respondText("Updated", status = HttpStatusCode.OK) }
                )
            }

            delete("{id}") {
                val id = call.parameters["id"] ?: return@delete call.respondText(
                    "Missing id", status = HttpStatusCode.BadRequest
                )
                service.delete(id).fold(
                    ifLeft = { e -> call.respondText(e.message ?: "Error",
                        status = HttpStatusCode.InternalServerError) },
                    ifRight = { call.respondText("Deleted",
                        status = HttpStatusCode.OK) }
                )
            }
        }
    }
}