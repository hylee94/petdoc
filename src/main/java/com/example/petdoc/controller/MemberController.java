package com.example.petdoc.controller;

import com.example.petdoc.model.Member;
import com.example.petdoc.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //전체보기
    @GetMapping("/list")
    public List<Member> list() {
        return memberService.list();
    }

    //추가(회원가입)
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Member member) {
        //ID 중복 확인
        if (memberService.isIdDuplicated(member.getId())) {
            //ID가 중복된 경우 409 Conflict 응답 반환
            return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디가 중복됩니다.");
        }

        //중복이 없는 경우에만 회원가입 진행
        Member newMember = memberService.insert(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMember);
    }

    //수정
    @PutMapping("/update/{id}")
    public Member update(@PathVariable String id,
                         @RequestBody Member member) {
        return memberService.update(id, member);
    }

    //삭제
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<Member> loing(@RequestBody Member member) {
        Member loggedInMember = memberService.login(member.getId(), member.getPassword());
        if (loggedInMember != null) {
            return ResponseEntity.ok(loggedInMember);// 로그인 성공 시 200 OK 응답
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // 로그인 실패 시 401 응답
        }
    }

}
