package com.bluedigi.bluememo.app

import android.app.Application
import com.bluedigi.bluememo.di.AppContainer

class BlueMemoApplication : Application() {

    val appContainer: AppContainer by lazy {
        AppContainer()
    }
}