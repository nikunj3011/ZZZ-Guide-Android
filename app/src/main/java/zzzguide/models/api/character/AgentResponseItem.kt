package zzzguide.models.api.character

data class AgentResponseItem(
    val bio: String,
    val birthday: String,
    val categories: List<Category>,
    val full_name: String,
    val gender: String,
    val height: String,
    val intro: String,
    val name: String,
    val nick_name: String,
    val skills: List<Skill>,
    val talents: List<Talent>,
    val voice_actors: VoiceActors
)