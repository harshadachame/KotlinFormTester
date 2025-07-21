package com.example.kotlinformtester.utils

import com.example.kotlinformtester.models.UserForm

object FormValidator {

    fun isValidName(name: String): Boolean {
        return name.isNotEmpty() && name.length >= 3
    }

    fun isValidPhoneNumber(phone: String): Boolean {
        return phone.matches(Regex("^[6-9]\\d{9}$")) // Validates Indian phone numbers
    }

    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrBlank()) return false
        // Corrected regex pattern
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        return email.matches(Regex(emailRegex))
    }

    fun isValidGender(gender: String): Boolean {
        return gender.equals("male", ignoreCase = true) ||
                gender.equals("female", ignoreCase = true) ||
                gender.equals("other", ignoreCase = true)
    }

    fun isValidAge(age: Int): Boolean {
        return age in 18..99
    }

    fun isValidCity(city: String): Boolean {
        return city.isNotEmpty()
    }

    fun isValidOccupation(occupation: String): Boolean {
        return occupation.isNotEmpty()
    }

    fun isValidAadhar(aadhar: String): Boolean {
        return aadhar.matches(Regex("^\\d{12}$")) // 12-digit Aadhar validation
    }

    fun isValidPanCard(pan: String): Boolean {
        return pan.matches(Regex("^[A-Z]{5}[0-9]{4}[A-Z]{1}$")) // PAN card format
    }

    fun isValidForm(userForm: UserForm): Boolean {
        return isValidName(userForm.name) &&
                isValidName(userForm.surname) &&
                isValidPhoneNumber(userForm.phoneNumber) &&
                isValidEmail(userForm.email) &&
                isValidAge(userForm.age) &&
                isValidCity(userForm.city) &&
                isValidOccupation(userForm.occupation) &&
                isValidAadhar(userForm.aadharNumber) &&
                isValidPanCard(userForm.panCardNumber)
    }
}
