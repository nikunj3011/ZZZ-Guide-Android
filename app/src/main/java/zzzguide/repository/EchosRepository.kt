package zzzguide.repository

import kotlinx.coroutines.flow.Flow
import zzzguide.models.db.Echo
import zzzguide.util.Resource

interface EchosRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Echo>>>

    suspend fun getMovie(id: Int): Flow<Resource<Echo>>
}