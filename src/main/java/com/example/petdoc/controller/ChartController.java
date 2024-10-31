package com.example.petdoc.controller;

import com.example.petdoc.model.Chart;
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
    public List<Chart> list() {
        return chartService.list();
    }

    //추가
    @PostMapping("/insert")
    public Chart insert(@RequestBody Chart chart) {
        return chartService.insert(chart);
    }

    //수정
    @PutMapping("/update/{no}")
    public Chart update(@PathVariable int no,
                        @RequestBody Chart chart) {
        return chartService.update(no, chart);
    }

    //삭제
    @DeleteMapping("/delete/{no}")
    public void delete(@PathVariable int no) {
        chartService.delete(no);
    }
}
