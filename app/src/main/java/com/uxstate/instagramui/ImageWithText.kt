package com.uxstate.instagramui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class ImageWithText(@DrawableRes val imageId: Int, val text:String) {
}