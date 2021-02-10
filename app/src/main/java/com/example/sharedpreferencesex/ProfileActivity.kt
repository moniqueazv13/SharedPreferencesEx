package com.example.sharedpreferencesex

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initProfile(configSharedPrefs())
    }

    /* função para inicializar o profile do usuario*/
    private fun initProfile(prefs: SharedPreferences) {
        /*inicializa os textview*/
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvRegistration = findViewById<TextView>(R.id.tv_registration)

        /*pegando as configurações*/
        val showName = prefs.getBoolean(MainActivity.SHOW_NAME, true)
        val showRegistration = prefs.getBoolean(MainActivity.SHOW_REGISTRATION, true)

        tvName.text = "Monique"
        tvRegistration.text = "123456"

        /* visibility é o que faz mostrar ou esconder uma view*/
        tvName.visibility = if (showName) View.VISIBLE else View.GONE
        tvRegistration.visibility = if (showRegistration) View.VISIBLE else View.GONE
    }
        private fun configSharedPrefs() =
            getSharedPreferences(MainActivity.USER_PREFS,Context.MODE_PRIVATE)


    }


