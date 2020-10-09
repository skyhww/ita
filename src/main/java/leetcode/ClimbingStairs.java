package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer m = map.get(n);
        if (m != null) {
            return m;
        }
        m = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, m);
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(45));
    }
}
