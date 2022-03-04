package io.github.swrajitpaul.util

import android.content.Context

class FileHelper {

    companion object {
        fun getAboutMeText(context: Context, file: String): String {
            return context.assets.open(file).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }
    }
}