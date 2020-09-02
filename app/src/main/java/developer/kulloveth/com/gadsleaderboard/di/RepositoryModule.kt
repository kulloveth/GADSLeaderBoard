package developer.kulloveth.com.gadsleaderboard.di

import developer.kulloveth.com.gadsleaderboard.data.api.ApiHelper
import developer.kulloveth.com.gadsleaderboard.data.api.ApiHelperImpl
import developer.kulloveth.com.gadsleaderboard.data.api.repository.LearnerRepository
import org.koin.dsl.module


val repositoryModule= module {
    single {
        provideApiHelper(get())
    }

    single {
        LearnerRepository(get())
    }
}

private fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl
