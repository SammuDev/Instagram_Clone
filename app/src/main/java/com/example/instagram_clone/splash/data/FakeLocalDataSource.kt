package com.example.instagram_clone.splash.data

import com.example.instagram_clone.common.model.Database

class FakeLocalDataSource : SplashDataSource {
    override fun session(callback: SplashCallback) {
        if (Database.sessionAuth != null) {
            callback.onSuccess()
        } else {
            callback.onFailure()
        }
    }
}
