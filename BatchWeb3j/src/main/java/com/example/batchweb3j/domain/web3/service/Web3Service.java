package com.example.batchweb3j.domain.web3.service;

import java.math.BigInteger;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import com.example.batchweb3j.domain.web3.model.contract.Member;

@Service
@RequiredArgsConstructor
public class Web3Service {
    private final Web3j web3j;
    private final Credentials credentials;
    private final ContractGasProvider contractGasProvider;
    private final String contractAddress = "0x8472d19f4237d7731b7F7522f1BF5E161B93a5F6";

    @Autowired
    public Web3Service(Web3j web3j) {
        this.web3j = web3j;
        this.credentials = Credentials.create("0xaede5867f1c3622ef9ce113d8c9330cf095b9350af48b46209e5e1f5bb8839a1"); // 개인 키

        // 가스 가격과 가스 한도 설정
        BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L); // 20 Gwei
        BigInteger gasLimit = BigInteger.valueOf(300_000L); // 300,000

        // StaticGasProvider를 이용한 설정
        StaticGasProvider gasProvider = new StaticGasProvider(gasPrice, gasLimit);

        this.contractGasProvider = gasProvider;
    }

   // 스마트 컨트랙트 로드
   public Member loadContract() {
       return Member.load(contractAddress, web3j, credentials, contractGasProvider);
   }

   // 컨트랙트 호출 예시
   public String getStoredValue(String userAddress) throws Exception {
       Member contract = loadContract();
       return contract.getKey(userAddress).send();
   }

   // 스마트 컨트랙트에 데이터 저장 예시
   public void setStoredValue(String userAddress, String value) throws Exception {
       Member contract = loadContract();
       contract.setKey(userAddress, value).send();
   }
}
