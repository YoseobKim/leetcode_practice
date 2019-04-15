class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        // Make allComboDict. Basically it will contain all * word and list of it.
        for(String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                ArrayList<String> asterisks = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                asterisks.add(word);
                allComboDict.put(newWord, asterisks);
            }
        }
        
        // Queue for BFS
        Queue<Map<String, List<String>>> queue = new LinkedList<Map<String, List<String>>>();
        // Add first Item into Q
        Map<String, List<String>> firstItem = new HashMap<>();
        List<String> listItem = new ArrayList<>();
        listItem.add(beginWord);
        firstItem.put(beginWord, listItem);
        queue.add(firstItem);

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Map<String, List<String>> node = queue.remove();
            Set<String> words = node.keySet();
            String word = "";
            for(String s : words) word = s;
        
            List<String> level = node.get(word);
        
            for (int i = 0; i < word.length(); i++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, word.length());

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level.size() + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Map<String, List<String>> item = new HashMap<>();
                        List<String> li = new ArrayList<>(level);
                        li.add(adjacentWord);
                        item.put(adjacentWord, li);
                        queue.add(item);
                    }
                }
            }
        }
        return 0;
    }
}
