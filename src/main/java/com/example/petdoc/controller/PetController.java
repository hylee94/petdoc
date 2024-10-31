package com.example.petdoc.controller;

import com.example.petdoc.model.Member;
import com.example.petdoc.model.Pet;
import com.example.petdoc.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    //전체보기
    @GetMapping("/list")
    public List<Pet> list() {
        return petService.list();
    }

    //추가
    @PostMapping("/insert")
    public Pet insert(@RequestBody Pet pet) {
        return petService.insert(pet);
    }

    //수정
    @PutMapping("/update/{petid}")
    public Pet update(@PathVariable String petid,
                      @RequestBody Pet pet) {
        return petService.update(petid, pet);
    }

    //삭제
    @DeleteMapping("/delete/{petid}")
    public void delete(@PathVariable String petid) {
        petService.delete(petid);
    }
}
