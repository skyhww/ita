package leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] h = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(h));
    }

    public int maxArea(int[] height) {
        return max(height, 0, height.length - 1);
    }


    private int max(int[] height, int p, int q) {
        if (q == p + 1) {
            if (height[q] >= height[p]) {
                return height[p];
            }
            return height[q];
        }
        int m = 0;
        for (int i = p + 1; i <= q; i++) {
            int x = (i - p) * Math.min(height[p], height[i]);
            if (m < x) {
                m = x;
            }
        }
        int x = max(height, p + 1, q);
        return Math.max(m, x);
    }
}
