package com.kat.news.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kat.news.R
import com.kat.news.data.local.Article
import com.kat.news.deps.provider.NewsProvider
import com.kat.news.utils.loadImage
import com.kat.news.utils.loadRoundedBitmap
import com.kat.news.view.base.BaseFragment
import kotlinx.android.synthetic.main.action_bar_content.view.*
import kotlinx.android.synthetic.main.fragment_detail_article.*


class DetailArticleFragment : BaseFragment(), DetailView {


    private var presenter: DetailPresenter? = null
    private var article: Article? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        article = arguments?.getParcelable("articles")

        fun initView() {

            action_bar.backButtonArea.setOnClickListener {
                activity.onBackPressed()

            }

        }

        initView()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (activity.application as NewsProvider).providesNewsComponent().inject(this)

        return inflater.inflate(R.layout.fragment_detail_article, container, false)

    }


    override fun onAttach() {
        presenter?.onAttach(this)
        presenter?.setDetail(article)
    }


    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }

    override fun onDetach() {
        presenter?.onDetach()
        super.onDetach()
    }

    override fun onResume() {
        presenter = DetailPresenter()
        onAttach()
        super.onResume()
    }


    override fun onDetailArticle(author: String?, title: String?,
                                 desc: String?, url: String?,
                                 urlToImage: String?, publishedAt: String?) {

        loadImage(activity, urlToImage, vimage)
        loadRoundedBitmap(activity, urlToImage, profilePicture)
        vauthor.text        = author
        vtitle.text         = title
        vdate.text          = publishedAt
        vdesc.text          = desc

    }



    companion object {
        val TAG = DetailArticleFragment::class.simpleName
        fun newInstance(articles: Article?): DetailArticleFragment {

            val fragment = DetailArticleFragment()
            val bundle = Bundle()
            bundle.putParcelable("articles", articles)
            fragment.arguments = bundle
            return fragment

        }
    }

}
