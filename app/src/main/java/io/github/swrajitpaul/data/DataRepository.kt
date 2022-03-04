package io.github.swrajitpaul.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import io.github.swrajitpaul.util.FileHelper

class DataRepository(val app: Application) {

    var aboutMeData = MutableLiveData<String>()

    init {
        getAboutMeText()
    }

    fun getAboutMeText() {
        aboutMeData.value  = FileHelper.getAboutMeText(app, "aboutme.txt")
    }
}