package sort;

/**
 * 合并排序
 *
 * @author hanweiwei
 */
public class MergeSort implements Sort {
    public void sort(Integer[] target) {
        sort(target, 0, target.length - 1);
    }

    private void sort(Integer[] target, Integer p, Integer r) {
        if (p < r) {
            int l = r + p;
            Integer q = (l - l % 2) / 2;
            sort(target, p, q);
            sort(target, q + 1, r);
            merge(target, p, q, r);
        }
    }

    private void merge(Integer[] target, Integer p, Integer q, Integer r) {
        //[p,q],[q+1,r]
        Integer[] left = new Integer[q - p + 2];
        Integer[] right = new Integer[r - q + 1];

        if (q + 1 - p >= 0) System.arraycopy(target, p, left, 0, q + 1 - p);
        left[q - p + 1] = Integer.MAX_VALUE;
        for (int i = q + 1; i <= r; i++) {
            right[i - q - 1] = target[i];
        }
        right[r - q] = Integer.MAX_VALUE;
        for (int i = 0, j = 0, k = p; k <= r; k++) {
            /**
             * 考虑，这里不是小于等于，会发生什么
             */
            if (left[i] <= right[j]) {
                target[k] = left[i];
                i++;
            } else {
                target[k] = right[j];
                j++;
            }
        }

    }
}
