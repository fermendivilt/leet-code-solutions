# APPRENTICE TECHNICAL LOG DOC

## Find Maximum Number of String Pairs

## Antonio Michel González

### OVERVIEW

In this log you will find the solution in JavaScript to a rather easy coding problem, finding the total number of string pairs in an array.

I will be implementing a simple iteration over each element of the array while updating the pairs counter and shortening the array until it is empty.

### CONTEXT

This algorithm is the solution to LeetCode’s [Find Maximum Number of String Pairs](https://leetcode.com/problems/find-maximum-number-of-string-pairs/), in which for a given array of 2-character strings the solution must return the total number of pairs of strings that contain the same two characters.

The constraints being:

    -The length of the array must be between 1 and 50 elements.

    -Each element of the array has exactly 2 characters.

    -Each element is distinct from the others, and as such there can only be two elements with the same two characters.

    -And there can only be lowercase English Letters.

### SOLUTION

The algorithm I came up with consists of a counter for the pairs and a single while loop that checks if the element in each iteration has a pair that matches its two characters in the reverse order, for this in the same condition for that check I have to turn the string into an array, reverse it, rejoin it into a string and with the use of a `shift()` method remove it from the original array, if the element matches another once these steps are complete it will add on to the counter and repeat until the array is empty.

One con of this solution is that once a matching element is removed, it’s pair will remain on the array and will have to be iterated over when there is no other possibility of having a matching element, this could probably be shortened if during the first element checked it also looked for the matching element and remove it aswell but I didn’t have enough time to implement it.

### ALTERNATIVE SOLUTIONS

My first approach to this problem consisted of some pretty easy steps, firstly I’d make each element in the array have its two characters sorted alphabetically, then sort every element in the array and lastly compare the first two elements in the array iteratively to check for matches, during this last step the counter of pairs would get updated and either the first or the first two elements in the array would be removed to move on to the next possible pair until the array runs out of elements, at which point the maximum number or pairs would have been found.

While I did submit the solution and passed, I was not satisfied with the solution having multiple loops for the same array and during the writing of this tech log I came up with another solution that shortened the code in almost half the lines, and it had a little bit better performance.
