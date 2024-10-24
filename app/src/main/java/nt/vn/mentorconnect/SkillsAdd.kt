package nt.vn.mentorconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nt.vn.mentorconnect.classes.SkillsAdapter
import nt.vn.mentorconnect.models.Skill

class SkillsAdd : AppCompatActivity() {
    private lateinit var skillsList:ArrayList<Skill>
    private lateinit var adapter:SkillsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills_add)
        skillsList = arrayListOf<Skill>()
        skillsList.add(Skill(name = "kotlin"))
        skillsList.add(Skill(name = "Java"))
        skillsList.add(Skill(name = "C++"))
        skillsList.add(Skill(name = "Entrepreurship"))
        skillsList.add(Skill(name = "Business Management"))
        skillsList.add(Skill(name = "Web design"))
        val rv:RecyclerView=findViewById(R.id.rvSkills)
        rv.layoutManager=GridLayoutManager(this,2)
        adapter=SkillsAdapter(skillsList)
        rv.adapter=adapter
        val searchBar:EditText=findViewById(R.id.searchSkill)
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterSkill(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
    private fun filterSkill(query: String) {
        val filteredList = skillsList.filter { Skill ->
            Skill.name.contains(query, ignoreCase = true)
        }
        adapter.updateData(filteredList)
    }
}