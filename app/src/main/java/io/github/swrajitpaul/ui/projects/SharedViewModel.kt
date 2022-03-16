package io.github.swrajitpaul.ui.projects

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.github.swrajitpaul.data.DataRepository
import io.github.swrajitpaul.data.Projects

class SharedViewModel(val app: Application): AndroidViewModel(app) {

    private val dataRepository = DataRepository(app)

    val projectsList = dataRepository.projectsData

    val project = MutableLiveData<Projects>()
}