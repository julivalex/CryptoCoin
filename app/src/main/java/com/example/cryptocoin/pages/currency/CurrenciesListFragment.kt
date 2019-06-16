package com.example.cryptocoin.pages.currency

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.example.cryptocoin.R
import com.example.cryptocoin.base.fragment.BaseFragment
import com.example.cryptocoin.domain.model.CoinMarkets
import com.example.cryptocoin.pages.CoinActivity
import com.example.cryptocoin.pages.currency.presentation.mvp.CurrenciesListPresenter
import com.example.cryptocoin.pages.currency.presentation.mvp.CurrenciesListView
import javax.inject.Inject

class CurrenciesListFragment : BaseFragment(), CurrenciesListView {

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


    override fun addCurrency(coin: CoinMarkets) {
    }

    override fun notifyAdapter() {
    }

}
