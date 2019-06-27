package com.example.cryptocoin.core.utils

import com.example.cryptocoin.core.mvp.BaseView
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultComposerSinger<T>(private val view: BaseView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoader(true) }
            .doFinally { view.showLoader(false) }
    }
}

