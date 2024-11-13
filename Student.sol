// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract StudentData {
    //structure
    struct Student{
        string name;
        uint rollno;
    }
    
    //arrays
    Student[] public stuArr;

    function addStudent(string memory name,uint rollno) public {
        for(uint i=0;i<stuArr.length;i++){
            if(stuArr[i].rollno==rollno){
                revert("Student with this roll no already exists");
            }
        }
        stuArr.push(Student(name,rollno));
    }

    function getStudentsLength() public  view returns (uint){
        return stuArr.length;
    }

    function displayAllStudent() public view returns (Student[] memory){
        return stuArr;
    }

    function getStudentByIndex(uint idx) public view returns (Student memory){
        require(idx<stuArr.length,"Your index out of bound");
        return stuArr[idx];
    }
    //fallback
    fallback() external payable {

    }
    receive() external payable {

    }
}