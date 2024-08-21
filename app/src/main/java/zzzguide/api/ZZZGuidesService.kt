package zzzguide.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import zzzguide.models.api.character.AgentResponse
import zzzguide.models.api.characterdetail.CharacterDetailResponse
import zzzguide.models.api.bangboo.BangBoosResponse
import zzzguide.models.api.wengines.WEngineResponse

interface ZZZGuidesService {

    @GET("bangboos.json")
    suspend fun getBangboos(
    ): Response<BangBoosResponse>

    @GET("charactersdetail/charactersDetails.json")
    suspend fun getCharacters(
    ): Response<AgentResponse>

    @GET("wengines.json")
    suspend fun getWEngines(
    ): Response<WEngineResponse>

    @GET("charactersdetail/{id}.json")
    suspend fun getCharactersDetail(
        @Path(value = "id") id: String,
        @Query("articlesCount") count: Int = 0
    ): Response<CharacterDetailResponse>


    @GET("charactersdetail/charactersDetails.json")
    suspend fun getCharactersDetails(
    ): Response<List<CharacterDetailResponse>>
}