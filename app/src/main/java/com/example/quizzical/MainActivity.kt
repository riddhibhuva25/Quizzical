package com.example.quizzical

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.quizzical.adapter.ViewPagerAdapter
import com.example.quizzical.databinding.ActivityMainBinding
import com.example.quizzical.fragments.HomeFragment
import com.example.quizzical.fragments.ProfileFragment
import com.example.quizzical.fragments.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        window.statusBarColor = this.resources.getColor(R.color.orange)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val fragments = listOf(HomeFragment(), ProfileFragment(), SettingFragment()) // Replace with your fragment instances
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.profile -> {
                    Toast.makeText(this,"profile",Toast.LENGTH_SHORT).show()
                    viewPager.currentItem = 0


                    true
                }
                R.id.home -> {
                    Toast.makeText(this,"home",Toast.LENGTH_SHORT).show()
                    viewPager.currentItem = 1
                    true
                }

                R.id.setting-> {
                    Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show()
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
    }

    }
