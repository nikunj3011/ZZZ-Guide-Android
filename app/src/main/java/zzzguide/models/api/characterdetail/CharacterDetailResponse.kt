package zzzguide.models.api.characterdetail

data class CharacterDetailResponse(
    val attackType: List<String>,
    val build: Build,
    val cardImage: CardImage,
    val cons: Cons,
    val createdAt: String,
    val element: String,
    val endgameStats: EndgameStats,
    val faction: String,
    val fullName: String,
    val id: String,
    val introduction: Introduction,
    val name: String,
    val pros: Pros,
    val rarity: String,
    val ratings: Ratings,
    val releaseDate: String,
    val review: Any,
    val skillKey: String,
    val slug: String,
    val smallImage: SmallImage,
    val style: String,
    val talents: List<Talent>,
    val tierListCategory: String,
    val tierListTags: List<String>,
    val unitId: String,
    val upcoming: Any,
    val updatedAt: String,
    val videos: Any,
    val voiceActors: VoiceActors
)