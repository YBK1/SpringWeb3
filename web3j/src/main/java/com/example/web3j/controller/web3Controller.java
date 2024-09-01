package com.example.web3j.controller;

import com.example.web3j.model.Member;
import com.example.web3j.model.MemberDto;
import com.example.web3j.service.DBService;
import com.example.web3j.service.Web3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class web3Controller {
    private final DBService dbService;
    private final Web3Service web3Service;

    @GetMapping("add")
    public ResponseEntity<String> add(@RequestBody MemberDto memberDto) {
        dbService.add(memberDto);
        
        return ResponseEntity.ok("입력완료");
    }
}
