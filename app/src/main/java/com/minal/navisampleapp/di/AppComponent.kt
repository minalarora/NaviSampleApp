package com.minal.navisampleapp.di

import android.app.Application
import com.minal.navisampleapp.NaviApplication
import com.minal.navisampleapp.di.git.GitActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        GitActivityModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: NaviApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: NaviApplication)
}