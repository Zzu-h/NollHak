package com.hackerton.jureumuing.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import com.hackerton.jureumuing.utils.FileUtil
import javax.inject.Inject

class LocalPathUtil @Inject constructor(
    private val context: Context
) {
    fun getRealPathFromUriString(contentUri: String): String? =
        getRealPathFromUri(Uri.parse(contentUri))

    @SuppressLint("Recycle")
    fun getRealPathFromUri(uri: Uri): String? =
        FileUtil.getPath(context, uri)
}