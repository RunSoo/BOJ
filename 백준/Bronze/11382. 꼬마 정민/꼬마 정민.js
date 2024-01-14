let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

let nums = input[0].split(" ").map(Number);
let result = nums.reduce((a, b)=>a+b);

console.log(result);