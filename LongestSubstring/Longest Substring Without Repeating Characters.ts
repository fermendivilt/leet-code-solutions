function lengthOfLongestSubstring(s: string): number {
  let result: number = 0;
  let auxString: string = "";
  let char: string;
  let idx: number;

  for (let i = 0; i < s.length; i++) {
    char = s.charAt(i);
    idx = auxString.indexOf(char);
    if (idx !== -1) {
      //if char is found on current auxString, removes it and all prev chars
      auxString = auxString.slice(idx + 1);
    }
    auxString += char;
    result = Math.max(result, auxString.length);
  }
  return result;
}
