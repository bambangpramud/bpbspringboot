package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountsRepo extends JpaRepository<Discounts,Long> {


    Optional<Discounts> findByName(String name);
}
