let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split("\n");
let a = Number(input[0]);
let b = Number(input[1]);

let bNum = new Array(3).fill(0);
for (let i=0; i<3; i++){
  bNum[i] = Number(String(b)[2-i]);
}

let output = "";
let result = 0;
let place = 1;
for (let i=0; i<3; i++){
  output+=a*bNum[i]+"\n";
  result += a*bNum[i]*place;
  place*=10;
}

output+=result;
console.log(output);