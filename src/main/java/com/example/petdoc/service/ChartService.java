package com.example.petdoc.service;

import com.example.petdoc.model.Chart;
import com.example.petdoc.repository.ChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChartService {
    private final ChartRepository chartRepository;

    //전체보기
    public List<Chart> list(){
        return chartRepository.findAll();
    }

    //추가
    public Chart insert(Chart chart) {
        return chartRepository.save(chart);
    }

    //수정
    @Transactional
    public Chart update(int no, Chart chart) {
        Chart c = chartRepository.findById(no).get();

        c.setPetid(chart.getPetid());
        c.setDate(chart.getDate());
        c.setDisease(chart.getDisease());
        c.setDoctor_op(chart.getDoctor_op());
        c.setMedicine(chart.getMedicine());
        c.setFee(chart.getFee());
        c.setHospital(chart.getHospital());
        c.setMemo(chart.getMemo());

        return c;
    }

    //삭제
    public void delete(int no) {
        chartRepository.deleteById(no);
    }
}
