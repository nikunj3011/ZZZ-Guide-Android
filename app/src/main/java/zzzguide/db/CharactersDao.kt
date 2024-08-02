package zzzguide.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import zzzguide.models.db.Category

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<Category>)

    @Query("SELECT * FROM categories")
    suspend fun findCategories(): List<Category>

    @Query("SELECT * FROM categories")
    fun getCategories(): LiveData<List<Category>>

    @Query("SELECT * FROM categories WHERE isSelected = 1")
    fun getSelectedCategory(): LiveData<Category>

    @Query("UPDATE categories SET isSelected = 1 WHERE id = :categoryId")
    suspend fun setSelectedCategory(categoryId: String)

    @Query("UPDATE categories SET isSelected = 0 WHERE id != :categoryId")
    suspend fun clearSelectedCategory(categoryId: String)

}