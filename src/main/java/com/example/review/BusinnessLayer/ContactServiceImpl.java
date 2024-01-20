package com.example.review.BusinnessLayer;

import com.example.review.DataAccesslayer.Contact;
import com.example.review.DataAccesslayer.ContactRepository;
import com.example.review.PresentationLayer.ContactResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactResponseDTO> getContacts() {
        List<Contact> contactEntities = contactRepository.findAll();

        //Convert list of directors entities to list of DirectorResponseDTO
        List<ContactResponseDTO> contactResponseDTOS = new ArrayList<>();

        for (Contact contact : contactEntities) {

            ContactResponseDTO directorResponseDTO = new ContactResponseDTO();
            BeanUtils.copyProperties(contact, directorResponseDTO);

            contactResponseDTOS.add(directorResponseDTO);
        }

        return contactResponseDTOS;
    }

    @Override
    public ContactResponseDTO getContactById(int contactId) {
        return null;
    }

    @Override
    public ContactResponseDTO UpdateContact(int id) {
        return null;
    }

    @Override
    public ContactResponseDTO CreateContact() {
        return null;
    }

    @Override
    public void deleteContact(int id) {

    }
}
