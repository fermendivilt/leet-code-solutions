/**
 * Objective: search the number of triplets that meet the condition of
 *  - Having different values
 *  - Their index is in ascendent order
 *  - Result can be 0, and no more than nums.length/3
 * Constraints say:
 *  - There will be between 3 and 100 numbers in the array, including 3 and 100
 *  - The numbers will be between 1 and 1000, including 1 and 1000
 * Observations:
 *  - Since the 3 indexes must be in ascendent order, permutations are out of the scope
 *  - 
 * @param {number[]} nums
 * @return {number}
 */
var unequalTriplets = function (nums) {
    let result = 0;

    //Naive approach: for each index, search for the next values
    //Time complex: n^3
    for (let i = 0; i < nums.length - 2; i++) {
        for (let j = i + 1; j < nums.length - 1; j++) {
            for (let k = i + 2; k < nums.length; k++) {

                if (i >= j || i >= k || j >= k) continue;

                if (nums[i] != nums[j] &&
                    nums[i] != nums[k] &&
                    nums[j] != nums[k])
                    result++;
            }
        }
    }

    /*//If instead of searching again, we just search once, store,
    //  and then check if there is a posibility?
    //Tried by myself and got stuck after filling the numberIndex object
    //  and knowing that if there are less than 3 keys in the object
    //  the result is 0.

    const numberIndex = {}
    for (let index = 0; index < nums.length; index++) {
        if (numberIndex[nums[index]] != undefined)
            numberIndex[String(nums[index])] =
                [...numberIndex[String(nums[index])], index];
        else
            numberIndex[String(nums[index])] = [index];
    }

    if(keys.length >= 3){

    }*/

    return result;
};

/* Bibliography used:
Objects: https://stackoverflow.com/a/7196296 | https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/keys | https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/values 
String: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
*/

/*Future reference of a code I found among others. 
    Couldn't find the user's name, only that it takes 44 ms of runtime.
    I wasn't so lost after all with my not-naive attempt.

var unequalTriplets = function(nums) {
 const len = nums.length;
 const countMap = new Map();

 for (num of nums){
    countMap.set(num, (countMap.get(num) ?? 0) + 1);
 }

 let ans = 0;
 let accumulated = 0;

 for (currentCount of countMap.values()){
    const remaining = len - accumulated - currentCount;
    ans += accumulated * currentCount * remaining;
    accumulated += currentCount;
 }   
 return ans;
};

// Using Map
// 1. Create a variable len to store nums.length.
// 2. Create a map to store the frequency of each value at nums.
// 3. Loop through nums and fill this count map.
// 4. Create a variable ans to store the answer. Initialize it with the value of 0.
// 5. Create a variable accumulated to store the number items (numbers) processed so far. Initialize it with the value of 0.
// 6. Loop through the map using map.values.
//    i. obtain the value of how many remaining items have not being processed yet, using the expression => remaining = len - accumulated - currentItemValue.
//    ii. Update ans with the product of accumulated * currentItemValue * remaining.
//    iii. Update accumulated with currentItemValue => accumulated += currentItemValue.
// 7. Return ans.
*/