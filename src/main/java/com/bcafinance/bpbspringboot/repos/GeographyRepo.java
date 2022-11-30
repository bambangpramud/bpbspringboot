package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.Geographies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GeographyRepo extends JpaRepository<Geographies,Long> {


    Optional<Geographies> findByCity(String city);

    List<Geographies> findBySpNameEndsWith(String SpName);
//List<Products> searchByNameStartsWith(String name);
    List<Geographies> findByCityNotLike(String city);

//    List<Geographies> searchByStateCountryName(@Param("StateCountryName") String StateCountryName);

}