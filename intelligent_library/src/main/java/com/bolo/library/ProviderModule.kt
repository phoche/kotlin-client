package com.bolo.library

import android.content.Context
import android.content.SharedPreferences
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Create by bolo on 2018/5/25
 */
@Singleton
@Component(modules = [(ProviderModule::class)])
interface BaseComponent {
    fun context(): Context

    fun sharedPreferences(): SharedPreferences

    fun retrofit(): Retrofit
}

@Module
class ProviderModule(private val context: Context,
                     private val baseUrl: String,
                     private val spName: String) {

    @Singleton
    @Provides
    fun providerContext() : Context {
        return context
    }

    @Singleton
    @Provides
    fun providerSharedPreferences() : SharedPreferences {
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE)
    }


    @Singleton
    @Provides
    fun providerRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    fun providerOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .cache(Cache(context.externalCacheDir, 10 * 1024 * 1024))
                .build()
    }
}