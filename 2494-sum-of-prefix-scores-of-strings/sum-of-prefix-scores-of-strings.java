class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count = 0;
}

class Solution {
    TrieNode root = new TrieNode();

    public void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
            curr.count += 1;
        }
    }

    public int sum(String word) {
        TrieNode curr = root;
        int res = 0;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            curr = curr.children[idx];
            res += curr.count;
        }
        return res;
    }

    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        for (String word : words)
            add(word);
        for (int i = 0; i < words.length; i++)
            res[i] = sum(words[i]);
        return res;
    }
}