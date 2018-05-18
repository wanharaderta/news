package com.kat.news.deps.provider

import com.kat.news.deps.component.NewsComponent

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface NewsProvider{

    fun providesNewsComponent():NewsComponent
}