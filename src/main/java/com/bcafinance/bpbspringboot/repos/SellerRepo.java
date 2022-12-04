package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepo extends JpaRepository<Seller,Long> {

    Optional<Seller> findByEmail(String email);

    Optional<Seller> findByEmailLike(String email);
}
