package imt.respect.chatapp8.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.*
import imt.respect.chatapp8.R
import imt.respect.chatapp8.adapters.UserAdapter
import imt.respect.chatapp8.databinding.FragmentHomeBinding
import imt.respect.chatapp8.models.User

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var userReference:DatabaseReference
    private lateinit var userAdapter : UserAdapter
    private lateinit var list: ArrayList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        list = ArrayList()

        database = FirebaseDatabase.getInstance()
        userReference = database.getReference("users")
        userAdapter = UserAdapter(list)
        binding.rvUsers.adapter = userAdapter

        loadData()
        return binding.root

    }

    private fun loadData() {
        userReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                val children = snapshot.children
                for ( child in children) {
                    val value = child.getValue(User::class.java)
                    if (value!=null){
                        list.add(value)
                    }
                }
                userAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
            }
        })
    }
}