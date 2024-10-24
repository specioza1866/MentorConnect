package nt.vn.mentorconnect.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import nt.vn.mentorconnect.R
import nt.vn.mentorconnect.models.Mentor
import nt.vn.mentorconnect.models.Skill

class SkillsAdapter(private var skillsList: List<Skill>) : RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>() {

    class SkillsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
        return SkillsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val skill = skillsList[position]
        holder.nameTextView.text=skill.name
        holder.itemView.setOnClickListener {
            val dialogView=LayoutInflater.from(holder.itemView.context).inflate(R.layout.dialog_skill_levels,null)
            val alertDialog=AlertDialog.Builder(holder.itemView.context)
            alertDialog.setView(dialogView)
            alertDialog.show()
        }

    }

    override fun getItemCount(): Int {
        return skillsList.size
    }

    fun updateData(newSkillsList: List<Skill>) {
        skillsList = newSkillsList
        notifyDataSetChanged()
    }
}

