class Solution {
    fun isMatch(s: String, p: String): Boolean {

        if(p.length == 0) return s.length == 0

        var firstCharMatch = s.length > 0 && (p[0] == '.' || p[0] == s[0])

        if(p.length >= 2 && p[1] == '*'){
            return(
                isMatch(s, p.subSequence(2, p.length) as String) ||
                (firstCharMatch && isMatch(s.subSequence(1, s.length) as String, p))
                )
        } else {
            return firstCharMatch && isMatch(s.subSequence(1, s.length) as String, p.subSequence(1, p.length) as String)
        }
    }
}