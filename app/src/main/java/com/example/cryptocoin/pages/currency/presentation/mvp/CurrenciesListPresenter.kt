package com.example.cryptocoin.pages.currency.presentation.mvp

import com.arellomobile.mvp.InjectViewState
import com.example.cryptocoin.base.BasePresenter
import com.example.cryptocoin.pages.currency.domain.CurrenciesListInteractor
import com.example.cryptocoin.utils.DefaultComposerSinger
import javax.inject.Inject

@InjectViewState
class CurrenciesListPresenter @Inject constructor(
    private val interactor: CurrenciesListInteractor
) : BasePresenter<CurrenciesListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onMakeList() {
        disposable?.addAll(interactor.getCoinMarket()
            .compose(DefaultComposerSinger(viewState))
            .subscribe(
                {
                    viewState::notifyAdapter
                },
                {
                    viewState::showErrorMessage
                }
            ))

    }

    fun onRefreshList() {
        viewState.refresh()
        onMakeList()
    }
}