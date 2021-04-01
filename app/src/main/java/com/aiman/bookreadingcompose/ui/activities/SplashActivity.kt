package com.aiman.bookreadingcompose.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aiman.bookreadingcompose.R
import com.airbnb.lottie.LottieAnimationView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        lottieAnimationView = findViewById(R.id.lottie_animation_view)
        lottieAnimationView.setAnimation(R.raw.book_reading)

        MainScope().launch {
            delay(0)
            startActivity(Intent(this@SplashActivity, SampleActivity::class.java))
            finish()
        }

    }

}