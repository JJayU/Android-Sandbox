package com.example.tiptime

import junit.framework.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests{

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.0
        val tipPercent = 20.0
        val expectedTip = "2,00\u00A0zł"

        val actualTip = calculateTip(amount, tipPercent, false)

        assertEquals(expectedTip, actualTip)
    }

}