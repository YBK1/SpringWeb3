package com.example.web3j.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

@Service
@RequiredArgsConstructor
public class Web3Service {
    private final Web3j web3j;
    private final Credentials credentials;
    private final ContractGasProvider contractGasProvider;
    private final String contractAddress = "0x307192eBC7dA71Dc4e2B14ed76439bEA309c85df";

    @Autowired
    public Web3Service(Web3j web3j) {
        this.web3j = web3j;
        this.credentials = Credentials.create("YOUR_PRIVATE_KEY"); // 개인 키
        this.contractGasProvider = new DefaultGasProvider();
    }

//    // 스마트 컨트랙트 로드
//    public YourContract loadContract() {
//        return YourContract.load(contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    // 컨트랙트 호출 예시
//    public String getStoredValue(String userAddress) throws Exception {
//        YourContract contract = loadContract();
//        return contract.getString(userAddress).send();
//    }
//
//    // 스마트 컨트랙트에 데이터 저장 예시
//    public void setStoredValue(String value) throws Exception {
//        YourContract contract = loadContract();
//        contract.setString(value).send();
//    }
}
