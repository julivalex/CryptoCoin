package com.example.cryptocoin.base.fragment

import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.cryptocoin.base.BaseView

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun showLoader(show: Boolean) {
    }

    override fun showErrorMessage(text: String?) {
    }

    override fun refresh() {
    }
}