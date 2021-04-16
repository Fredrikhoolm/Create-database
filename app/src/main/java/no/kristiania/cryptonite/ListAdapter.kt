package no.kristiania.cryptonite

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val cryptoList: List<Crypto_list>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val cryptoView = LayoutInflater.from(parent.context).inflate(R.layout.crypto_list,
            parent, false)

        return ListViewHolder(cryptoView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentCrypto = cryptoList[position]

        holder.imageView.setImageResource(currentCrypto.imageResource)
        holder.textView1.text = currentCrypto.text1
        holder.textView2.text = currentCrypto.text2

    }

    override fun getItemCount() = cryptoList.size

    class ListViewHolder(listView: View) : RecyclerView.ViewHolder(listView){
        val imageView: ImageView = listView.findViewById(R.id.image_view)
        val textView1: TextView = listView.findViewById(R.id.text_view_1)
        val textView2: TextView = listView.findViewById(R.id.text_view_2)
    }
}
