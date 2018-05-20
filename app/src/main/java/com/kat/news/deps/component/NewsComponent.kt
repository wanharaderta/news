package com.kat.news.deps.component

import com.kat.news.deps.module.NetworkModule
import com.kat.news.deps.module.ServiceModule
import com.kat.news.view.detail.DetailArticleFragment
import com.kat.news.view.home.HomeActivity
import com.kat.news.view.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

@Singleton
@Component(modules = arrayOf( NetworkModule::class,ServiceModule::class))
interface NewsComponent{

        fun inject(homeActivity: HomeActivity)

        fun inject(detailArticleFragment: DetailArticleFragment)

        fun inject(splashActivity: SplashActivity)

}