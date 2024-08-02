package zzzguide.repository

import zzzguide.api.ZZZGuidesService

class HomeRepository(
    private val apiService: ZZZGuidesService
) {
    suspend fun fetchEchoes() = apiService.getBangboos()
    suspend fun fetchCharacters() = apiService.getCharacters()
    suspend fun fetchWeapons() = apiService.getWEngines()
    suspend fun fetchCharactersDetails() = apiService.getCharactersDetails()
    suspend fun fetchCharacterDetails(id: String) = apiService.getCharactersDetail(id)
}