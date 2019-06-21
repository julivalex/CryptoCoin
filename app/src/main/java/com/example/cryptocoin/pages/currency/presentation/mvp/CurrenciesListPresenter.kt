package com.example.cryptocoin.pages.currency.presentation.mvp

import com.arellomobile.mvp.InjectViewState
import com.example.cryptocoin.base.di.BasePresenter
import com.example.cryptocoin.pages.currency.domain.CurrenciesListInteractor
import com.example.cryptocoin.pages.currency.presentation.adapter.CurrenciesAdapter
import com.example.cryptocoin.utils.DefaultComposerSinger
import javax.inject.Inject

@InjectViewState
class CurrenciesListPresenter @Inject constructor(
    private val interactor: CurrenciesListInteractor
) : BasePresenter<CurrenciesListView>() {

    private val items =  CurrenciesAdapter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        onMakeList()
    }

    private fun onMakeList() {
        disposable?.add(interactor.getCoinMarket("usd")
            .compose(DefaultComposerSinger(viewState))
            .subscribe(
                {   items.add(it)
                    viewState.showData(items)
                },
                { error ->
                    viewState.showErrorMessage(error.message)
                }
            ))
    }

    fun onRefreshList() {
        viewState.refresh()
        onMakeList()
    }
}