// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

// import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
// import "@openzeppelin/contracts/access/Ownable.sol";

contract TurtleToken {
    // Initial supply: 1 million TURT (18 dec

    constructor() {
        // Mint initial supply to contract deployer
        // _mint(msg.sender, INITIAL_SUPPLY);
    }

    // // Mint TURT tokens (only owner)
    // function mintTurt(address to, uint256 amount) public onlyOwner {
    //     _mint(to, amount);
    // }

    // // Burn TURT tokens
    // function burnTurt(uint256 amount) public {
    //     _burn(msg.sender, amount);
    // }

    // Buy TURT with ETH
    // function buyTokens() public payable {
    //     uint256 turtAmount = msg.value * ETH_TO_TURT_RATE;
    //     require(balanceOf(owner()) >= turtAmount, "Not enough TURT in reserve");
    //     _transfer(owner(), msg.sender, turtAmount);
    // }

    // Sell TURT for ETH
    // function sellTokens(uint256 turtAmount) public {
    //     require(balanceOf(msg.sender) >= turtAmount, "Insufficient TURT balance");
    //     uint256 ethAmount = turtAmount / ETH_TO_TURT_RATE;
    //     require(address(this).balance >= ethAmount, "Not enough ETH in contract");
    //     _transfer(msg.sender, owner(), turtAmount);
    //     payable(msg.sender).transfer(ethAmount);
    // }

    // Get TURT balance
    // function getTurtBalance(address account) public view returns (uint256) {
    //     return balanceOf(account);
    // }

    // Function to receive ETH
    // receive() external payable {}
}
