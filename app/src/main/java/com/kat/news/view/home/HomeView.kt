package com.kat.news.view.home

import com.kat.news.data.local.Article
import com.kat.news.data.remote.RemoteArticles
import com.kat.news.view.base.View

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface HomeView:View{

    fun onProgress()

    fun onSuccess(response: RemoteArticles)

    fun onOpenArticleDetail(articles: Article)
}