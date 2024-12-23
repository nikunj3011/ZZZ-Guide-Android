package zzzguide.repository

import zzzguide.api.ZZZGuidesService

class HomeRepository(
    private val apiService: ZZZGuidesService
) {
    suspend fun fetchBangboos() = apiService.getBangboos()
    suspend fun fetchBangboosNew() = apiService.getBangboosNew()
    suspend fun fetchCharacters() = apiService.getCharacters()
    suspend fun fetchWEngines() = apiService.getWEngines()
    suspend fun fetchWEnginesNew() = apiService.getWEnginesNew()
    suspend fun fetchCharacterDetails(id: String) = apiService.getCharactersDetail(id)
    suspend fun fetchCharacterDetails() = apiService.getCharactersDetails()
}