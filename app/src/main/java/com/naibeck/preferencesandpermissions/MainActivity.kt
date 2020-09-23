package com.naibeck.preferencesandpermissions

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.naibeck.preferencesandpermissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    val preferences: SharedPreferences by lazy {
        this.getSharedPreferences(UDB_PREFS, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.let {
            val username = it.usernameInput.text.toString()
            val password = it.passwordInput.text.toString()
            it.signUpButton.setOnClickListener {
                storeCredentials(username, password)
            }
        }
    }

    private fun storeCredentials(username: String, password: String) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val UDB_PREFS = "udb.prefs"
    }
}