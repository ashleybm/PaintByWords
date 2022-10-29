package com.copeac.paintbywords.model

import java.sql.Date

data class RemainderBank(
    val reminderBankId: String,
    val lastUpdated: Date,
    val pictureId: String,
    val currentTotal: Int,
    val lastThreeUserDonations: List<String>?,
    val lifetimePictureTotal: Int
)