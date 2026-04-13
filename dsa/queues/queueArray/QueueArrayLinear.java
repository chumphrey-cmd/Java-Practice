
/// [GfG Implementation](https://www.geeksforgeeks.org/dsa/array-implementation-of-queue-simple/)
public class QueueArrayLinear {

    private int [] arr;

    // How many items are in the queue!
    private int size;

    // The maximum size of queue!
    private int capacity;

    public QueueArrayLinear() {

        // Max num of elements that queue can hold
        this.capacity = capacity;

        // Array to store the queue elements.
        arr = new int[capacity];
        size = 0;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return (size == capacity);
    }

    public int peek (int data){
        if (isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }

        return arr[data];
    }

    public void enqueue (int data){
        if (size == capacity){
            System.out.println("Queue is full");
            return;
        }

        arr[size++] = data;
    }

    public int dequeue (){
        if (isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }

        int data = arr[0];

        /// Here we are simulating the shift of the queue...
        for (int i = 1; i < size; i++)
            arr[i - 1] = arr[i];

        return data;
    }

    public int peek () {
        if (isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        return arr[0];
    }

}
