package zzzguide

import androidx.lifecycle.ViewModel
import zzzguide.repository.UserRepository

class MainViewModel(
    repository: UserRepository
) : ViewModel() {

    val darkModeLiveData = repository.darkModeLiveData

}