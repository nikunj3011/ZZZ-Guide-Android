package zzzguide.repository

import kotlinx.coroutines.flow.Flow
import zzzguide.models.db.Bangboo
import zzzguide.util.Resource

interface BangbooRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Bangboo>>>

    suspend fun getMovie(id: Int): Flow<Resource<Bangboo>>
}