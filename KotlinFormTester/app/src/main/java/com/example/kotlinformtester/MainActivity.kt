package com.example.kotlinformtester

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinformtester.ui.theme.KotlinFormTesterTheme
import com.example.kotlinformtester.utils.FormValidator
import com.example.kotlinformtester.models.UserForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinFormTesterTheme {
                FormScreen { userForm ->
                    if (FormValidator.isValidForm(userForm)) {
                        Toast.makeText(this, "Form Submitted Successfully!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Form contains errors!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@Composable
fun FormScreen(onSubmit: (UserForm) -> Unit) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var occupation by remember { mutableStateOf("") }
    var aadharNumber by remember { mutableStateOf("") }
    var panCardNumber by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Input Fields
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name")}, singleLine = true)
        OutlinedTextField(value = surname, onValueChange = { surname = it }, label = { Text("Surname") }, singleLine = true)
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        OutlinedTextField(value = gender, onValueChange = { gender = it }, label = { Text("Gender") }, singleLine = true)
        OutlinedTextField(value = education, onValueChange = { education = it }, label = { Text("Education") }, singleLine = true)
        OutlinedTextField(value = city, onValueChange = { city = it }, label = { Text("city")}, singleLine = true)
        OutlinedTextField(value = occupation, onValueChange = { occupation = it }, label = { Text("Occupation") }, singleLine = true)
        OutlinedTextField(
            value = aadharNumber,
            onValueChange = { aadharNumber = it },
            label = { Text("Aadhar Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        OutlinedTextField(value = panCardNumber, onValueChange = { panCardNumber = it }, label = { Text("PAN Card Number") }, singleLine = true)

        // Error Message Display
        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, color = Color.Red)
        }

        // Submit Button
        Button(
            onClick = {
                val userForm = UserForm(
                    name, surname, phoneNumber, email,
                    age.toIntOrNull() ?: 0, gender, education, city, occupation, aadharNumber, panCardNumber
                )
                if (FormValidator.isValidForm(userForm)) {
                    errorMessage = ""
                    onSubmit(userForm)
                } else {
                    errorMessage = "Please enter valid details!"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFormScreen() {
    KotlinFormTesterTheme {
        FormScreen { }
    }
}
