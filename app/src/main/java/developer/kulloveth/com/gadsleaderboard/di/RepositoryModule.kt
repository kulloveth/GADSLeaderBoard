package developer.kulloveth.com.gadsleaderboard.di

import developer.kulloveth.com.gadsleaderboard.data.api.ApiHelper
import developer.kulloveth.com.gadsleaderboard.data.api.ApiHelperImpl
import developer.kulloveth.com.gadsleaderboard.data.api.repository.LearnerRepository
import org.koin.dsl.module


val repositoryModule= module {
    single<ApiHelper> {
        return@single ApiHelperImpl(get(),get())
    }
    single {
        LearnerRepository(get())
    }
}

