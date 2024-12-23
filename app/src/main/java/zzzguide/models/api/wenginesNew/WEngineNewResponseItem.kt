package zzzguide.models.api.wenginesNew

data class WEngineNewResponseItem(
    val description: Description,
    val element: String,
    val engineId: Int,
    val image: Image,
    val name: String,
    val rarity: Int,
    val stats: Stats,
    val talentName: String,
    val type: Int
)