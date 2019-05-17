class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        // key : character except bull, value : appearance
        Map<Character, Integer> secretMap = new HashMap<>();
        String newGuess = "";

        for(int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) {
                bulls++;
                continue;
            }
            secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
            newGuess += g;
        }

        int cows = 0;
        for(int i = 0; i < newGuess.length(); i++) {
            char g = newGuess.charAt(i);
            if(secretMap.containsKey(g)) {
                int appearance = secretMap.get(g);
                if(appearance <= 0) continue;
                appearance--;
                cows++;
                secretMap.put(g, appearance);
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
