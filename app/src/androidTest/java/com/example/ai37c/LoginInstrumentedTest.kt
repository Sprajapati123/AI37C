package com.example.ai37c

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.After

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<LoginActivity>()

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    // Given Login Screen
    // When user clicks on Don't have an account?
    //Then user should navigate to RegistrationActivity
    @Test
    fun registration_button_test() {


        composeRule.onNodeWithTag("email")
            .performTextInput("ram@gmail.com")

        composeRule.onNodeWithTag("password")
            .performTextInput("password")

        composeRule.onNodeWithTag("login")
            .performClick()


        Intents.intended(hasComponent(DashboardActivity::class.java.name))
    }

}