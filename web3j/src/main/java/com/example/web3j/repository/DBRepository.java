package com.example.web3j.repository;

import com.example.web3j.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRepository extends JpaRepository<Member, Long> {
}
