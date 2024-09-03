package com.example.web3j.service;

import com.example.web3j.model.MemberEntity;
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
        MemberEntity member = new MemberEntity();
        member.setMemberByMemberDto(memberDto);

        dbRepository.save(member);
    }
}
