package nt.vn.mentorconnect.mentor


import nt.vn.mentorconnect.R
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MentorViewProfile : AppCompatActivity() {

    private lateinit var mentorImageView: ImageView
    private lateinit var mentorNameTextView: TextView
    private lateinit var mentorTitleTextView: TextView
    private lateinit var mentorExperienceTextView: TextView
    private lateinit var mentorSkillsTextView: TextView
    private lateinit var mentorAvailabilityTextView: TextView
    private lateinit var mentorBioTextView: TextView
    private lateinit var contactButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentor_view_profile)

        mentorImageView = findViewById(R.id.mentor_profile_image)
        mentorNameTextView = findViewById(R.id.mentor_name)
        mentorTitleTextView = findViewById(R.id.mentor_title)
        mentorExperienceTextView = findViewById(R.id.mentor_experience)
        mentorSkillsTextView = findViewById(R.id.mentor_skills)
        mentorAvailabilityTextView = findViewById(R.id.mentor_availability)
        mentorBioTextView = findViewById(R.id.mentor_bio)
        contactButton = findViewById(R.id.btn_contact_mentor)

        // Example: Filling data (normally, this would come from a database or API)
        val mentorName = "John Doe"
        val mentorTitle = "Software Developer"
        val mentorExperience = "5 years"
        val mentorSkills = "Java, Kotlin, Android"
        val mentorAvailability = "Weekends"
        val mentorBio = "Passionate about mentoring junior developers and sharing knowledge in software development."

        // Set profile details
        mentorNameTextView.text = mentorName
        mentorTitleTextView.text = mentorTitle
        mentorExperienceTextView.text = "Experience: $mentorExperience"
        mentorSkillsTextView.text = mentorSkills
        mentorAvailabilityTextView.text = mentorAvailability
        mentorBioTextView.text = mentorBio

        // Handle Contact Button click
        contactButton.setOnClickListener {
            Toast.makeText(this, "Contacting Mentor...", Toast.LENGTH_SHORT).show()
            // Logic for contacting mentor (e.g., open email intent or messaging)
        }
    }
}
