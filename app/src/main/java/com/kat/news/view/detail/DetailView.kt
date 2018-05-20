package com.kat.news.view.detail

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/19/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

interface DetailView : com.kat.news.view.base.View{

    fun onDetailArticle(author: String?,title: String?,
                        desc: String?,url: String?,
                        urlToImage: String?, publishedAt: String?)

}