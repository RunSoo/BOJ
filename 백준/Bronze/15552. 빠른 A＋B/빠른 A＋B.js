let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let T = Number(input[0]);
let answer = "";
for (let i=0; i<T; i++){
  let result = Number(input[i+1].split(" ")[0])+Number(input[i+1].split(" ")[1]);
  answer+=result+"\n";
}
console.log(answer);