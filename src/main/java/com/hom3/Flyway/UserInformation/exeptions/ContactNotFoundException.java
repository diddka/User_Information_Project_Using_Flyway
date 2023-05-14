package com.hom3.Flyway.UserInformation.exeptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(Long contactId) {
        super("Contact with ID: " + contactId + " not found");
    }
}
