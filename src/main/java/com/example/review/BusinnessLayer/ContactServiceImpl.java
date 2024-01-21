package com.example.review.BusinnessLayer;

import com.example.review.DataAccesslayer.Contact;
import com.example.review.DataAccesslayer.ContactRepository;
import com.example.review.PresentationLayer.ContactRequestDTO;
import com.example.review.PresentationLayer.ContactResponseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactResponseDTO> getContacts() {
        //Because we return a list we will create it now and store all the contacts of our dataBase in it using the contactRepository
        List<Contact> contactEntities = contactRepository.findAll();

        //Convert list of contacts entities to list of DirectorResponseDTO for security
        List<ContactResponseDTO> contactResponseDTOS = new ArrayList<>();

        // go over all the contacts in contactEntities
        for (Contact contact : contactEntities) {

            //create a dto and paste the contact in it to remove the private id
            ContactResponseDTO directorResponseDTO = new ContactResponseDTO();
            BeanUtils.copyProperties(contact, directorResponseDTO);

            //add the dto to the list of dtos
            contactResponseDTOS.add(directorResponseDTO);
        }

        return contactResponseDTOS;
    }

    @Override
    public ContactResponseDTO getContactById(String contactId) {
    //Almost the same steps as the last one. the difference is that we don't use a list
        //find the contact using the function we created in the contactRepository to find the contact by id
        Contact foundContact = contactRepository.findContactByContactId(contactId);

        //create a dto to store the data that we will return (that means we don,t share the private id)
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        BeanUtils.copyProperties(foundContact, contactResponseDTO);

        return contactResponseDTO;
    }

    @Override
    public ContactResponseDTO UpdateContact(ContactRequestDTO contactRequestDTO, String id) {
        //finding the contact that we need to update
        Contact foundContact = contactRepository.findContactByContactId(id);

        //create a new contact object to hold all the data from the request
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDTO, contact);

        //the request dto will miss the private and the public id, so we will copy them from the old contact and paste them to the updated contact
        contact.setContactId(foundContact.getContactId());
        contact.setId(foundContact.getId());

        //save the contact in the database
        Contact savedContact = contactRepository.save(contact);

        //for security, return a dto instead of the dto that is why we copy the contact to a dto
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        BeanUtils.copyProperties(savedContact, contactResponseDTO);

        return contactResponseDTO;
    }

    @Override
    public ContactResponseDTO CreateContact(ContactRequestDTO contactRequestDTO) {
        //Creating a new contact
        Contact contact = new Contact();

        //taking the request that holds all the data we need and put it in the contact object
        BeanUtils.copyProperties(contactRequestDTO, contact);
        //we still miss the public id, so we will create a random one with this function and set it to contactId
        contact.setContactId(UUID.randomUUID().toString());

        //we will use the contactRepository instance to save the new contact in our dataBase and in the same time we will put it in a new variable for more security and future testCases
        Contact savedContact = contactRepository.save(contact);

        //Because this function return a contact response dto and not just a contact object we will create a dto to store the data in a secure way
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        BeanUtils.copyProperties(savedContact, contactResponseDTO);

        return contactResponseDTO;
    }

    @Override
    public void deleteContact(String id) {
        //find the contact using the id with the repository
        Contact foundContact = contactRepository.findContactByContactId(id);

        //use the repository to delete the contact from the database
        contactRepository.delete(foundContact);

        //the same as
        // contactRepository.delete(contactRepository.findContactByContactId(id));

        //we finished :)
    }
}
