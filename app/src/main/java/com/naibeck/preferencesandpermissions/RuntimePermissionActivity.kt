package com.naibeck.preferencesandpermissions

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_REQUEST -> {
                handleFineLocationPermission(grantResults)
            }
        }
    }

    private fun handleFineLocationPermission(grantResults: IntArray) {
        if (isFineLocationGranted(grantResults)) {
            Toast.makeText(this, "Location permission was granted", Toast.LENGTH_SHORT).show()
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_FINE_LOCATION)) {
                showLocationRationale()
            }
            Toast.makeText(this, "Location permission was not granted", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLocationRationale() {
        AlertDialog.Builder(this)
            .setTitle("Wanna know your position?")
            .setMessage("This application requires user's location to show users position on Map")
            .setPositiveButton("Ok") { _, _ -> requestRuntimePermission()}
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }

    private fun isFineLocationGranted(grantResults: IntArray) =
        grantResults[0] == PackageManager.PERMISSION_GRANTED

    private fun checkRuntimePermission() {
        TODO("Not yet implemented")
    }

    private fun requestRuntimePermission() {
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION), LOCATION_REQUEST)
    }

    companion object {
        const val LOCATION_REQUEST = 0
    }
}