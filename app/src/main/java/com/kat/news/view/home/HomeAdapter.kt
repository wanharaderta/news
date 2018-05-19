package com.kat.news.view.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kat.news.R
import com.kat.news.data.local.Article
import com.kat.news.utils.loadImage
import com.kat.news.utils.loadRoundedBitmap
import kotlinx.android.synthetic.main.item_article.view.*

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class HomeAdapter(
        private val context: Context,
        private val articles: List<Article>,
        private val listener:HomeListener
) : RecyclerView.Adapter<HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder = HomeHolder (
        LayoutInflater.from(parent.context).inflate(
                R.layout.item_article,
                parent,
                false)
    )

    override fun getItemCount(): Int = articles.size


    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val article = articles[position]
        holder.bindView(context,article,listener)
    }

}

class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(context: Context,
                 article: Article,
                 listener: HomeListener) {

        with(article){
            itemView.vtitle.text    = title
            itemView.vauthor.text   = author
            itemView.vdate.text     = publishedAt
            loadImage(context, urlToImage, itemView.vimage)
            loadRoundedBitmap(context, urlToImage, itemView.profilePicture)
            itemView.setOnClickListener { listener.onClick(article) }
        }
    }

}
