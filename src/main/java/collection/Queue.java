package collection;

/**
 * 队列元素  包含了n-1个元素
 *
 * @author hanweiwei
 */
public class Queue {
    private Object[] array;
    //将要消费
    private int head;
    //将要插入
    private int tail;

    public Queue(Integer size) {
        this.array = new Object[size];
    }

    void enQueue(Object obj) {
        Integer next = (tail + 1) % array.length;
        if (next == head) {
            return;
        }
        array[tail] = obj;
        tail = next;
    }

    Object deQueue() {
        if (head == tail) {
            return null;
        }
        Object obj = array[head];
        head = (head == array.length - 1) ? head + 1 : 0;
        return null;
    }


}
