package com.kat.news.view.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kat.news.R
import com.kat.news.data.local.Article
import com.kat.news.data.remote.RemoteArticles
import com.kat.news.deps.provider.NewsProvider
import com.kat.news.service.ArticleService
import com.kat.news.utils.getDate
import com.kat.news.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : BaseActivity(),HomeView {


    @Inject
    protected lateinit var service: ArticleService

    private var presenter: HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as NewsProvider).providesNewsComponent().inject(this)

        fun initView(){

            supportActionBar?.title = "News"

            val layoutManager = LinearLayoutManager(this)
            rvArticle.layoutManager = layoutManager
        }

        initView()

    }

    override fun onResume() {
        presenter = HomePresenter()
        onAttach()
        super.onResume()
    }

    override fun onProgress() {
       progress_dialog.visibility = android.view.View.VISIBLE
    }

    override fun onSuccess(response: RemoteArticles) {

        val data = response.articles
        val articles = data.map {
            val author = it?.author
            val title = it?.title
            val desc = it?.description
            val url = it?.url
            val urlImage = it?.urlToImage
            val publishedAt = getDate(it?.publishedAt)

            Article(author,title,desc,url,urlImage,publishedAt)
        }

        val adapter= HomeAdapter(this,articles,object : HomeListener{
            override fun onClick(article: Article) {
                presenter
            }
        })
        rvArticle.adapter = adapter
        adapter.notifyDataSetChanged()

        fun hide(){
            progress_dialog.visibility = android.view.View.GONE
            rvArticle.visibility = android.view.View.VISIBLE
        }

        hide()
    }

    override fun onAttach() {
        presenter?.onAttach(this)
        presenter?.getArticles(service)
    }

    override fun onDetach() {
        presenter?.onDetach()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }

    override fun onOpenArticleDetail(articles: Article) {

    }



}
