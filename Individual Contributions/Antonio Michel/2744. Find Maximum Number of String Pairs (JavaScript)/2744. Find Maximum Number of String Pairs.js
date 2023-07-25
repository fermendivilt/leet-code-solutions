function maximumNumberOfStringPairs(words) {
  let counter = 0;
  while (words.length) {
    if (words.includes(words.shift().split("").reverse().join(""))) {
      counter++;
    }
  }
  return counter;
}
