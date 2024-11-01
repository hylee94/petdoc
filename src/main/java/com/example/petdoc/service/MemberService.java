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

        return m;
    }

    //삭제
    public void delete(String id) {
        memberRepository.deleteById(id);
    }

    //로그인
    @Transactional
    public Member login(String id, String password) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null && member.getPassword().equals(password)) {
            return member; // 로그인 성공 시 Member 객체 반환
        }else {
            return null; // 로그인 실패 시 null 반환
        }
    }

    // ID 중복 확인 메서드
    public boolean isIdDuplicated(String id) {
        return memberRepository.existsById(id);
    }

}
