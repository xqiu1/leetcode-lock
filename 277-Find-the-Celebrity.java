import java.util.*;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among
 * them,
 * there may exist one celebrity.
 * 
 * The definition of a celebrity is that all the other n - 1 people know him/her
 * but he/she does not know any of them.
 * 
 * There will be exactly one celebrity if he/she is in the party.
 * Return the celebrity's label if there is a celebrity in the party.
 * If there is no celebrity, return -1.
 * 
 * Example:
 * Input: graph = [[1,1,0],
 * [0,1,0],
 * [1,1,1]]
 * Output: 1
 */

class FindTheCelebrity {

    public static int findCelebrity(int n) {
        if (n <= 1)
            return -1;
        int celebrity = 0;
        // candidate
        for (int i = 0; i < n; ++i) {
            if (celebrity != i && knows(celebrity, i)) {
                celebrity = i;
            }
        }
        // if everyone in the group knows celebrity
        for (int i = 0; i < n; ++i) {
            if (celebrity != i && !knows(i, celebrity) && !knows(celebrity, i)) {
                return -1;
            }
        }
        return celebrity;
    }

    private static boolean knows(int i, int celeb) {
        // stub
        return false;
    }

    public static void main(String[] args) {

    }
}