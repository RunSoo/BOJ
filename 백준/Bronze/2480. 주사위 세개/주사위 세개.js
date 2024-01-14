let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let set = new Set();

let nums = new Array(3).fill(0);
for (let i = 0; i < 3; i++) {
  let num = Number(input[0].split(" ")[i]);
  set.add(num);
  nums[i] = num;
}

if (set.size === 1) {
  let num = nums[0];
  console.log(10000 + num * 1000);
} else if (set.size === 2) {
  let num = nums[0];
  let flag = false;
  for (let i=1; i<3; i++){
    if (num===nums[i]) flag=true;
  }
  if (!flag) num=nums[1];
  console.log(1000+num*100);
} else {
  let num = nums.reduce((a, b)=> Math.max(a, b));
  console.log(num*100);
}