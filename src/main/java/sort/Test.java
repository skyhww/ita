package sort;

public class Test {
    public static Sort sort = new MergeSort();

    public static void main(String[] args) {
        Integer[] s = {3, 9, 8, 4, 1, 5, 7, 3, 2, 1};
        sort.sort(s);
        for (Integer integer : s) {
            System.out.println(integer);
        }
    }
}
