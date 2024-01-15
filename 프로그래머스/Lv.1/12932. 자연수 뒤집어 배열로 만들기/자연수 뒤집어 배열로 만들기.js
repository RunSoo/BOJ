function solution(n) {
    // var answer = [];
    // const answer = [];
    let nums = String(n);
    const answer = new Array(nums.length).fill(0);
    
    console.log(nums.length);
    
    for (let i=0; i<nums.length; i++){
        answer[i]=Number(nums[nums.length-i-1]);
    }
    
    return answer;
}