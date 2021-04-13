package no.kristiania.cryptonite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

private fun generateCryptoList(size: Int): List<Crypto_list> {
    val list = ArrayList<Crypto_list>()
    for (i in 0 until size) {
        val drawable = when (i % 3) {
            0 -> R.drawable.ic_bitcoin
            1 -> R.drawable.ic_ethereum_1
            else -> R.drawable.ic_uniswap_uni_logo
        }
        val item = Crypto_list(drawable, "Item $i", "Line 2")
        list += item
    }

    return list
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Cryptonite)
        setContentView(R.layout.activity_main)

        fetchJson()

        val cryptoList = generateCryptoList(500)
        recycler_view.adapter = ListAdapter(cryptoList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    fun fetchJson() {
        println("Fetching JSON")

        val url = "https://api.coincap.io/v2/assets"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback{
            
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                 println(body)

                val gson = GsonBuilder().create()

                val crypto = gson.fromJson(body, Crypto::class.java)
            }

            override fun onFailure(call: Call, e: IOException) {
                  println("Failed to execute request")
            }
        })
    }
}