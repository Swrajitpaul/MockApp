package io.github.swrajitpaul

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SharedViewModel(app: Application): AndroidViewModel(app) {

    var urlString = MutableLiveData<String>()

}