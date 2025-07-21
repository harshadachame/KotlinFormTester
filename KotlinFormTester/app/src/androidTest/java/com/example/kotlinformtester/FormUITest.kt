package com.example.kotlinformtester

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     *  Test Case for Valid Form Submission
     * Expected Outcome: Success message should be displayed
     */
    @Test
    fun testValidFormSubmission() {
        // Enter Name (Valid)
        onView(withHint("Name")).perform(typeText("Harshada"), closeSoftKeyboard())

        // Enter Surname (Valid)
        onView(withHint("Surname")).perform(typeText("Chame"), closeSoftKeyboard())

        // Enter Email (Valid)
        onView(withHint("Email")).perform(typeText("harshadachame@example.com"), closeSoftKeyboard())

        // Enter Phone Number (Valid)
        onView(withHint("Phone Number")).perform(typeText("9876543210"), closeSoftKeyboard())

        // Enter Age (Valid)
        onView(withHint("age")).perform(typeText("20"), closeSoftKeyboard())

        // Enter Gender (Valid)
        onView(withHint("gender")).perform(typeText("Female"), closeSoftKeyboard())

        // Enter Education (Valid)
        onView(withHint("education")).perform(typeText("Bachelor's Degree"), closeSoftKeyboard())

        // Enter City (Valid)
        onView(withHint("city")).perform(typeText("Mumbai"), closeSoftKeyboard())

        // Enter Occupation (Valid)
        onView(withHint("Occupation")).perform(typeText("Engineer"), closeSoftKeyboard())

        // Enter Aadhar Number (Valid)
        onView(withHint("Aadhar Number")).perform(typeText("123456789012"), closeSoftKeyboard())

        // Enter PAN Card Number (Valid)
        onView(withHint("PAN Card Number")).perform(typeText("ABCDE1234F"), closeSoftKeyboard())

        // Click Submit
        onView(withText("Submit")).perform(click())

        // ✅ Check if success message is displayed
        onView(withText("Form Submitted Successfully!")).check(matches(isDisplayed()))
    }

    /**
     *  Test Case for Invalid Form Submission
     * Expected Outcome: Error message should be displayed
     */
    @Test
    fun testInvalidFormSubmission() {
        // Enter Name (Invalid: Too Short)
        onView(withHint("Name")).perform(typeText("H"), closeSoftKeyboard())

        // Enter Surname (Invalid)
        onView(withHint("Surname")).perform(typeText("C"), closeSoftKeyboard())

        // Enter Email (Invalid: Missing '@')
        onView(withHint("Email")).perform(typeText("harshada.com"), closeSoftKeyboard())

        // Enter Phone Number (Invalid: Too Short)
        onView(withHint("Phone Number")).perform(typeText("12345"), closeSoftKeyboard())

        // Enter Age (Invalid: Below 18)
        onView(withHint("age")).perform(typeText("15"), closeSoftKeyboard())

        // Enter Gender (Invalid: Random Text)
        onView(withHint("gender")).perform(typeText("Unknown"), closeSoftKeyboard())

        // Enter Education (Valid)
        onView(withHint("education")).perform(typeText("High School"), closeSoftKeyboard())

        // Enter City (Invalid: Too Short)
        onView(withHint("city")).perform(typeText("NY"), closeSoftKeyboard())

        // Enter Occupation (Invalid: Not Allowed)
        onView(withHint("Occupation")).perform(typeText("Student"), closeSoftKeyboard())

        // Enter Aadhar Number (Invalid: Too Short)
        onView(withHint("Aadhar Number")).perform(typeText("12345"), closeSoftKeyboard())

        // Enter PAN Card Number (Invalid: Incorrect Format)
        onView(withHint("PAN Card Number")).perform(typeText("12345ABCDE"), closeSoftKeyboard())

        // Click Submit
        onView(withText("Submit")).perform(click())

        //  Check if error message is displayed
        onView(withText("Please enter valid details!")).check(matches(isDisplayed()))
    }
}
