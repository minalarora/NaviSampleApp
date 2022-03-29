package com.minal.navisampleapp

import android.app.Application
import android.app.Activity
import com.minal.navisampleapp.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class NaviApplication: Application(), HasActivityInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

    }

    override fun activityInjector() = dispatchingAndroidInjector
}