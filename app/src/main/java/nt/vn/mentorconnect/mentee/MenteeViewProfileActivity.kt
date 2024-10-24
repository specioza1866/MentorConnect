package nt.vn.mentorconnect.mentee


import nt.vn.mentorconnect.R
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenteeViewProfileActivity : AppCompatActivity() {

    private lateinit var menteeImageView: ImageView
    private lateinit var menteeNameTextView: TextView
    private lateinit var menteeGoalsTextView: TextView
    private lateinit var menteeSkillsTextView: TextView
    private lateinit var menteeProgressTextView: TextView
    private lateinit var contactMentorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentee_view_profile)

        menteeImageView = findViewById(R.id.mentee_profile_image)
        menteeNameTextView = findViewById(R.id.mentee_name)
        menteeGoalsTextView = findViewById(R.id.mentee_goals)
        menteeSkillsTextView = findViewById(R.id.mentee_skills)
        menteeProgressTextView = findViewById(R.id.mentee_progress)
        contactMentorButton = findViewById(R.id.btn_contact_mentor)

        // Example: Filling data (normally, this would come from a database or API)
        val menteeName = "Jane Doe"
        val menteeGoals = "Become proficient in Android Development"
        val menteeSkills = "Kotlin, UI/UX, Problem-Solving"
        val menteeProgress = "Completed 3 projects in Android Development"

        // Set profile details
        menteeNameTextView.text = menteeName
        menteeGoalsTextView.text = menteeGoals
        menteeSkillsTextView.text = menteeSkills
        menteeProgressTextView.text = menteeProgress

        // Handle Contact Mentor Button click
        contactMentorButton.setOnClickListener {
            Toast.makeText(this, "Contacting Mentor...", Toast.LENGTH_SHORT).show()
            // Logic for contacting mentor (e.g., open email intent or messaging)
        }
    }
}
