package com.hom3.Flyway.UserInformation.repositories;


import com.hom3.Flyway.UserInformation.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Boolean findByEmail(String email);
}