package com.example.review.DataAccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Contact findByContactId(int contactId);
}
