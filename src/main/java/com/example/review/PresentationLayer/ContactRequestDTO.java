package com.example.review.PresentationLayer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactRequestDTO {

    //we don't have a public id because the request dto will be used to update an existing contact. So to not interfere with the old contact we don't give a new id
    //when creating a new contact we will create a new id in the contactServiceImpl and I commented the steps, so you can understand

    private String firstname;
    private String lastName;
    private int phoneNumber;
    private String address;
}
