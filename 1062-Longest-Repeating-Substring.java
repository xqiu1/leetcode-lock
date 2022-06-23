import java.util.*;

/**
 * [Medium]
 * 
 * Given a string S, find out the length of the longest repeating substring(s).
 * Return 0 if no repeating substring exists.
 * 
 * Input: "abbaba"
 * Output: 2
 * 
 * Note:
 * 1. The string S consists of only lowercase English letters from 'a' - 'z'.
 * 2. 1 <= S.length <= 1500
 */

class LongestRepeatingSubstring {

    public static int longestRepeatingSubstring(String S) {
        int maxLen = 0;
        TrieNode root = new TrieNode();
        int len = S.length();
        for (int i = 0; i < len; ++i) {
            TrieNode node = root;
            for (int j = i; j < len; ++j) {
                int index = S.charAt(j) - 'a';
                if (node.next[index] != null) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestRepeatingSubstring("aabcaabdaab")); // 3
        System.out.println(longestRepeatingSubstring("aaaaa")); // 4

    }
}

class TrieNode {
    TrieNode[] next;

    public TrieNode() {
        next = new TrieNode[26];
    }
}