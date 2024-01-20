package com.example.review.BusinnessLayer;


import com.example.review.PresentationLayer.ContactResponseDTO;

import java.util.List;

public interface ContactService {

    List<ContactResponseDTO> getContacts();
    ContactResponseDTO getContactById(int contactId);
    ContactResponseDTO UpdateContact(int id);
    ContactResponseDTO CreateContact();
    void deleteContact(int id);
}
