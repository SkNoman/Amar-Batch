package com.example.amarbatch.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.amarbatch.databinding.FragmentWebViewBinding
import com.example.amarbatch.utils.Constant

class WebView : Fragment() {
    private lateinit var v: FragmentWebViewBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        v = FragmentWebViewBinding.inflate(inflater, container, false)
        v.apply {
            webView.webViewClient = WebViewClient()
            webView.loadUrl(Constant.AMAR_BATCH_HOME_PAGE_URL)
            webView.settings.javaScriptEnabled = true
            webView.settings.setSupportZoom(true)
        }

        return v.root
    }
}