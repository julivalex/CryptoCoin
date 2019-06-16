package com.example.cryptocoin.pages.currency.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cryptocoin.R
import com.example.cryptocoin.base.adapter.BaseAdapter
import com.example.cryptocoin.domain.model.CoinMarkets
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrenciesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrenciesViewHolder(view)
    }

    class CurrenciesViewHolder(view: View) : BaseViewHolder(view) {

        init {
            itemView.setOnClickListener {
            }
        }

        override fun bind(item: Any) {
            if (item is CoinMarkets) {
                Glide.with(view.context).load(item.image).into(view.ivCurrencyIcon)
                view.tvCurrencySym.text = item.symbol
                view.tvCurrencyName.text = item.name
                view.tvCurrencyMarketCap.text = item.marketCap.toString()
                view.tvCurrencyPrice.text = item.currentPrice.toString()
            }
        }
    }
}