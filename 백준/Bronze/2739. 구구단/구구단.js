let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let N = Number(input[0]);
for (let i=1; i<=9; i++){
  let result = i*N;
  console.log(`${N} * ${i} = ${result}`);
}