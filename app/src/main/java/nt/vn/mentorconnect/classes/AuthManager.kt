package nt.vn.mentorconnect.classes

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import nt.vn.mentorconnect.AdminControlPanel
import nt.vn.mentorconnect.HomeActivity
import nt.vn.mentorconnect.MenteesDashboardActivity
import nt.vn.mentorconnect.models.User

class AuthManager {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance().getReference("users")

    fun registerUser(context: Context, username: String, email:String, password: String, role: String, callback: (Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = task.result.user!!.uid
                    val user = User(userId!!, email,username, role, true)
                    database.child(userId).setValue(user)
                    callback(true)

                } else {
                    Toast.makeText(context,task.exception!!.message.toString(),Toast.LENGTH_LONG).show()
                    callback(false)
                }
            }
    }

    fun loginUser(context:Context,email: String, password: String, callback: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful)
                {
                callback(task.isSuccessful)
                FirebaseDatabase.getInstance().reference.child("users").child(task.result.user!!.uid).child("role").addValueEventListener(object:ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.value == "MENTEE") {
                            context.startActivity(Intent(context, MenteesDashboardActivity::class.java))
                            Toast.makeText(context, "You are a mentee", Toast.LENGTH_LONG).show()
                        } else if (snapshot.value == "MENTOR") {
                            context.startActivity(Intent(context, HomeActivity::class.java))
                            Toast.makeText(context, "You are a mentor", Toast.LENGTH_LONG).show()
                        } else if (snapshot.value == "admin") {
                            context.startActivity(Intent(context, AdminControlPanel::class.java))
                            Toast.makeText(context, "You are an admin", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(context, "Could not determine role", Toast.LENGTH_LONG)
                                .show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
            }
                else {
                    callback(task.isCanceled)
                }
                }
    }

    fun logoutUser() {
        auth.signOut()
    }
}
