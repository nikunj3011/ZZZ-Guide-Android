package zzzguide.models.api.wengines

data class WEngineResponseItem(
    val bStyle: String,
    val baseAtk: Int,
    val bonusStat: String,
//    val description: String,
    val img: String,
    val name: String,
    val rarity: String,
    val rarityDes: String,
    val type: String
)