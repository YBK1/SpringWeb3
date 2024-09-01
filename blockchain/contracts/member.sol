// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Member {
    mapping(address => string) private keys;

    function setKey(address _address, string memory _key) public {
        keys[_address] = _key;
    }

    // 주소에 해당하는 문자열을 조회하는 함수
    function getKey(address _address) public view returns (string memory) {
        return keys[_address];
    }
}
