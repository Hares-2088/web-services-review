package com.example.review.PresentationLayer;

import com.example.review.BusinnessLayer.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts(){
        return ResponseEntity.status(HttpStatus.FOUND).body(contactService.getContacts());
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable String contactId){
        return ResponseEntity.status(HttpStatus.FOUND).body(contactService.getContactById(contactId));
    }

    @PostMapping()
    public ResponseEntity<ContactResponseDTO> createContact(@RequestBody ContactRequestDTO contactRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.CreateContact(contactRequestDTO));
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactResponseDTO> updateContact(@RequestBody ContactRequestDTO contactRequestDTO,
                                                            @PathVariable String contactId){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.UpdateContact(contactRequestDTO, contactId));
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<ContactResponseDTO> deleteContact(@PathVariable String contactId){
        contactService.deleteContact(contactId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
