// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract Bank{
    address public accHolder;
    uint balance=0;

    constructor(){
        accHolder=msg.sender;
    }

    function withdraw() payable  public {
        require (balance>0,"you don't have enough balance:");
        require(msg.sender==accHolder,"You are not the Owner.");
        payable(msg.sender).transfer(balance);
        balance=0;

    }
    function deposit() public payable{
        require(msg.value>0,"Deposit amount should be greater than 0");
        require(msg.sender==accHolder,"You are not the Owner.");
        balance+=msg.value;
    } 
    function showBalance() public view returns (uint){
        require(msg.sender==accHolder,"You are not account Owner");
        return  balance;
    }
}