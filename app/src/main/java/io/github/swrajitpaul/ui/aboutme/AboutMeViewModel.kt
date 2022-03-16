package io.github.swrajitpaul.ui.aboutme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.github.swrajitpaul.data.DataRepository

class AboutMeViewModel(val app: Application): AndroidViewModel(app){

    private val dataRepo = DataRepository(app)

    val aboutMeData = dataRepo.aboutMeData
}