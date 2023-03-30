package com.losung.contactApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "FirstName must not be blank")
    private String firstName;
    @NotBlank(message = "LastName must not be blank")
    private String lastName;
    @NotBlank(message = "Email must not be blank")
    @Email
    private String email;
    @NotBlank(message = "PhoneNumber must not be blank")
    @Pattern(regexp = "[0-9]{10}")
    private String phoneNumber;

    public Contact() {
    }

    public Contact(int id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contacts = (Contact) o;
        return firstName.equals(contacts.firstName) && lastName.equals(contacts.lastName) && email.equals(contacts.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }
}
