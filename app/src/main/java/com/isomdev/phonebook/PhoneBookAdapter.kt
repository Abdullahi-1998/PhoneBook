package com.isomdev.phonebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isomdev.phonebook.databinding.PhonebookCustomListLayoutBinding

class PhoneBookAdapter(private var contactList:List<PhoneBookModel>) : RecyclerView.Adapter<PhoneBookAdapter.ViewHolder>(){
    class ViewHolder(private val phonebookCustomListLayoutBinding: PhonebookCustomListLayoutBinding) : RecyclerView.ViewHolder(phonebookCustomListLayoutBinding.root) {
       val customName = phonebookCustomListLayoutBinding.contactName
       val messageButton = phonebookCustomListLayoutBinding.messageButton
    }

    // inflate the layout here for our custom layout phonebook_custom_list_layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PhonebookCustomListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    // here we populate our views with data from our phonebook model
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]

        // set the text name
        val textview = holder.customName
        textview.text = contact.name

        //set the button
        val button = holder.messageButton
        button.text = if(contact.isOnline) "Message" else "Offline"
        button.isEnabled = contact.isOnline
    }

    //get the size of the contactList
    override fun getItemCount(): Int {
        return contactList.size
    }
}