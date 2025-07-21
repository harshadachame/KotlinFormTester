package com.example.kotlinformtester

import com.example.kotlinformtester.models.UserForm
import com.example.kotlinformtester.utils.FormValidator
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class FormValidatorTest {

    @Test
    fun testValidName() {
        assertTrue(FormValidator.isValidName("John"))
        assertFalse(FormValidator.isValidName("Jo")) // Too short
        assertFalse(FormValidator.isValidName("")) // Empty
    }

    @Test
    fun testValidPhoneNumber() {
        assertTrue(FormValidator.isValidPhoneNumber("9876543210"))
        assertFalse(FormValidator.isValidPhoneNumber("12345")) // Too short
        assertFalse(FormValidator.isValidPhoneNumber("abcdefghij")) // Invalid characters
    }

    @Test
    fun testValidEmail() {
        assertTrue(FormValidator.isValidEmail("test@example.com")) // Valid email
        assertFalse(FormValidator.isValidEmail("test@com")) // Invalid email (TLD missing)
        assertFalse(FormValidator.isValidEmail("test@.com")) // Invalid email (Missing domain)
        assertFalse(FormValidator.isValidEmail("test.com")) // Invalid email (Missing '@')
    }

    @Test
    fun testValidGender(){
        assertTrue(FormValidator.isValidGender("Male"))
        assertTrue(FormValidator.isValidGender("Female"))
        assertFalse(FormValidator.isValidGender("Other"))
    }
    @Test
    fun testValidAge() {
        assertTrue(FormValidator.isValidAge(25))
        assertFalse(FormValidator.isValidAge(17)) // Below minimum age
        assertFalse(FormValidator.isValidAge(100)) // Above maximum age
    }

    fun testValidCity() {
        assertTrue(FormValidator.isValidCity("New York"))
        assertFalse(FormValidator.isValidCity("New")) // Too short
        assertFalse(FormValidator.isValidCity("")) // Empty
    }

    fun testValidOccupation() {
        assertTrue(FormValidator.isValidOccupation("Engineer"))
        assertTrue(FormValidator.isValidOccupation("Doctor"))
        assertFalse(FormValidator.isValidOccupation("Student")) // Invalid occupation
    }

    @Test
    fun testValidAadhar() {
        assertTrue(FormValidator.isValidAadhar("123456789012"))
        assertFalse(FormValidator.isValidAadhar("1234567890")) // Less than 12 digits
    }

    @Test
    fun testValidPanCard() {
        assertTrue(FormValidator.isValidPanCard("ABCDE1234F"))
        assertFalse(FormValidator.isValidPanCard("12345ABCDE")) // Invalid format
    }

    @Test
    fun testValidForm() {
        val validUser = UserForm(
            name = "John",
            surname = "Doe",
            phoneNumber = "9876543210",
            email = "john.doe@example.com",
            age = 25,
            gender = "Male",
            education = "Graduate",
            city = "New York",
            occupation = "Engineer",
            aadharNumber = "123456789012",
            panCardNumber = "ABCDE1234F"
        )

        val invalidUser = UserForm(
            name = "Jo",
            surname = "D",
            phoneNumber = "123456",
            email = "john.doe@com",
            age = 16,
            gender = "",
            education = "High School",
            city = "new",
            occupation = "Student",
            aadharNumber = "123",
            panCardNumber = "12345ABCDE"
        )

        assertTrue(FormValidator.isValidForm(validUser))
        assertFalse(FormValidator.isValidForm(invalidUser))
    }
}
