package zzzguide.di

import android.content.Context
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import zzzguide.MainViewModel
import zzzguide.util.AD_ID
import zzzguide.util.PREFERENCE_NAME
import zzzguide.util.REFRESH_TIMEOUT
import zzzguide.util.RateLimiter
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zzzguide.HomeViewModel
import zzzguide.api.ZZZGuidesService
import zzzguide.repository.HomeRepository
import zzzguide.ui.character.CharacterViewModel
import zzzguide.ui.characterdetail.CharacterDetailsViewModel
import zzzguide.ui.bangboos.BangbooViewModel
import zzzguide.ui.homedata.HomeDataViewModel
import zzzguide.ui.wengines.WeaponViewModel
import zzzguide.util.ZZZGuide_URL
import java.util.concurrent.TimeUnit

val appModule = module {

    factory {
        AdRequest.Builder().build()
    }

    single {
        AdLoader.Builder(androidContext(), AD_ID)
    }

    single {
        Retrofit.Builder()
            .baseUrl(ZZZGuide_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZZZGuidesService::class.java)
    }

//    single {
//        val db = get<NewsDatabase>()
//        db.videosDao()
//    }

    single {
        androidContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    single {
        RateLimiter<String>(REFRESH_TIMEOUT, TimeUnit.MINUTES)
    }

    single {
        HomeRepository(get())
    }

    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        BangbooViewModel(get())
    }

    viewModel {
        CharacterDetailsViewModel(get())
    }

    viewModel {
        HomeDataViewModel(get())
    }

    viewModel {
        CharacterViewModel(get())
    }

    viewModel {
        WeaponViewModel(get())
    }

    viewModel {
        MainViewModel()
    }

}