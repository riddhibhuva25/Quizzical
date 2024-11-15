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
import com.example.quizzical.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var isAllFieldsChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initialization()
    }

    private fun initialization() {
        binding.btnLogin.setOnClickListener{
            isAllFieldsChecked = checkAllFields()

            if (isAllFieldsChecked){

                startActivity(Intent(this,MainActivity::class.java))

            }
        }

        binding.txtSignUpSmall.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))

        }
    }


    private fun checkAllFields(): Boolean {

        if (binding.edtEmailLogin.length() == 0) {
            binding.edtEmailLogin.error = "Email is required"
            Toast.makeText(this,"Please enter your email id",Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.edtPassLogin.length() == 0) {
            binding.edtPassLogin.error = "Password is required"
            Toast.makeText(this,"Please enter your password",Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.edtPassLogin.length() < 8) {
            binding.edtPassLogin.error = "Password must be minimum 8 characters"
            Toast.makeText(this,"Please enter your 8 digit password",Toast.LENGTH_SHORT).show()
            return false
        }

        // after all validation return true.
        return true
    }

}