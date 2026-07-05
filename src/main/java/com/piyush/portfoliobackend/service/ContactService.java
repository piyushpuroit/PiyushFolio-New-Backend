package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.entity.Contact;
import com.piyush.portfoliobackend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public Contact markRead(Long id, boolean read) {
        Contact c = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        c.setRead(read);
        return contactRepository.save(c);
    }

    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }
}