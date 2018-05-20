package com.kat.news.view.detail

import com.kat.news.data.local.Article
import com.kat.news.view.base.Presenter

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/19/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class DetailPresenter() : Presenter<DetailView>{

    private var view:DetailView? = null

    override fun onAttach(view: DetailView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun setDetail(article: Article?){

        var author: String?     = article?.author
        var title: String?      = article?.title
        var desc: String?       = article?.desc
        val url         = article?.url
        var urlToImage: String? = article?.urlToImage
        var publishedAt: String?= article?.publishedAt

        view?.onDetailArticle(author,title,desc,url,urlToImage,publishedAt)

    }

}