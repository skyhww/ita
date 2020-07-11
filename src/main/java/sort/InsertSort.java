package sort;

/**
 * 循环不变式：
 * target[0...j-1]表示已经排好的数组，target[j...n-1]表示待排部分
 * <p>
 * 初始：j=1，target[0]显然是已排序的
 * 保持:  假设对j成立，target[0...j-1]已排序 [j...n-1]待排，
 * [0...j-1] [j...n-1]
 * 对于下一次循环，分析内层跟外层循环，j=j+1,key=target[j-1]
 *
 * @author hanweiwei
 */
public class InsertSort implements Sort {

    public void sort(Integer[] target) {

        for (int j = 1; j < target.length; j++) {
            Integer key = target[j];
            int i = j - 1;
            //显然，如果target的是相对有序的，那么内层循环就会减少
            /**
             * 平均情况下，内层循环需要执行i/2次
             *
             * 1/2+2/2+...n/2= n(n+1)/4
             *
             * 时间复杂度O(n^2)
             */
            for (; i >= 0 && key < target[i]; i--) {
                target[i + 1] = target[i];
            }
            target[i + 1] = key;
        }
    }
}
