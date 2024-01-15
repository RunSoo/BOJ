function solution(n) {
    let answer = n-1;
    
    for (let i=2; i<=Math.sqrt(n).toFixed()+1; i++){
        if (n%i===1){
            return i;
        }
    }
    
    return answer;
}