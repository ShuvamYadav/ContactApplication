package com.losung.contactApplication.service;

import com.losung.contactApplication.entity.Contact;
import com.losung.contactApplication.exceptions.IdNotFoundException;
import com.losung.contactApplication.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;
    @Mock
    private ContactRepository contactRepository;

    @Test
    void shouldReturnAllContacts() {
        when(contactRepository.findAll()).thenReturn(new ArrayList<>());

        List<Contact> allContacts = contactService.getAllContacts();

        assertEquals(0, allContacts.size());
    }

    @Test
    void shouldCreateContact() {
        Contact expected = new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890");
        when(contactRepository.save(expected)).thenReturn(expected);

        Contact actual = contactService.createContact(expected);

        assertEquals(actual,expected);

    }

    @Test
    void deleteContact() {
        Contact expected = new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890");
        when(contactRepository.findById(expected.getId())).thenReturn(Optional.of(expected));
       contactRepository.deleteById(expected.getId());

       String actual= contactService.deleteContact(expected.getId());

       assertEquals("Successfully Deleted",actual);

    }

    @Test
    void updateContact() {
        Contact actual = new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890");
        Contact expected = new Contact(1,"Shivam","Yadav","abcd@gmail.com","1234567890");
        when(contactRepository.findById(1)).thenReturn(Optional.of(actual));
        when(contactRepository.save(actual)).thenReturn(expected);

        Contact updatedContact = contactService.updateContact(1, expected);

        assertEquals(expected,updatedContact);


    }

    @Test
    void getContactById() {
        Contact expected = new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890");

        when(contactRepository.findById(1)).thenReturn(Optional.of(expected));

        Contact actual = contactService.getContactById(1);

        assertEquals(expected,actual);

    }

    @Test
    void shouldThrowExceptionWhenIdNotFound(){

        when(contactRepository.findById(1)).thenThrow(IdNotFoundException.class);

        assertThrows(IdNotFoundException.class,()->contactService.getContactById(1));

    }

    @Test
    void getContactByFirstName() {
        List<Contact> expected = Arrays.asList(new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890"));

        when(contactRepository.findAllByFirstName("Shuvam")).thenReturn(expected);

        List<Contact> contacts = contactService.getContactByFirstName("Shuvam");

        assertEquals(expected,contacts);

    }

    @Test
    void getContactByLastName() {

        List<Contact> expected = Arrays.asList(new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890"));

        when(contactRepository.findAllByLastName("Yadav")).thenReturn(expected);

        List<Contact> contacts = contactService.getContactByLastName("Yadav");

        assertEquals(expected,contacts);
    }

    @Test
    void getContactByEmail() {
        Contact expected = new Contact(1,"Shuvam","Yadav","abc@gmail.com","1234567890");

        when(contactRepository.findByEmail("abc@gmail.com")).thenReturn(Optional.of(expected));

        Contact actual = contactService.getContactByEmail("abc@gmail.com");

        assertEquals(expected,actual);
    }
}