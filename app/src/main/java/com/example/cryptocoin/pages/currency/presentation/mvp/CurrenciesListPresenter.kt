package com.example.cryptocoin.pages.currency.presentation.mvp

import com.arellomobile.mvp.InjectViewState
import com.example.cryptocoin.core.mvp.BasePresenter
import com.example.cryptocoin.pages.currency.domain.CurrenciesListInteractor
import com.example.cryptocoin.core.utils.DefaultComposerSinger
import javax.inject.Inject

@InjectViewState
class CurrenciesListPresenter @Inject constructor(
    private val interactor: CurrenciesListInteractor
) : BasePresenter<CurrenciesListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        onLoadData()
    }

    fun onLoadData() {
        disposable?.add(
            interactor.getCoinMarket()
                .compose(DefaultComposerSinger(viewState))
                .subscribe({
                    viewState.showData(it)
                }, {
                    viewState.showErrorMessage(it.message)
                })
        )
    }
}