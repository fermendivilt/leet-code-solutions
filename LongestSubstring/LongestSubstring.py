class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        accessed = {}
        start = end = 0
        maxSub = 0
        for end in range(len(s)):
            curr = s[end]
            if curr in accessed:
                start = max(accessed[curr] + 1, start)
            if maxSub < end-start+1:
                maxSub = end - start +1
            accessed[curr] = end
            end +=1
        
        return maxSub
        
