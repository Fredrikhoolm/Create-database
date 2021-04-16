package no.kristiania.cryptonite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.crypto_currencies_list.view.*

class MainAdapter(val crypto: Crypto): RecyclerView.Adapter<CustomViewHolder>() {

    val cryptoTitles = listOf("First title", "second", "3rd")

    override fun getItemCount(): Int {
        return crypto.data.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.crypto_currencies_list, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val data = crypto.data.get(position)
        holder?.view?.textView_crypto_title?.text = data.name

        holder?.view?.textView_symbol?.text = data.symbol

        holder?.view?.textView_crypto_price?.text = data.priceUsd.toString()

        holder?.view?.textView_crypto_percentage.text = data.changePercent24Hr
    }

}

    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}

