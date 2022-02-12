package com.uxstate.instagramui

import androidx.annotation.DrawableRes

data class ProfileData(@DrawableRes val imageId:Int, val posts: Int = 0, val followers: Int = 0, val following: Int = 0)
