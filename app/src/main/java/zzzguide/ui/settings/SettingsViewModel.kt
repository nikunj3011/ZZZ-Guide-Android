package zzzguide.ui.settings

import androidx.lifecycle.ViewModel
import zzzguide.repository.DarkMode
import zzzguide.repository.UserRepository

class SettingsViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val darkModeLiveData = repository.darkModeLiveData

    fun updateDarkMode(darkMode: DarkMode) {
        repository.updateDarkMode(darkMode)
    }

}