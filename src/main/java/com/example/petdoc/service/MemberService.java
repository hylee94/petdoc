package com.example.petdoc.service;

import com.example.petdoc.model.Member;
import com.example.petdoc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //전체보기
    public List<Member> list(){
        return memberRepository.findAll();
    }

    //추가
    public Member insert(Member member) {
        return memberRepository.save(member);
    }

    //수정
    @Transactional
    public Member update(String id, Member member) {
        Member m = memberRepository.findById(id).get();

        m.setEmail(member.getEmail());
        m.setPassword(member.getPassword());
        m.setRegdate(member.getRegdate());

        return m;
    }

    //삭제
    public void delete(String id) {
        memberRepository.deleteById(id);
    }

}
