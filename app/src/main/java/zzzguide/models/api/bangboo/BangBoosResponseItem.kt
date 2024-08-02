package zzzguide.models.api.bangboo

import com.google.gson.annotations.SerializedName

data class BangBoosResponseItem(
    val No: String,
    @SerializedName("Possible Sonata Effects")
    val PossibleSonataEffects: String,
    val classEcho: String,
    val cooldown: String,
    val cost: String,
    val description: String,
    val bangbooSets: List<BangbooSet>,
    val img: String,
    val name: String,
    val rarity: String
)