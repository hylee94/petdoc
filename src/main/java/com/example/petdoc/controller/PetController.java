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

    @GetMapping("/list")
    public List<Pet> list() {
        return petService.list();
    }

    //전체보기
    @GetMapping("/list/{id}")
    public List<Pet> list(@PathVariable String id) {
        System.out.printf("ididid : "+id);
        return petService.list(id);
    }

    //추가
    @PostMapping("/insert")
    public Pet insert(@RequestBody Pet pet) {
        return petService.insert(pet);
    }

    //수정
    @PutMapping("/update/{petid}")
    public Pet update(@PathVariable int petid,
                      @RequestBody Pet pet) {
        return petService.update(petid, pet);
    }

    //삭제
    @DeleteMapping("/delete/{petid}")
    public void delete(@PathVariable int petid) {
        petService.delete(petid);
    }
}
