package zzzguide

import android.app.Application
import zzzguide.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZZZWavesGuide : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ZZZWavesGuide)
            modules(appModule)
        }
    }

}