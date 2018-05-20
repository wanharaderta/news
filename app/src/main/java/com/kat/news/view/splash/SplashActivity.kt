package com.kat.news.view.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kat.news.R
import com.kat.news.deps.provider.NewsProvider
import com.kat.news.view.home.HomeActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        (application as NewsProvider).providesNewsComponent().inject(this)

        fun initView(){

            startActivity<HomeActivity>()
        }

        initView()
    }
}
