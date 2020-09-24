package com.naibeck.preferencesandpermissions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.naibeck.preferencesandpermissions.databinding.ActivityRuntimePermissionBinding

class RuntimePermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRuntimePermissionBinding = DataBindingUtil.setContentView(this, R.layout.activity_runtime_permission)
        binding.requestRuntimeAction.setOnClickListener {
            requestRuntimePermission()
        }
        binding.checkRuntimeAction.setOnClickListener {
            checkRuntimePermission()
        }
    }

    private fun checkRuntimePermission() {
        TODO("Not yet implemented")
    }

    private fun requestRuntimePermission() {
        TODO("Not yet implemented")
    }
}