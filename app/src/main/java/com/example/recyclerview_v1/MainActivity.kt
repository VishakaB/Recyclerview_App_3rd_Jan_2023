package com.example.recyclerview_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Person(val name: String, val age: Int )

class MainActivity : AppCompatActivity() {
    private lateinit var contacts: MutableList<Person>
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //defined the data required for the application
        contacts = createContacts()

        //define an adapter will connect the data with the dynamic screen
        adapter = ContactAdapter(this,contacts)

        val recyclerView: RecyclerView = findViewById(R.id.rvcontacts)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun createContacts(): MutableList<Person> {
        val contacts = mutableListOf<Person>()
        for (i in 1 .. 20)
        {
           contacts.add(Person("Person $i",i ))
        }
        return contacts
    }

}