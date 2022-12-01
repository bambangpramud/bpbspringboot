package com.bcafinance.bpbspringboot.repos;

import com.bcafinance.bpbspringboot.models.Geographies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GeographyRepo extends JpaRepository<Geographies,Long> {


    Optional<Geographies> findByCity(String city);

    List<Geographies> findBySpNameEndsWith(String SpName);

    List<Geographies> findBySpNameStartsWith(String SpName);
//List<Products> searchByNameStartsWith(String name);
    List<Geographies> findByCityNotContainsIgnoreCase(String city);

    List<Geographies> findByCityContainsIgnoreCase(String city);

    List<Geographies> searchByScName(@Param("StateCountryName") String StateCountryName);

}
