package com.textile.markeet.data.retrofit

import android.util.Log
import com.textile.markeet.helpers.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitRxJavaClient private constructor() {

    private val retrofit: Retrofit

    /*    private static Cache cache() {
        return new Cache(new File(AppConstants.mContext.getCacheDir(), AppConstants.APP_NAME), cacheSize);
    }*/

    private val okHttpClient: OkHttpClient
        get() {

            val httpLoggingInterceptor = HttpLoggingInterceptor()

            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

    init {

        retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(okHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor()) // used if network off OR on
            .build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor { message -> Log.d(TAG, "log: http log: $message") }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    /**
     * This interceptor will be called ONLY if the network is available
     *
     * @return
     */

    fun createClient(): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }

    companion object {

        private var retrofitClient: RetrofitRxJavaClient? = null

        private val TAG = "ServiceGenerator"
        private val HEADER_CACHE_CONTROL = "Cache-Control"
        private val HEADER_PRAGMA = "Pragma"
        private val cacheSize = (5 * 1024 * 1024).toLong() // 5 MB

        val instance: RetrofitRxJavaClient
            get() {

                if (retrofitClient == null) {
                    retrofitClient = RetrofitRxJavaClient()
                }

                return retrofitClient!!
            }

    }
}
