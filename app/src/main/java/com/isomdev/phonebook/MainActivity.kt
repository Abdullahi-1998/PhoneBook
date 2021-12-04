package com.isomdev.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.isomdev.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // initializing viewBinding here
    private lateinit var binding:ActivityMainBinding

    private lateinit var contactList:ArrayList<PhoneBookModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the recyclerview id using viewBinding
        val recyclerview = binding.recyclerviewPhoneBook

        // initialize the contacts 0f 20 here
        contactList = PhoneBookModel.createPhoneBookList(20)

        // get the adapter and passing in the list of contacts to display
        val adapter = PhoneBookAdapter(contactList)

        //attach the adapter to the recyclerview to populate the list of contacts
        recyclerview.adapter = adapter

        // our contacts list will be displayed in a linear Format here LinearLayout
        recyclerview.layoutManager = LinearLayoutManager(this)

    }
}