package zzzguide.models.api.character

data class AgentResponseItem(
    val element: String,
    val rarity: String,
    val faction: String,
    val style: String,
    val name: String,
    val slug: String,
)