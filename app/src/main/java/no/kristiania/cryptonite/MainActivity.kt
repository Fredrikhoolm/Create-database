package no.kristiania.cryptonite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Cryptonite)
        setContentView(R.layout.activity_main)

        fetchJson()
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