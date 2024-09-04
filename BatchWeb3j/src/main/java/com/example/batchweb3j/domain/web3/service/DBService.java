//package com.example.batchweb3j.domain.web3.service;
//
//import com.example.batchweb3j.domain.web3.model.MemberEntity;
//import com.example.batchweb3j.domain.web3.model.MemberDto;
//import com.example.batchweb3j.domain.web3.repository.DBRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class DBService {
//    private final DBRepository dbRepository;
//
//    @Transactional
//    public void add(MemberDto memberDto){
//        MemberEntity member = new MemberEntity();
//        member.setMemberByMemberDto(memberDto);
//
//        dbRepository.save(member);
//    }
//}
