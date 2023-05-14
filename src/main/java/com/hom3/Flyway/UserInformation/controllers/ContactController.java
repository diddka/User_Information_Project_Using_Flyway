package com.hom3.Flyway.UserInformation.controllers;

import com.hom3.Flyway.UserInformation.dto.ContactDTO;
import com.hom3.Flyway.UserInformation.models.Contact;
import com.hom3.Flyway.UserInformation.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<ContactDTO> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<List<ContactDTO>> findContactById(@PathVariable("contactId") Long contactId) {
        return ResponseEntity.ok(contactService.findContactById(contactId));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactDTO> addNewContact(@RequestBody @Valid Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        URI location = URI.create("/api/v1/contacts/" + savedContact.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")//200 OK
    public ResponseEntity<ContactDTO> deleteContactById(@PathVariable Long id) {
        contactService.deleteById(id);
        return ResponseEntity.
                ok()
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<ContactDTO>> updateContactById(@PathVariable Long id,
                                                              @RequestBody @Valid ContactDTO contactDTO) {
        contactService.updateContactById(id, contactDTO);
        return ResponseEntity.
                ok()
                .build();
    }
}
