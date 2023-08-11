package com.mustafak01.userservice.repository;

import com.mustafak01.userservice.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {

    Confirmation findByConfirmationKey(String confirmationKey);

}
