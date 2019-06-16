package com.example.cryptocoin.base.di

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    var disposable: CompositeDisposable? = null

    override fun attachView(view: V) {
        disposable = CompositeDisposable()
        super.attachView(view)
    }

    override fun detachView(view: V) {
        super.detachView(view)
        unsubscribe()
    }

    private fun unsubscribe() {
        disposable?.dispose()
        disposable = null
    }
}