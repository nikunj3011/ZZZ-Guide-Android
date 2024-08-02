package zzzguide.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import zzzguide.models.db.News
import zzzguide.repository.NewsRepository
import zzzguide.util.AbsentLiveData
import zzzguide.util.LoadMoreState
import zzzguide.util.NextPageHandler
import zzzguide.util.Resource
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _query = MutableLiveData<Query>()
    val query: LiveData<Query>
        get() = _query

    val searchResults: LiveData<Resource<List<News>>> = _query.switchMap { input ->
        input.ifExists { keyword, count ->
            repository.searchNews(
                keyword = keyword,
                count = count
            )
        }
    }

    private val nextPageHandler = NextPageHandler()
    val loadMoreState: LiveData<LoadMoreState>
        get() = nextPageHandler.loadMoreState

    fun setQuery(keyword: String, count: Int) {
        val update = Query(keyword, count)
        if (_query.value == update) {
            return
        }
        nextPageHandler.reset()
        _query.value = update
    }

    fun loadNextPage() {
        _query.value?.let {
            if (it.keyword.isNotBlank()) {
                nextPageHandler.queryNextPage {
                    repository.searchNewsNextPage(
                        it.keyword,
                        it.count
                    )
                }
            }
        }
    }

    fun retry() {
        _query.value?.let {
            _query.value = it
        }
    }

    fun toggleBookmark(news: News) {
        val current = news.bookmark
        val updated = news.copy(bookmark = !current)
        viewModelScope.launch {
            repository.updateNews(updated)
        }
    }

    data class Query(
        val keyword: String,
        val count: Int
    ) {
        fun <T> ifExists(f: (String, Int) -> LiveData<T>): LiveData<T> {
            return if (keyword.isBlank()) {
                AbsentLiveData.create()
            } else {
                f(keyword, count)
            }
        }
    }

}