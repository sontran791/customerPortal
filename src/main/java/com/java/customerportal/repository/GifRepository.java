package com.java.customerportal.repository;

import com.java.customerportal.dao.Gif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GifRepository extends JpaRepository<Gif, Integer> {
    @Query("SELECT g FROM Gif g WHERE g.ownerId = :ownerId")
    List<Gif> findByOwnerId(@Param("ownerId") Long ownerId);
}
