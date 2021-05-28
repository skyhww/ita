package sort;

import java.util.Arrays;

/**
 * @author hanweiwei
 */
public class CountingSort implements Sort {
    public CountingSort(Integer maxValue) {
        this.maxValue = maxValue;
    }

    private Integer maxValue;

    /**
     * 时间复杂度正比于max{maxValue,target.length}
     *
     * @param target
     */
    public void sort(Integer[] target) {
        int[] c = new int[maxValue + 1];
        for (int integer : target) {
            c[integer] = c[integer] + 1;
        }
        //c[i]表示小于等于i的元素个数
        for (int i = 1; i <= c.length - 1; i++) {
            c[i] = c[i] + c[i - 1];
        }
        Integer[] b = new Integer[target.length];
        Arrays.fill(b, 0);
        for (int i = target.length - 1; i >= 0; i--) {
            //小于等于x的元素的个数是1，那么x将会被放置在b[0]
            //从后往前放置，迭代也是从后往前，稳定
            //当c[target[i]]==0，表示元素未出现，
            b[c[target[i]] - 1] = target[i];
            c[target[i]] = c[target[i]] - 1;
        }
        System.arraycopy(b, 0, target, 0, target.length);
    }
}
