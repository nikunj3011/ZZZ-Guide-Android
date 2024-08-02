package zzzguide.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import zzzguide.models.api.character.CharacterResponse
import zzzguide.models.api.characterdetail.CharacterDetailResponse
import zzzguide.models.api.characterdetails.CharactersDetailsResponse
import zzzguide.models.api.bangboo.BangBoosResponse
import zzzguide.models.api.wengines.WEngineResponse

interface ZZZGuidesService {

    @GET("bangboos.json")
    suspend fun getBangboos(
    ): Response<BangBoosResponse>

    @GET("characters.json")
    suspend fun getCharacters(
    ): Response<CharacterResponse>

    @GET("wengines.json")
    suspend fun getWEngines(
    ): Response<WEngineResponse>

    @GET("charactersdetails.json")
    suspend fun getCharactersDetails(
    ): Response<CharactersDetailsResponse>

    @GET("characters/{id}.json")
    suspend fun getCharactersDetail(
        @Path(value = "id") id: String,
        @Query("articlesCount") count: Int = 0
    ): Response<CharacterDetailResponse>
}