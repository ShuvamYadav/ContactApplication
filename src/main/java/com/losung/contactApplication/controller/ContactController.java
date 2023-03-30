package com.losung.contactApplication.controller;

import com.losung.contactApplication.entity.Contact;
import com.losung.contactApplication.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    @Operation(summary = "Get all contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping("/new")
    @Operation(summary = "Create a new contact")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a contact by Id")
    public String deleteContact(@PathVariable int id) {
        return contactService.deleteContact(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a contact by Id")
    public Contact updateContact(@Valid @RequestBody Contact contact, @PathVariable int id) {
        return contactService.updateContact(id, contact);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get contact by Id")
    public Contact getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @GetMapping(params = "firstname")
    @Operation(summary = "Get contact by First name as parameter")
    public List<Contact> getContactByFirstName(@RequestParam(value = "firstname") String firstName) {
        return contactService.getContactByFirstName(firstName);

    }

    @GetMapping(params = "lastname")
    @Operation(summary = "Get contact as Last Name as parameter")
    public List<Contact> getContactByLastName(@RequestParam(value = "lastname") String lastName) {
        return contactService.getContactByLastName(lastName);
    }

    @GetMapping(params = "email")
    @Operation(summary = "Get contact as Email as parameter")
    public Contact getContactByEmail(@RequestParam(value = "email") String email) {
        return contactService.getContactByEmail(email);
    }

}
