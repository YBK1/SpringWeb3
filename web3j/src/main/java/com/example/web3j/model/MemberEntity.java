package com.example.web3j.model;

import jakarta.persistence.*;

@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    public void setMemberByMemberDto(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.gender = memberDto.getGender();
    }
}
