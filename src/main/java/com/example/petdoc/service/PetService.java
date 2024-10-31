package com.example.petdoc.service;

import com.example.petdoc.model.Pet;
import com.example.petdoc.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    //전체보기
    public List<Pet> list(){
        return petRepository.findAll();
    }

    //추가
    public Pet insert(Pet pet) {
        return petRepository.save(pet);
    }

    //수정
    @Transactional
    public Pet update(String petid, Pet pet) {
        Pet p = petRepository.findById(petid).get();

        p.setMemberid(pet.getMemberid());
        p.setType(pet.getType());
        p.setName(pet.getName());
        p.setGender(pet.getGender());
        p.setAge(pet.getAge());
        p.setHospital(pet.getHospital());

        return p;
    }

    //삭제
    public void delete(String petid) {
        petRepository.deleteById(petid);
    }
}
