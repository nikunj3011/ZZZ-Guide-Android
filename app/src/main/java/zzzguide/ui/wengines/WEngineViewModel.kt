package zzzguide.ui.wengines

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import zzzguide.models.api.wengines.WEngineResponseItem
import zzzguide.models.api.wenginesNew.WEngineNewResponseItem
import zzzguide.repository.HomeRepository

class WEngineViewModel(
    private val repository: HomeRepository
) : ViewModel() {

//    private val _weaponsLiveData = MutableLiveData<List<WEngineResponseItem>>()
//    val weaponsLiveData: LiveData<List<WEngineResponseItem>> get() = _weaponsLiveData
//    var _weapons = listOf<WEngineResponseItem>()

    private val _weaponsLiveData = MutableLiveData<List<WEngineNewResponseItem>>()
    val weaponsLiveData: LiveData<List<WEngineNewResponseItem>> get() = _weaponsLiveData
    var _weapons = listOf<WEngineNewResponseItem>()

    init {
        fetchWepons()
    }
    private fun fetchWepons() {
        viewModelScope.launch {
            try {
                val newItem = withContext(Dispatchers.IO) {
                    repository.fetchWEnginesNew()
                }
                _weaponsLiveData.postValue(newItem.body()?.toList())
                _weapons = newItem.body()!!.toList()
                Log.e("element", newItem.toString())
            } catch (e: Exception) {
                // Handle exceptions, if any
                Log.e("getDetail", "Error fetching details: ${e.message}")
            }
        }
    }

}