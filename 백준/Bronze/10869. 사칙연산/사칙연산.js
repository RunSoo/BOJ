let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let line = input[0].split(' ');
let a = Number(line[0]);
let b = Number(line[1]);

let output = "";
output += (a + b) + '\n';
output += (a-b)+'\n';
output += (a*b)+'\n';
output+=(parseInt(a/b))+'\n';
output+=(a%b)+'\n';

console.log(output);