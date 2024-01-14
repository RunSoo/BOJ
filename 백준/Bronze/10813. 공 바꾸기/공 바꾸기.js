let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let N = Number(input[0].split(" ")[0]);
let M = Number(input[0].split(" ")[1]);

let basket = new Array(N).fill(0);

for (let i=0; i<N; i++){
  basket[i]=i+1;
}

for (let i=0; i<M; i++){
  let idx1 = Number(input[i+1].split(" ")[0])-1;
  let idx2 = Number(input[i+1].split(" ")[1])-1;
  let tmp = basket[idx2];
  basket[idx2]=basket[idx1];
  basket[idx1]=tmp;
}

let result = "";
for (let i of basket){
  result+=i+" ";
}

console.log(result);