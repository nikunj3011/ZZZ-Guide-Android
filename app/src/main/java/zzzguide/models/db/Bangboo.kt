package zzzguide.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import zzzguide.models.api.bangboo.BangbooSet

@Entity(tableName = "bangboo")
data class Bangboo(
    @PrimaryKey
    val No: String,
    val PossibleSonataEffects: String,
    val classEcho: String,
    val cooldown: String,
    val cost: String,
    val description: String,
    val bangbooSets: List<BangbooSet>,
    val img: String,
    val name: String
)