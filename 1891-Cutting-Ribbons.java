import java.util.*;

/**
 * You are given an integer array ribbons,
 * where ribbons[i] represents the length of the i-th ribbon, and an integer k.
 * You may cut any of the ribbons into any number of segments of positive
 * integer lengths,
 * or perform no cuts at all.
 * Your goal is to obtain k ribbons of all the same positive integer length.
 * You are allowed to throw away any excess ribbon as a result of cutting.
 * Return the maximum possible positive integer length that you can obtain k
 * ribbons of,
 * or 0 if you cannot obtain k ribbons of the same length.
 * 
 * Input: ribbons = [9,7,5], k = 3
 * output: 5
 * 
 * Input: ribbons = [7,5,9], k = 4
 * Output: 4
 */

class CuttingRibbons {

    // time: n + nlogn
    // space: 1
    public static int maxLength(int[] ribbons, int k) {
        int maxLen = 0;
        for (int ribbon : ribbons) {
            maxLen = Math.max(ribbon, maxLen);
        }
        int low = 0, high = maxLen;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int ribbon : ribbons) {
                if (mid > 0) {
                    count += ribbon / mid;
                }
            }
            if (count == k) {
                return mid;
            } else if (count > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(new int[] { 7, 5, 9 }, 4)); // 4
        System.out.println(maxLength(new int[] { 7, 5, 9 }, 22)); // 0
        System.out.println(maxLength(new int[] { 7, 5, 9 }, 3)); // 5
    }
}