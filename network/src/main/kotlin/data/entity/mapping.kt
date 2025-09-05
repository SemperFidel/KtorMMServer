package data.entity
import org.bson.types.ObjectId

fun Product.toDTO() = ProductDTO(
    id = id?.toHexString(),
    name = name,
    price = price,
    shortDesc = shortDesc,
    imagesURL = imagesURL
)

fun ProductDTO.toEntity() = Product(
    id = id?.let { ObjectId(it) },
    name = name,
    price = price,
    shortDesc = shortDesc,
    imagesURL = imagesURL
)