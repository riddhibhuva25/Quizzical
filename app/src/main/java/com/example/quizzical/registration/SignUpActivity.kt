package com.example.quizzical.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizzical.MainActivity
import com.example.quizzical.R
import com.example.quizzical.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    var isAllFieldsChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainS)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initialization()
    }

    private fun initialization() {


        binding.btnLogin.setOnClickListener {
            isAllFieldsChecked = CheckAllFields()

            if (isAllFieldsChecked) {

                startActivity(Intent(this, MainActivity::class.java))

            }
        }


        binding.txtLogInSmall.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))

        }

    }


    private fun CheckAllFields(): Boolean {
        if (binding.edtFirstName.length() == 0){
            binding.edtFirstName.error = "Enter your name"
            Toast.makeText(this,"Please enter your first name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.edtLastName.length() == 0){
            binding.edtLastName.error = "Enter your name"
            Toast.makeText(this,"Please enter your last name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.edtEmailSignUp.length() == 0) {
            binding.edtEmailSignUp.error = "Email is required"
            Toast.makeText(this,"Please enter your email id", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.edtPassSignUp.length() == 0) {
            binding.edtPassSignUp.error = "Password is required"
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.edtPassSignUp.length() < 8) {
            binding.edtPassSignUp.error = "Password must be minimum 8 characters"
            Toast.makeText(this,"Please enter your 8 digit password", Toast.LENGTH_SHORT).show()
            return false
        }

        // after all validation return true.
        return true
    }
}