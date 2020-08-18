package com.example.myapplication

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tbruyelle.rxpermissions3.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp = getSharedPreferences("config", Context.MODE_PRIVATE)
        btnOK.setOnClickListener {
            val str = etPackage.text.toString()
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(this, "请输入包名!", Toast.LENGTH_LONG).show()
            } else {
                sp.edit().putString("pkg", str).commit()
                Toast.makeText(this, "成功!", Toast.LENGTH_LONG).show()
            }
        }
        val packageName = sp.getString("pkg", "")
        if (TextUtils.isEmpty(packageName)) {
            tvTitle.text = "请输入应用包名,如:com.amazon.kindlefc"
        } else {
            val intent = packageManager.getLaunchIntentForPackage(packageName!!)
            startActivity(intent)
            finish()
        }
    }

}