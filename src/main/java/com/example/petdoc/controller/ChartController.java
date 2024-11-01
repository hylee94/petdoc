package com.example.petdoc.controller;

import com.example.petdoc.model.Record;
import com.example.petdoc.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chart")
@RequiredArgsConstructor
public class ChartController {
    private final ChartService chartService;

    //전체보기
    @GetMapping("/list")
    public List<Record> list() {
        return chartService.list();
    }

    //추가
    @PostMapping("/insert")
    public Record insert(@RequestBody Record record) {
        return chartService.insert(record);
    }

    //수정
    @PutMapping("/update/{no}")
    public Record update(@PathVariable int no,
                         @RequestBody Record record) {
        return chartService.update(no, record);
    }

    //삭제
    @DeleteMapping("/delete/{no}")
    public void delete(@PathVariable int no) {
        chartService.delete(no);
    }
}
