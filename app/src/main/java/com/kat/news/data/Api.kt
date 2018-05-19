package com.kat.news.data

import com.kat.news.data.remote.RemoteArticles
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface Api{

    @GET("v2/top-headlines")
    fun getArticle(
            @Query("country") country: String,
            @Query("apiKey") key: String): Flowable<RemoteArticles>
}