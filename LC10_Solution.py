class Solution:
    def isEmpty(self, s):
        return len(s) == 0

    def isMatch(self, s: str, p: str) -> bool:
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if not p:
            return not s

        first = (not (not s)) and ((s[0] == p[0]) or (p[0] == '.'))

        if len(p) >= 2 and p[1] == '*':
            return (self.isMatch(s, p[2:])) or (first and self.isMatch(s[1:], p))
        else:
            return first and self.isMatch(s[1:], p[1:])

