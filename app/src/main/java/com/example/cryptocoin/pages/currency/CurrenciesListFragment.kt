package com.example.cryptocoin.pages.currency

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.cryptocoin.R
import com.example.cryptocoin.core.adapter.BaseAdapter
import com.example.cryptocoin.core.fragment.BaseFragment
import com.example.cryptocoin.domain.model.CoinMarkets
import com.example.cryptocoin.pages.CoinActivity
import com.example.cryptocoin.pages.currency.presentation.adapter.CurrenciesAdapter
import com.example.cryptocoin.pages.currency.presentation.mvp.CurrenciesListPresenter
import com.example.cryptocoin.pages.currency.presentation.mvp.CurrenciesListView
import kotlinx.android.synthetic.main.fragment_currencies_list.*
import javax.inject.Inject

class CurrenciesListFragment : BaseFragment(), CurrenciesListView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    @InjectPresenter
    lateinit var presenter: CurrenciesListPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as CoinActivity).appComponent.currenciesListComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_currencies_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListener()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CurrenciesAdapter()
    }

    override fun showData(list: List<CoinMarkets>) {
        viewAdapter.add(list)
    }

    override fun onRefresh() {
        presenter.onLoadData()
    }

    private fun setListener() {
        swipeLayout.setOnRefreshListener(this)
    }
}
