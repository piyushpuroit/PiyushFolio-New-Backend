package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.entity.Contact;
import com.piyush.portfoliobackend.service.ContactService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

import com.piyush.portfoliobackend.dto.ContactRequestDto;
import com.piyush.portfoliobackend.mapper.ContactMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact saveContact(@Valid @RequestBody ContactRequestDto contactDto) {
        Contact contact = ContactMapper.toEntity(contactDto);
        return contactService.saveContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id,
            @RequestHeader(value = "Authorization", required = false) String auth) {

        // Simple token check: expects Bearer mock-jwt-token
        if (auth == null || !auth.startsWith("Bearer mock-jwt-token")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        contactService.deleteContact(id);

        return "Contact deleted successfully";
    }

    @PatchMapping("/{id}/read")
    public Contact markRead(@PathVariable Long id, @RequestBody Map<String, Object> body,
            @RequestHeader(value = "Authorization", required = false) String auth) {
        if (auth == null || !auth.startsWith("Bearer mock-jwt-token")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        boolean read = false;
        if (body != null && body.containsKey("read")) {
            Object v = body.get("read");
            if (v instanceof Boolean)
                read = (Boolean) v;
            else
                read = Boolean.parseBoolean(String.valueOf(v));
        }
        return contactService.markRead(id, read);
    }
}