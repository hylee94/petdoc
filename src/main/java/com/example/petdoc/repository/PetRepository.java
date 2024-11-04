package com.example.petdoc.repository;

import com.example.petdoc.model.Member;
import com.example.petdoc.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findByMemberid_id(String memberId);
}
