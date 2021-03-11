package sort;

/**
 * 最大堆
 * @author hanweiwei
 */
public class HeapSort implements Sort {
    public void sort(Integer[] target) {
        buildMaxHeap(target);
        for (int i = target.length - 1; i > 0; i--) {
            Integer tmp = target[0];
            target[0] = target[i];
            target[i] = tmp;
            forEach_heapify(target, 0, i);
        }
    }

    /**
     * 堆化，假设左右子堆都是已排序的，递归版本
     * 时间复杂度 logN
     *
     * @param target
     * @param i
     */
    private void heapify(Integer[] target, Integer i, Integer length) {

        Integer left = (i << 1) + 1;
        Integer right = left + 1;
        Integer largest = i;
        if (left >= length) {
            return;
        }
        largest = target[largest] < target[left] ? left : largest;
        if (right < length) {
            largest = target[largest] < target[right] ? right : largest;
        }
        if (largest != i) {
            Integer k = target[i];
            target[i] = target[largest];
            target[largest] = k;
            heapify(target, largest, length);
        }
    }

    /**
     * 非递归版本
     *
     * @param target
     * @param i
     */
    private void forEach_heapify(Integer[] target, Integer i, Integer length) {
        while (i < length) {
            Integer left = (i << 1) + 1;
            Integer right = left + 1;
            Integer largest = i;
            if (left >= length) {
                return;
            }
            largest = target[largest] < target[left] ? left : largest;
            if (right < length) {
                largest = target[largest] < target[right] ? right : largest;
            }
            if (largest.intValue() != i) {
                Integer k = target[i];
                target[i] = target[largest];
                target[largest] = k;
                i = largest;
            } else {
                i = length;
            }
        }
    }

    /**
     * 建堆
     * <p>
     * ceil(n/2)为第一个叶子节点
     * 时间复杂度O(n)
     *
     * @param target
     */
    private void buildMaxHeap(Integer[] target) {
        for (int i = target.length / 2 - 1; i >= 0; i--) {
            forEach_heapify(target, i, target.length);
        }
    }
}
