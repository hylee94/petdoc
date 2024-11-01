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

    //추가
    @PostMapping("/insert")
    public Member insert(@RequestBody Member member) {
        return memberService.insert(member);
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
