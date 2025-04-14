package org.wcs.invoice_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wcs.invoice_api.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
