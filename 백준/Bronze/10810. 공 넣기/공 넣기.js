let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let N = Number(input[0].split(" ")[0]);
let M = Number(input[0].split(" ")[1]);

let basket = new Array(N).fill(0);

for (let i1=0; i1<M; i1++){
  let i = Number(input[i1+1].split(" ")[0]);
  let j = Number(input[i1+1].split(" ")[1]);
  let k = Number(input[i1+1].split(" ")[2]);
  for (let i2=i-1; i2<=j-1; i2++){
    basket[i2]=k;
  }
}

let result = "";
for (let i of basket) result+=i+" ";

console.log(result);