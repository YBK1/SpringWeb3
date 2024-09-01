var Member = artifacts.require("Member");

module.exports = function(deployer) {
  // Deploy the SolidityContract contract as our only task
  deployer.deploy(Member);
};
