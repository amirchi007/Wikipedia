package com.amir.wikipedia.dataclasses

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import android.telecom.Call.Details
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPost(
    val imgUrl: String,
    val txtTitle: String,
    val txtSubtitle: String,
    val txtDetails: String,

    // for trend fragment ->
    val isTrend: Boolean,
    val inSight: String
):Parcelable