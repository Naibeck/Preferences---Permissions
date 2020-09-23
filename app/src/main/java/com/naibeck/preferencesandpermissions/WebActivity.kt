package com.naibeck.preferencesandpermissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.naibeck.preferencesandpermissions.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityWebBinding = DataBindingUtil.setContentView(this, R.layout.activity_web)
        binding.webClient.loadUrl("https://www.google.com/")
    }
}