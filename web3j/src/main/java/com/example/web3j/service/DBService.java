package com.example.web3j.service;

import com.example.web3j.model.Member;
import com.example.web3j.model.MemberDto;
import com.example.web3j.repository.DBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DBService {
    private final DBRepository dbRepository;

    @Transactional
    public void add(MemberDto memberDto){
        Member member = new Member();
        member.setMemberByMemberDto(memberDto);

        dbRepository.save(member);
    }
}
