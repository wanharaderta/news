package com.kat.news.data.remote

import com.google.gson.annotations.SerializedName


/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

data class RemoteArticles(
        @SerializedName("status") var status: String?,
        @SerializedName("totalResults") var totalResults: Int?,
        @SerializedName("articles") var articles: List<Article?>){

    data class Article(
            @SerializedName("source") var source: Source?,
            @SerializedName("author") var author: String?,
            @SerializedName("title") var title: String?,
            @SerializedName("description") var description: String?,
            @SerializedName("url") var url: String?,
            @SerializedName("urlToImage") var urlToImage: String?,
            @SerializedName("publishedAt") var publishedAt: String?)

    data class Source(
            @SerializedName("id") var id: String?,
            @SerializedName("name") var name: String?)
}