package nt.vn.mentorconnect.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nt.vn.mentorconnect.R
import nt.vn.mentorconnect.models.Mentor

class MentorAdapter(private var mentorList: List<Mentor>) : RecyclerView.Adapter<MentorAdapter.MentorViewHolder>() {

    class MentorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val skillTextView: TextView = view.findViewById(R.id.skillTextView)
        val expertiseTextView: TextView = view.findViewById(R.id.expertiseTextView)
        val experienceTextView: TextView = view.findViewById(R.id.experienceTextView)
        val ratingTextView: TextView = view.findViewById(R.id.ratingTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mentor_item, parent, false)
        return MentorViewHolder(view)
    }

    override fun onBindViewHolder(holder: MentorViewHolder, position: Int) {
        val mentor = mentorList[position]
        holder.nameTextView.text = mentor.name
        holder.skillTextView.text = mentor.skill
        holder.expertiseTextView.text = mentor.expertise
        holder.experienceTextView.text = "Experience: ${mentor.experience} years"
        holder.ratingTextView.text = "Rating: ${mentor.rating}"
    }

    override fun getItemCount(): Int {
        return mentorList.size
    }

    fun updateData(newMentorList: List<Mentor>) {
        mentorList = newMentorList
        notifyDataSetChanged()
    }
}

