package com.java.customerportal.repository;

import com.java.customerportal.dao.GifTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface GifTagRepository extends JpaRepository<GifTag, Integer> {
    @Query("SELECT gf FROM GifTag gf WHERE gf.name = :name")
    Optional<GifTag> findByName(@Param("name") String name);
}
