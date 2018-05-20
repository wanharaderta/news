package com.kat.news.view.detail

import android.os.Bundle
import com.kat.news.R
import com.kat.news.data.local.Article
import com.kat.news.view.base.BaseActivity

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/19/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class DetailActivity: BaseActivity(){

    private var articles: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        articles = intent.getParcelableExtra("article")

        fun initView() {
            setFragment(DetailArticleFragment.newInstance(articles),
                    DetailArticleFragment.TAG.toString(),false,
                    intArrayOf(0, R.anim.slide_in_from_left,0,0))

        }

        initView()

    }
}