let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().split("\n");

let N = Number(input[0]);
let array = input[1].split(" ").map(Number);
let min = array.reduce((a, b)=>Math.min(a, b));
let max = array.reduce((a, b)=>Math.max(a, b));

let result = min+" "+max;
console.log(result);