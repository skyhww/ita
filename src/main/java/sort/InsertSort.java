package sort;

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
