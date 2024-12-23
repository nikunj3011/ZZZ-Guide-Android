package zzzguide.models.api.bangbooNew

data class BangbooNewResponseItem(
    val cardImage: CardImage,
    val createdAt: String,
    val id: String,
    val name: String,
    val rarity: String,
    val skills: Skills,
    val slug: String,
    val smallImage: SmallImage,
    val statsNew: StatsNew,
    val unitId: Int,
    val updatedAt: String
)