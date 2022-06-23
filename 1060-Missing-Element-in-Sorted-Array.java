import java.util.*;

/**
 * [Medium]
 * 
 * Given a sorted array A of unique numbers,
 * find the K-th missing number starting from the leftmost number of the array.
 * 
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 */

/**
 * 4 7 9 10
 * 0 1 2 3
 * 0 (7-4-1) (9-4-2) .. (nums[i] - nums[0] - i)
 */

class MissingElement {
    // binary search
    // time: logn
    // space: 1
    public static int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return k;
        }
        int left = 0, right = nums.length - 1;
        if (k >= nums[right] - nums[0] - right) {
            return nums[left] + (k - (nums[right] - nums[0] - right));
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - nums[0] - mid > k) {
                right = mid - 1;
            } else if (nums[mid] - nums[0] - mid == k) {
                return nums[mid] - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] - (nums[left] - nums[0] - left - k);
    }

    public static void main(String[] args) {
        System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 1));
        System.out.println(missingElement(new int[] { 4, 7, 9, 10 }, 3));
        System.out.println(missingElement(new int[] { 1, 2, 4 }, 3));
    }
}