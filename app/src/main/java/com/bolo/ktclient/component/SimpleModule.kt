package com.bolo.ktclient.component

import com.bolo.ktclient.annotation.ModelScope
import com.bolo.ktclient.model.IImageModel
import com.bolo.ktclient.model.ImageModelImpl
import com.bolo.ktclient.presenter.IImagePresenter
import com.bolo.ktclient.presenter.ImagePresenterImpl
import com.bolo.ktclient.ui.activity.MainActivity
import com.bolo.ktclient.view.IImageView
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Create by qinpc on 2018/3/23
 */
@ModelScope
@Component(dependencies = [(ActivityComponent::class)], modules = [(SimpleModule::class)])
interface SimpleComponent {
    fun inject(activity: MainActivity)
}

@Module
class SimpleModule(val view: IImageView) {

    @Named(value = "image")
    @ModelScope
    @Provides
    fun providerPresenter(presenterImpl: ImagePresenterImpl) : IImagePresenter {
        return presenterImpl
    }

    @ModelScope
    @Provides
    fun providerView(): IImageView {
        return view
    }

    @ModelScope
    @Provides
    fun providerImageModel(modelImpl: ImageModelImpl): IImageModel {
        return modelImpl
    }
}
