let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let A = Number(input[0].split(" ")[0]);
let B = Number(input[0].split(" ")[1]);

let C = Number(input[1]);

function cook(a, b, c) {
  let minute = a*60 + b + c;
  console.log(`${parseInt(minute/60)%24} ${minute%60}`)
}

cook(A, B, C);