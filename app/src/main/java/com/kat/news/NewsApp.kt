package com.kat.news

import android.app.Application
import com.kat.news.deps.component.DaggerNewsComponent
import com.kat.news.deps.component.NewsComponent
import com.kat.news.deps.module.NetworkModule
import com.kat.news.deps.module.ServiceModule
import com.kat.news.deps.provider.NewsProvider

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class NewsApp : Application(),NewsProvider {

    private lateinit var component: NewsComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerNewsComponent.builder()
                    .networkModule(NetworkModule(this))
                    .serviceModule(ServiceModule())
                    .build()
    }

    override fun providesNewsComponent(): NewsComponent = component


}