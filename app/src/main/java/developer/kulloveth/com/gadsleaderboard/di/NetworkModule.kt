package developer.kulloveth.com.gadsleaderboard.di

import android.content.Context
import developer.kulloveth.com.gadsleaderboard.BuildConfig
import developer.kulloveth.com.gadsleaderboard.data.api.ApiService
import developer.kulloveth.com.gadsleaderboard.util.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val networkModule = module {
    single (named("LEADER_BASE_URL")){
        BuildConfig.LEADER_BOARD_BASE_URL
    }
    single {
        provideOkHttpClient()
    }

    single {
        provideNetworkHelper(androidContext())
    }
    single {
        buildLearningApiService(get(named("LEADER_BASE_URL")))
    }
}
private fun provideOkHttpClient()=if(BuildConfig.DEBUG){
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}else OkHttpClient
    .Builder().build()

private fun provideNetworkHelper(context: Context)  =
    NetworkHelper(context)

private fun retrofit(baseUrl:String):Retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create()).baseUrl(baseUrl)
        .client(provideOkHttpClient()).build()

private fun buildLearningApiService(baseUrl: String)= retrofit(baseUrl).create(ApiService::class.java)


