package zzzguide.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import zzzguide.db.NewsTypeConverters

@Entity(tableName = "news_search_results")
@TypeConverters(NewsTypeConverters::class)
data class NewsSearchResult(
    @PrimaryKey
    val query: String,
    val total: Int,
    val newsIds: List<String>
)