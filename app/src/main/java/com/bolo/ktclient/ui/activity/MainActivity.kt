package com.bolo.ktclient.ui.activity

import android.content.Intent
import android.os.Bundle
import com.bolo.ktclient.component.SimpleModule
import com.bolo.ktclient.observer.ClientLifecycleObserver
import com.bolo.ktclient.presenter.IImagePresenter
import com.bolo.ktclient.utils.IntentExtraStringDelegate
import com.bolo.ktclient.view.IImageView
import com.bolo.library.utils.click
import com.bolo.library.utils.load
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity(), IImageView {

    companion object IntentOptions {

        private const val MSG_KEY = "message key"

        var Intent.message  by IntentExtraStringDelegate(MSG_KEY)
    }

    private val imageUrl = "https://www.baidu.com/img/bd_logo1.png"

    @field:[Named ("image")]
    @Inject
    lateinit var mImagePresenter: IImagePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initInjection()
        lifecycle.addObserver(ClientLifecycleObserver())

        intent.message = ""

        appname.click {
            mImagePresenter.loadImage(this)
            load {
                url = "https://sdkcdn.videojj.com/upload_img/f6nf34_1514534777747.jpeg"
                image = imageview
            }

        }
    }

    private fun initInjection() {
        DaggerSimpleComponent.builder()
                .activityComponent(mActivityComponent)
                .simpleModule(SimpleModule(this))
                .build()
                .inject(this)
    }

    override fun showImage(msg: String) {
        result.text = msg

    }

    override fun showText(msg: String) {
        result2.text = msg
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
