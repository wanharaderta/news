package com.kat.news.service

import com.kat.news.data.Api
import com.kat.news.data.remote.RemoteArticles
import com.kat.news.utils.disposableSubscriber
import id.kotlin.training.movies.services.NetworkCallTransformer
import id.kotlin.training.movies.services.NetworkCallback
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function

class ArticleService(private val api: Api) {

    fun getArticle(country: String, key: String,
                   callback: NetworkCallback<RemoteArticles>): Disposable {
        return api.getArticle(country, key)
                .compose(NetworkCallTransformer<RemoteArticles>())
                .onErrorResumeNext(Function { Flowable.error { it } })
                .subscribeWith(disposableSubscriber<RemoteArticles>(
                        next = { response -> callback.onSuccess(response) },
                        error = { exception -> callback.onError(exception) }

                ))

    }
}