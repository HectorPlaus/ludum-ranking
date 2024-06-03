package com.ninesevenclub.ludumranking.utils

import android.content.Intent
import android.net.Uri

fun openInBrowser(url: String) {
    val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(webIntent)
}