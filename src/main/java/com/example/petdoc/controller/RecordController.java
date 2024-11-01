package com.example.petdoc.controller;

import com.example.petdoc.model.Record;
import com.example.petdoc.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    //전체보기
    @GetMapping("/list")
    public List<Record> list() {
        return recordService.list();
    }

    //추가
    @PostMapping("/insert")
    public Record insert(@RequestBody Record record) {
        return recordService.insert(record);
    }

    //수정
    @PutMapping("/update/{no}")
    public Record update(@PathVariable int no,
                         @RequestBody Record record) {
        return recordService.update(no, record);
    }

    //삭제
    @DeleteMapping("/delete/{no}")
    public void delete(@PathVariable int no) {
        recordService.delete(no);
    }
}
