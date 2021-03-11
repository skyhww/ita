package sort;

/**
 * 快速排序
 * A[p,q] [q+1,r]   [p,q]中的元素都小于等于[q+1,r]中的元素
 * @author hanweiwei
 */
public class QuickSort implements Sort {

    public void sort(Integer[] target) {
        quick(target, 0, target.length - 1);
    }

    /**
     * 每次排序前，增加一个随机交换
     *
     * @param target
     * @param p
     * @param r
     */
    private void quick(Integer[] target, Integer p, Integer r) {
        if (p < r) {
            Integer q = partition(target, p, r);
            quick(target, q, p);
            quick(target, q + 1, r);
        }
    }

    /**
     * 返回partition，以最后一个元素为基
     * q的左边的key<=x
     * <p>
     * O(n)
     * 数组被分为三个部分 [p,q] [q+1,j] [j+1,r]
     *
     * @param target
     * @param p
     * @param r
     * @return
     */
    private Integer partition(Integer[] target, Integer p, Integer r) {
        //i的下一个元素比q大
        int q = p - 1;
        Integer x = target[r];
        //i的右边保留了一个大于等于x的元素，j往前推，如果发现一个比x小的元素，则把这个元素跟a[i+1]交换i++
        //交换次数=比x小的元素个数
        for (int j = p; j < r; j++) {
            if (target[j] < x) {
                q++;
                Integer v = target[q];
                target[q] = target[j];
                target[j] = v;
            }
        }
        target[r] = target[q + 1];
        target[q + 1] = x;
        return q + 1;
    }


}
