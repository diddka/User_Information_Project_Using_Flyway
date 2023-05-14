package com.hom3.Flyway.UserInformation.services;

import com.hom3.Flyway.UserInformation.dto.ContactDTO;
import com.hom3.Flyway.UserInformation.models.Contact;
import com.hom3.Flyway.UserInformation.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts
                .stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContactDTO> findContactById(Long contactId) {
        Optional<Contact> contacts = contactRepository.findById(contactId);
        return contacts
                .stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    public Boolean updateContactById(Long contactId,ContactDTO contactDTO){
        Optional<Contact> findContact = contactRepository.findById(contactId);
        if (findContact.isPresent()) {

            findContact.get().setName(contactDTO.getName());
            findContact.get().setPhone(contactDTO.getPhone());
            findContact.get().setEmail(contactDTO.getEmail());
            contactRepository.save(findContact.get());
            return true;
        } else {
            return false;
        }

    }
}
