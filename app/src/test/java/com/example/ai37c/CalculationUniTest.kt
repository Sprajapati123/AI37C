package com.example.ai37c

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

class CalculationUniTest {

    @Test
    fun add_test(){
        val calculations = Calculations()
        val result = calculations.add(5,5)
        assertEquals(9,result)
    }

    @Test
    fun add_testUsingMockito(){
        val calculations = mock(Calculations::class.java)

        `when`(calculations.add(5,5)).thenReturn(9)

        val result = calculations.add(5,5)

        assertEquals(9,result)
    }


}