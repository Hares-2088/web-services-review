package com.example.review.PresentationLayer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactResponseDTO {
    private int contactId;
    private String firstname;
    private String lastName;
    private int phoneNumber;
    private String address;
}
