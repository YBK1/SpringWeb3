package com.example.web3j.controller;

import com.example.web3j.model.MemberDto;
import com.example.web3j.service.DBService;
import com.example.web3j.service.Web3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class web3Controller {
    private final DBService dbService;
    private final Web3Service web3Service;

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody MemberDto memberDto) {
        try{
            dbService.add(memberDto);
            try{
                web3Service.setStoredValue("0x8472d19f4237d7731b7F7522f1BF5E161B93a5F6", "Hello Test");
                System.out.println("성공했다는데?");
            }catch (Exception e){
                // 원래라면 db 되돌리는 로직이 추가되어야 함
                e.printStackTrace();

            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok("입력완료");
    }
}
