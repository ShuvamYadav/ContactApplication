package com.losung.contactApplication.service;

import com.losung.contactApplication.entity.Contact;
import com.losung.contactApplication.exceptions.ContactNotFoundException;
import com.losung.contactApplication.exceptions.EmailNotUniqueException;
import com.losung.contactApplication.exceptions.IdNotFoundException;
import com.losung.contactApplication.exceptions.PhoneNumberNotUniqueException;
import com.losung.contactApplication.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;


    public List<Contact> getAllContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        Optional<Contact> optionalContact = contactRepository.findByEmail(contact.getEmail());
        Optional<Contact> optionalContactByNumber = contactRepository.findByPhoneNumber(contact.getPhoneNumber());

        if(optionalContact.isPresent())
            throw new EmailNotUniqueException();
        else if(optionalContactByNumber.isPresent())
            throw new PhoneNumberNotUniqueException();
        return contactRepository.save(contact);
    }

    public String deleteContact(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(!optionalContact.isPresent())
            throw new IdNotFoundException();
        contactRepository.deleteById(id);
        return "Successfully Deleted";
    }

    public Contact updateContact(int id, Contact contact) {
        Optional<Contact> lastContact = contactRepository.findById(id);
        if(!lastContact.isPresent())
                throw new IdNotFoundException();
        else{
            lastContact.get().setEmail(contact.getEmail());
            lastContact.get().setLastName(contact.getLastName());
            lastContact.get().setFirstName(contact.getFirstName());
            lastContact.get().setPhoneNumber(contact.getPhoneNumber());
        }
        return contactRepository.save(lastContact.get());
    }

    public Contact getContactById(int id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(!optionalContact.isPresent())
            throw new IdNotFoundException();
        return optionalContact.get();
    }

    public List<Contact> getContactByFirstName(String firstName) {
        List<Contact> contactList = contactRepository.findAllByFirstName(firstName);
        if(contactList.size()==0)
            throw new ContactNotFoundException();
        return contactList;
    }

    public List<Contact> getContactByLastName(String lastName) {
        List<Contact> contacts = contactRepository.findAllByLastName(lastName);
        if(contacts.isEmpty())
            throw new ContactNotFoundException();
        return contacts;
    }
    public Contact getContactByEmail(String email) {
        Optional<Contact> optionalContact = contactRepository.findByEmail(email);
        if(!optionalContact.isPresent())
            throw new ContactNotFoundException();
        return optionalContact.get();
    }
}
