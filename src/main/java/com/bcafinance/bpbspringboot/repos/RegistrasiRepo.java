package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.Registrasi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrasiRepo extends JpaRepository<Registrasi, Long> {

    Optional<Registrasi> findByEmails(String email);

    Optional<Registrasi> findByToken(String token);
}
