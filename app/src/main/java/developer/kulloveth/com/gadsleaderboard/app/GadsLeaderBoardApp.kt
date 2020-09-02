package developer.kulloveth.com.gadsleaderboard.app

import android.app.Application
import developer.kulloveth.com.gadsleaderboard.di.networkModule
import developer.kulloveth.com.gadsleaderboard.di.repositoryModule
import developer.kulloveth.com.gadsleaderboard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GadsLeaderBoardApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
          androidContext(this@GadsLeaderBoardApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        } }
}