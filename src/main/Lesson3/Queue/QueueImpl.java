package Queue;

public class QueueImpl<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int rear;
    private int front;
    private int queueLenght;


    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        queueLenght = maxSize;
        rear = -1;
    }


    @Override
    public boolean insert(E value) {
        if (this.isFull()) {
            return false;
        }
        rear = rear % (queueLenght - 1);
        data[rear++] = (E) value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (this.isEmpty()) {
            return null;
        }
        E temp = data[front++];
        front = front % queueLenght;
        size--;
        return temp;
    }

    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
