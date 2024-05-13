class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        var inputLength = s.length

        if(inputLength <= 1) return inputLength
        
        var start = 0
        var index = 0
        // Factory function from the collections framework. A mutable map is an interface 
        //  and has to be declared like this: var map: MutableMap<Int, String> = HashMap()
        var dictionary = mutableMapOf<Char, Int>();
        var distance = 0
        var result = 0
        // Second option for variable declaration is to specify type and not value
        var position: Int?

        while (index < inputLength) {

            // Returns null if not found
            position = dictionary.get(s[index])

            if (position != null && position >= start) start = position + 1
            
            // Indexed access is also an option. I.e. dictionary["g"] = 1
            dictionary.put(s[index], index)
            index += 1

            distance = index - start
            if(distance > result) result = distance
        }

        return result
    }
}