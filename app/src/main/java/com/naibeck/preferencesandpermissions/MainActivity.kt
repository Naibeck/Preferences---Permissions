package com.naibeck.preferencesandpermissions

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.naibeck.preferencesandpermissions.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    val preferences: SharedPreferences by lazy {
        this.getSharedPreferences(UDB_PREFS, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.let { binding ->
            binding.signUpButton.setOnClickListener {
                storeCredentials(binding.usernameInput.text.toString(), binding.passwordInput.text.toString())
            }
        }
    }

    private fun storeCredentials(username: String, password: String) {
        preferences.edit()
            .putString(USERNAME, username)
            .putString(PASSWORD, password)
            .apply()
    }

    companion object {
        private const val UDB_PREFS = "udb.prefs"
        private const val USERNAME = "username"
        private const val PASSWORD = "password"
    }
}