class Solution {
    private String reverse(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            result = c + result;
        }
        return result;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        int pairs = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == true){
                System.out.println("Already paired this word: " + words[i]);
                continue;
            }

            String currentWord = words[i];
            System.out.println("Current word: " + currentWord);
            for(int j = i + 1; j < n; j++){
                if(visited[j] == true){
                    System.out.println("  Already paired this word: " + words[j]);
                    continue;
                }
                System.out.println("  Comparing to: " + words[j]);
                if (currentWord.equals(reverse(words[j]))){
                    System.out.println("    " + currentWord + " and " + words[j] + " are a pair");
                    pairs += 1;
                    visited[i] = true;
                    visited[j] = true;
                    continue;
                }
                continue;
            }
        }
        return pairs;
    }
}