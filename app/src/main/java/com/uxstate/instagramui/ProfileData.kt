package com.uxstate.instagramui

import androidx.annotation.DrawableRes

data class ProfileData(@DrawableRes val image :Int, val posts: Int, val followers: Int, val following: Int)
