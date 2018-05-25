package com.bolo.ktclient.presenter

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.bolo.ktclient.model.IImageModel
import com.bolo.ktclient.model.SimpleImageModel
import com.bolo.ktclient.view.IImageView
import javax.inject.Inject

/**
 * Create by qinpc on 2018/3/23
 */
class ImagePresenterImpl : IImagePresenter {

    private val mView: IImageView

    private val mViewModel: SimpleImageModel

    private val mLiveData: MutableLiveData<String>

    private var mImageLiveDate: MutableLiveData<String>? = null


    @Inject
    lateinit var mImageModelImpl: IImageModel

    @Inject
    constructor(view: IImageView) {
        mView = view
        mViewModel = ViewModelProviders
                .of(mView as android.support.v4.app.FragmentActivity)
                .get(SimpleImageModel::class.java)
        mLiveData = mViewModel.getLiveData()
    }


    override fun loadImage(lifecycleOwner: LifecycleOwner) {
        mImageLiveDate = mImageModelImpl.getLiveData()
        mImageLiveDate?.observe(lifecycleOwner, Observer {
            it?.let {
                mView.showText(it)
            }
        })


        mLiveData.observe(lifecycleOwner, Observer { t ->
            t?.let {
                mView.showImage(t)
            }
        })
        mImageModelImpl.sendRequest()
        mViewModel.sendRequest()
    }

    override fun loadSuccess() {
//        view.showImage()
    }
}