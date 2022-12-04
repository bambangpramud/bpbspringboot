package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.RegisToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisTokenRepo extends JpaRepository<RegisToken, Long> {

    Optional<RegisToken> findByToken(String token);
}
