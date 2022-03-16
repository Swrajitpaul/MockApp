package io.github.swrajitpaul.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.github.swrajitpaul.R
import io.github.swrajitpaul.util.FileHelper

class DataRepository(val app: Application) {

    val aboutMeData = MutableLiveData<String>()
    val projectsData = MutableLiveData<List<Projects>>()

    init {
        getAboutMeText()
        getProjectList()
    }

    fun getAboutMeText() {
        aboutMeData.value  = FileHelper.readFileFromAssets(app, "aboutme.txt")
    }

    fun getProjectList() {
        val text = FileHelper.readFileFromResources(app, R.raw.project_name)
        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, Projects::class.java)
        val adapter: JsonAdapter<List<Projects>> = moshi.adapter(listType)
        val data = adapter.fromJson(text)
        projectsData.value = data ?: emptyList()
    }

}