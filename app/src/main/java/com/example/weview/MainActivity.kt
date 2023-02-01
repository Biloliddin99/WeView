package com.example.weview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.SearchView
import com.example.weview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var url = "https://www.google.com/search?q="
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.webViewClient = object : WebViewClient() {

        }

        binding.mySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("SetJavaScriptEnabled")
            override fun onQueryTextSubmit(p0: String?): Boolean {

                binding.webView.loadUrl(url + p0)
                val webSettings = binding.webView.settings
                webSettings.javaScriptEnabled = true
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return true
            }
        })
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}