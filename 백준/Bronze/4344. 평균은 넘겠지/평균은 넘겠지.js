let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().split("\n");
let C = Number(input[0]);
for (let c = 0; c < C; c++) {
  let students = input[c + 1].split(" ").map(Number);
  let N = students.shift();
  let sum = students.reduce((a, b) => a + b);
  let avg = sum/N;
  let answer = (students.filter(element => element > avg).length/N*100).toFixed(3);
  console.log(answer+"%");
}