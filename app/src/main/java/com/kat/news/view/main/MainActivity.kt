package com.kat.news.view.main

import android.os.Bundle
import com.kat.news.R
import com.kat.news.deps.provider.NewsProvider
import com.kat.news.view.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as NewsProvider).providesNewsComponent().inject(this)
    }


}
