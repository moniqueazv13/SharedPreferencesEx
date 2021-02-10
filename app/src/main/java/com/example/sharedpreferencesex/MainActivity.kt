package com.example.sharedpreferencesex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    /*utiliza-se companion object para acessar atributos e funções sem instancear*/
    companion object {
        const val USER_PREFS = "USER_PREFS"
        const val SHOW_NAME = "show_name"
        const val SHOW_REGISTRATION = "show_registration"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = configSharedPrefs()
        configViews(shared)
    }

    private fun configViews(prefs: SharedPreferences) {

        val nameSwitch = findViewById<SwitchCompat>(R.id.sw_name)
        val regSwitch = findViewById<SwitchCompat>(R.id.sw_registration)
        val btProfile = findViewById<AppCompatButton>(R.id.bt_profile)

        /*função verifica se está ligado ou desligado o switch*/

        nameSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_NAME, isChecked).apply()
            /*quando eu clico, chamo o pref.edit, através do edit nós podemos colocar vários
            * tipos de valor*/
        }
        regSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_REGISTRATION, isChecked).apply()
            /*o apply está salvando os valores*/

        }

        btProfile.setOnClickListener {
            val intet = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }

    private fun configSharedPrefs() = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
}

