var TurtleToken = artifacts.require("TurtleToken");

module.exports = function (deployer) {
  // Deploy the SolidityContract contract as our only task
  deployer.deploy(TurtleToken);
};
