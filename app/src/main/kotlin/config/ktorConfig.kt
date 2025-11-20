package config

import di.databaseModule
import di.repositoryModule
import di.serviceModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(
            databaseModule,
            serviceModule,
            repositoryModule,
        )
    }
}

