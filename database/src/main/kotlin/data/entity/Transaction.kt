package data.entity

import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.datetime.CurrentDateTime
import org.jetbrains.exposed.v1.datetime.datetime
import org.jetbrains.exposed.v1.datetime.time

object Transaction: Table() {
    val id = integer("id").autoIncrement()
    val type = varchar("type", 255)
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
    val updatedAt = time("updated_at")
    override val primaryKey = PrimaryKey(id)
}