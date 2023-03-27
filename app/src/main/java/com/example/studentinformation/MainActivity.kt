package com.example.studentinformation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_achievements_page.*
import kotlinx.android.synthetic.main.activity_education_page.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_skills_page.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEducation.setOnClickListener {
            Intent(this, EducationPage::class.java).also {
                startActivity(it)
            }
        }

        btnSkills.setOnClickListener {
            Intent(this, SkillsPage::class.java).also {
                startActivity(it)
            }
        }

        btnAchievements.setOnClickListener {
            Intent(this, AchievementsPage::class.java).also {
                startActivity(it)
            }
        }

        val btnExit = findViewById<Button>(R.id.btnExit)
        btnExit.setOnClickListener {
            finish()
        }
    }
}

