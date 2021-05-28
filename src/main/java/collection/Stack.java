package collection;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程安全的stack
 *
 * @param <T>
 * @author hanweiwei
 */
public class Stack<T> {
    private AtomicReference<Node<T>> tail = new AtomicReference<>();

    public void push(T t) {
        Node<T> node = new Node<>(t);
        while (true) {
            Node<T> m = tail.get();
            node.next = m;
            if (tail.compareAndSet(m, node)) {
                return;
            }
        }
    }

    public T pop() {
        while (true) {
            Node<T> t = tail.get();
            if (t == null) {
                return null;
            }
            if (tail.compareAndSet(t, t.next)) {
                return t.data;
            }
        }

    }

    public boolean isEmpty() {
        return tail.get() == null;
    }

    class Node<T> {
        private Node<T> next;
        private T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal=   new BigDecimal(3328353790172957696L);
        System.out.println(bigDecimal.divide(new BigDecimal(128)));
    }
}
