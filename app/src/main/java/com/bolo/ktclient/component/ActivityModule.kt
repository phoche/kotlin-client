package com.bolo.ktclient.component

import android.app.Activity
import com.bolo.library.BaseComponent
import com.bolo.ktclient.annotation.ActivityScope
import dagger.Component
import dagger.Module
import dagger.Provides

/**
 * Create by qinpc on 2018/3/26
 */
@ActivityScope
@Component(dependencies = [(BaseComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {
    fun activity(): Activity
}

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}