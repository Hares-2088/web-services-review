package com.example.review.BusinnessLayer;


import com.example.review.PresentationLayer.ContactRequestDTO;
import com.example.review.PresentationLayer.ContactResponseDTO;

import java.util.List;

public interface ContactService {

    List<ContactResponseDTO> getContacts();
    ContactResponseDTO getContactById(String contactId);
    ContactResponseDTO UpdateContact(ContactRequestDTO contactRequestDTO, String contactId);
    ContactResponseDTO CreateContact(ContactRequestDTO contactRequestDTO);
    void deleteContact(String contactId);
}
