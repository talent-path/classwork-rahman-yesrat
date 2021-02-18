
//https://leetcode.com/problems/intersection-of-two-arrays/submissions/

var intersection = function(nums1, nums2) {
    const nums1Set = new Set(nums1);
    const nums2Set = new Set(nums2);
    let result = [];
    
    for (let value of nums1Set) {
        if (nums2Set.has(value)) {
          result.push(value)
        }
      }
    return result;
    };
    
    /**
     * @param {number[]} nums1
     * @param {number[]} nums2
     * @return {number[]}
     */
    var intersection = function(nums1, nums2) {
        let answer = []; 
        for(let num of nums1){
            if(!answer.includes(num) && nums2.includes(num)){
        answer.push(num); 
        } 
    } 
    
    return answer; 
    };
    
    //https://projecteuler.net/problem=1
    
    let projectEuler1 = function(){ 
        let answer = 0; 
        for(let x = 1; x < 1000; x++){ 
            if(x % 3 === 0 || x % 5 === 0){
                answer += x; 
            } 
        } 
        return answer; 
    }
    
    //https://projecteuler.net/problem=2
    let pe2 = function(){
        let sum = 0; 
        let a = 0; 
        let b = 1; 
        while(b <= 4000000){
            if(b % 2 === 0){
                sum += b; 
            }
            let nextB = a + b; 
            a = b; 
            b = nextB; 
        } 
        return sum; 
    } 
    
    
    
    //https://projecteuler.net/problem=4
    
    let pe4 = function(){
        let largest = -1; 
        for(let x = 100; x < 1000; x++){
            for(let y = x; y < 1000; y++){
                let product = x * y; 
                if(product > largest){
                    let reverse = reverseDigits(product); 
                    if(product === reverse) {
                        largest = product; 
                    }
                }
            }
        } return largest; 
    }
    
    
    let reverseDigits = function(toReverse){
     
      let rev = 0; 
      while(toReverse > 0){
        rev *= 10; 
        let digit = toReverse % 10; 
        toReverse = Math.trunc(toReverse/ 10); 
        rev += digit; 
      }
      return rev;
    }
    //console.log(reverseDigits(1234)); 
    console.log(pe4())
    
    
    // Different version
    let pe4 = function(){
        let largest = -1; 
        for(let x = 100; x < 1000; x++){
            for(let y = x; y < 1000; y++){
                let product = x * y; 
                if(product > largest){
                    let reverse = reverseDigits(product); 
                    if(product === reverse) {
                        largest = product; 
                    }
                }
            }
        } return largest; 
    }
    
    
    let reverseDigits = function(toReverse){
     
     let rev = 0; 
     let digits = []; 
      while(toReverse > 0){
        let digit = toReverse % 10; 
        toReverse = Math.trunc(toReverse / 10); 
        digits.push(digit);
      }
    
      for(let i = 0; i < digits.length; i++){
        rev *= 10; 
        rev += digits[i]; 
      }
      return rev;
    }
    
    console.log(pe4())
    
    
    
    
    
    
    
    
    
    