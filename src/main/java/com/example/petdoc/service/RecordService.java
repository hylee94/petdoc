package com.example.petdoc.service;

import com.example.petdoc.model.Record;
import com.example.petdoc.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;

    //전체보기
    public List<Record> list(){
        return recordRepository.findAll();
    }

    //추가
    public Record insert(Record record) {
        return recordRepository.save(record);
    }

    //수정
    @Transactional
    public Record update(int no, Record record) {
        Record c = recordRepository.findById(no).get();

        c.setPetid(record.getPetid());
        c.setDate(record.getDate());
        c.setDisease(record.getDisease());
        c.setDoctor_op(record.getDoctor_op());
        c.setMedicine(record.getMedicine());
        c.setFee(record.getFee());
        c.setHospital(record.getHospital());
        c.setMemo(record.getMemo());

        return c;
    }

    //삭제
    public void delete(int no) {
        recordRepository.deleteById(no);
    }
}
