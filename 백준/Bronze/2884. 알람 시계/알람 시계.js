let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let H = Number(input[0].split(" ")[0]);
let M = Number(input[0].split(" ")[1]);

let output = "";

if (M>=45){
  output+=H+" ";
  output+=M-45;
} else {
  if (H-1>=0){
    output+=H-1+" ";
    output+=60+M-45;
  } else {
    output+=23+" ";
    output+=60+M-45;
  }
}

console.log(output);