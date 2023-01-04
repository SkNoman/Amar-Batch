package com.example.amarbatch

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.amarbatch.ui.Login
import com.example.amarbatch.ui.WebView


var token = ""
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.Theme_AmarBatch)
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                    if (!isLocationEnabled()){
                        Toast.makeText(this,"Please Turn on Location and try again!",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        val webView = WebView()
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.frameLayout,webView)
                            commit()
                        }
                    }

                }
                permissions.getOrDefault(ACCESS_COARSE_LOCATION, false) -> {
                    Toast.makeText(this,"Precise Location Permission Required!",Toast.LENGTH_SHORT).show()
                    finish()
                } else -> {
                Toast.makeText(this,"Precise Location Permission Required!",Toast.LENGTH_SHORT).show()
                finish()
            }
            }
        }

        locationPermissionRequest.launch(arrayOf(
        ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION))

    }
    private fun isLocationEnabled():Boolean{
        val locationManager: LocationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER)
    }

}