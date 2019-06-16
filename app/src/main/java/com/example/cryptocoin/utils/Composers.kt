package com.example.cryptocoin.utils

import com.example.cryptocoin.base.di.BaseView
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers

class DefaultComposerSinger<T>(private val view: BaseView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoader(true) }
            .doFinally { view.showLoader(false) }
    }
}

