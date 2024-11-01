package com.example.petdoc.repository;

import com.example.petdoc.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartRepository extends JpaRepository<Record, Integer> {
}
