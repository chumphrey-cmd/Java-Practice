
/// [CircularArray](https://www.geeksforgeeks.org/dsa/introduction-to-circular-queue/)

public class QueueArrayCircular {

    private int [] arr;
    private int front;
    private int size;
    private int capacity;

    public QueueArrayCircular(int capacity){

        size = 0;
        front = 0;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public boolean isEmpty (){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int peek(){
        if (size == 0){
            System.out.println("empty");
        }

        return arr[front];
    }


    /// This implementation here is unique because we're "bending" the typically linear array into a "circle" so that we can make the implementation
    /// Adding to the back!
    public void enqueue(int data){
        if (isFull()){
            System.out.println("full");
            return;
        }

        int location_back = (front + size) % capacity;
        arr[location_back] = data;
        size++;
    }

    /// Changing the front and the front has to move back...
    public int dequeue() {
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }

        int data = arr[front];

        /// Always removed from the front...
        front = (front + 1) % capacity;
        size--;
        return data;
    }
}
