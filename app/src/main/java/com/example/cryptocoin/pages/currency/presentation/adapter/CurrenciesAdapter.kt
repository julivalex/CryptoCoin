package com.example.cryptocoin.pages.currency.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cryptocoin.R
import com.example.cryptocoin.core.adapter.BaseAdapter
import com.example.cryptocoin.domain.model.CoinMarkets
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrenciesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return CurrenciesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrenciesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CurrenciesViewHolder(
        view: View
    ) : BaseAdapter.BaseViewHolder(view) {

        override fun bind(item: Any) = with(itemView) {
            if (item is CoinMarkets) {
                Glide.with(context).load(item.image).into(ivCurrencyIcon)
                tvCurrencySym.text = item.symbol
                tvCurrencyName.text = item.name
                tvCurrencyMarketCap.text = item.marketCap.toString()
                tvCurrencyPrice.text = item.currentPrice.toString()
            }
            setOnClickListener {
            }
        }
    }
}