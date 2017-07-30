package cn.edu.ncist.eyepetizer.ui

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import cn.edu.ncist.eyepetizer.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initAnimation()
        initData()
    }

    private fun initAnimation() {
        val scaleAnimation : ScaleAnimation = ScaleAnimation(0.1f,1.0f,0.1f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        scaleAnimation.duration= 1000

        val alphaAnimation :AlphaAnimation = AlphaAnimation(0.1f,1.0f)
        alphaAnimation.duration = 1000

        val animationSet : AnimationSet = AnimationSet(this,null)
        animationSet.addAnimation(scaleAnimation)
        animationSet.addAnimation(alphaAnimation)
        scaleAnimation.duration = 1000

        ic_icon_splash.animation = scaleAnimation
        scaleAnimation.start()

        scaleAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val intent : Intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
    }

    private fun initData() {
        val typeFace : Typeface = Typeface.createFromAsset(assets, "fonts/Lobster-1.4.otf")
        tv_eyes_english_name.typeface = typeFace
        tv_english_intro.typeface = typeFace
    }
}
