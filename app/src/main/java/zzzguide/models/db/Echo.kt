package zzzguide.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import zzzguide.models.api.echo.EchoSet

@Entity(tableName = "echos")
data class Echo(
    @PrimaryKey
    val No: String,
    val PossibleSonataEffects: String,
    val classEcho: String,
    val cooldown: String,
    val cost: String,
    val description: String,
    val echoSets: List<EchoSet>,
    val img: String,
    val name: String
)