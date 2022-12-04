package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.Partners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnersRepo extends JpaRepository<Partners,Long> {


    Optional<Partners> findByEmail(String email);

    Optional<Partners> findByEmailLikeIgnoreCase(String email);
}
