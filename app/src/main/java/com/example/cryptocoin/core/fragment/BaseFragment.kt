package com.example.cryptocoin.core.fragment

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.cryptocoin.R
import com.example.cryptocoin.core.adapter.BaseAdapter
import com.example.cryptocoin.core.mvp.BaseView
import kotlinx.android.synthetic.main.fragment_currencies_list.*

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    private lateinit var recyclerView: RecyclerView
    protected lateinit var viewAdapter: BaseAdapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            swipeLayout.setColorSchemeColors(ContextCompat.getColor(it, R.color.colorAccent))
        }
        viewManager = LinearLayoutManager(context)
        viewAdapter = createAdapterInstance()

        recyclerView = list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        swipeLayout.apply {
            clearAnimation()
            setOnRefreshListener(null)
            isRefreshing = false
        }
    }

    override fun showLoader(show: Boolean) {
        showProgressInSwipeToRefresh(show)
    }

    override fun showErrorMessage(text: String?) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    abstract fun createAdapterInstance(): BaseAdapter<*>

    private fun showProgressInSwipeToRefresh(show: Boolean) {
        swipeLayout.isRefreshing = show
    }
}