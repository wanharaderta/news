package com.kat.news.view.home

import android.util.Log
import com.kat.news.data.local.Article
import com.kat.news.data.remote.RemoteArticles
import com.kat.news.service.ArticleService
import com.kat.news.utils.Config
import com.kat.news.utils.Configs
import com.kat.news.utils.safeDispose
import com.kat.news.view.base.Presenter
import id.kotlin.training.movies.services.NetworkCallback
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class HomePresenter : Presenter<HomeView>{


    private var view: HomeView? = null
    private var disposables: CompositeDisposable? = null

    override fun onAttach(view: HomeView) {
        this.view = view
        disposables = CompositeDisposable()
    }

    override fun onDetach() {
        view = null
        disposables.safeDispose()
    }

    fun getArticles(service: ArticleService){
        view?.onProgress()

        @Configs val apiKey = Config.API_KEY

        val disposable = service.getArticle("id",apiKey, object : NetworkCallback<RemoteArticles>{
            override fun onSuccess(response: RemoteArticles) {
                view?.onSuccess(response)

            }

            override fun onError(e: Throwable) {
                Log.e("article",e.message, e)

            }

        })

        disposable.let { disposables?.add(it) }
    }

    fun ArticleDetail(article: Article){
        view?.onOpenArticleDetail(article)
    }

}