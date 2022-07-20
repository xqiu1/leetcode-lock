import java.util.*;

/**
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.
 */

class Longest_Substring_with_At_Most_K_Distinct_Characters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = 0;
        int[] counts = new int[26];
        int begin = 0, end = 0, uniqChar = 0;
        while (end < s.length()) {
            if (counts[s.charAt(end) - 'a'] == 0)
                uniqChar++;
            counts[s.charAt(end) - 'a']++;
            end++;
            while (uniqChar > k) {
                if (counts[s.charAt(begin) - 'a'] == 1)
                    uniqChar--;
                counts[s.charAt(begin) - 'a']--;
                begin++;
            }
            len = Math.max(len, end - begin);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
        System.out.println(lengthOfLongestSubstringKDistinct("ecaebae", 3)); // 5

    }
}