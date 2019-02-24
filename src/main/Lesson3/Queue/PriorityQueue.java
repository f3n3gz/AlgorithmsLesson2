package Queue;

public class PriorityQueue<E extends Comparable<E>> extends QueueImpl<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int rear;
    private int front;
    private int queueLenght;


    public PriorityQueue(int maxSize) {
        super(maxSize);
    }


    @Override
    public boolean insert(E value) {
        if (this.isFull()) {
            return false;
        }
        int i;
        if (size == 0) {
            data[size++] = value;
        } else {
            for (i = size - 1; i >= 0; i--) {
                if (value.compareTo(data[i]) > 0) {
                    data[i + 1] = data[i];
                } else {
                    break;
                }
            }
            data[i + 1] = value;
            size++;
        }
        return true;
    }


}
