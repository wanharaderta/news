package com.kat.news.view.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.kat.news.R
import com.kat.news.data.local.Article
import com.kat.news.data.remote.RemoteArticles
import com.kat.news.deps.provider.NewsProvider
import com.kat.news.service.ArticleService
import com.kat.news.utils.getDate
import com.kat.news.view.base.BaseActivity
import com.kat.news.view.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(),HomeView {


    @Inject
    protected lateinit var service: ArticleService

    private var presenter: HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        (application as NewsProvider).providesNewsComponent().inject(this)

        fun initView(){

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
                presenter?.articleDetail(article)
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

    override fun onOpenArticleDetail(article: Article) {
        startActivity<DetailActivity>(
                "article" to article
        )
        this.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }



}
