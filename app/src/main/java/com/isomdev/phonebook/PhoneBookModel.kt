package com.isomdev.phonebook

class PhoneBookModel (val name:String,val isOnline:Boolean) {
    companion object{

        private var lastContactId = 0

        fun createPhoneBookList(numContacts:Int):ArrayList<PhoneBookModel>{
            val contact = ArrayList<PhoneBookModel>()

            for(i in 1..numContacts){
                contact.add(PhoneBookModel("Contact " + ++lastContactId, i <= numContacts / 2))
            }
            return  contact
        }
    }
}