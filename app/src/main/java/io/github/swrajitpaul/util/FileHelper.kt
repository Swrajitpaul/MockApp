package io.github.swrajitpaul.util

import android.content.Context

class FileHelper {

    companion object {
        fun readFileFromAssets(context: Context, file: String): String {
            return context.assets.open(file).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }

        fun readFileFromResources(context: Context, resourceId: Int): String {
            return context.resources.openRawResource(resourceId).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }

        }

    }
}