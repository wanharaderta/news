package com.kat.news

import com.kat.news.deps.component.NewsComponent
import com.kat.news.deps.provider.NewsProvider

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class NewsApp : NewsProvider {

    private lateinit var component: NewsComponent



    override fun providesNewsComponent(): NewsComponent = component


}