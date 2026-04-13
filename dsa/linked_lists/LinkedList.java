/// 1. Define what the Nodes look like
// It holds a prize (data), and a piece of paper telling you where the next box is buried (next).
class Node {

    // 1. The Payload (The Cargo)
    // This holds the actual information we care about. We are using an 'int' here,
    // but in the future, this could be a String, an Employee object, or anything else!
    public int data;

    // 2. The Pointer (The Hook)
    // This is the magic of the Linked List. This variable doesn't hold an integer or text;
    // it holds the exact memory address of ANOTHER Node object.
    public Node next;

    // --- The Constructor ---
    // When we create a brand-new Node using the 'new' keyword, we only give it data.
    public Node(int data) {
        this.data = data;

        // By default, a brand-new node is floating in memory by itself. It isn't hooked up to the rest of the list yet, so its pointer points to 'null' (nowhere).
        this.next = null;
    }

    // --- Getters and Setters ---

    // retrieving data from the node
    public int getData() {
        return data;
    }

    // setting the data from the node
    public void setData(int data) {
        this.data = data;
    }

    // Locating where the next node will be... This hands back the memory address so the computer can go find it.
    public Node getNext() {
        return next;
    }

    // Tells the node where it should point to next and point to this specific Node instead. (this is how we link nodes together)
    public void setNext(Node next) {
        this.next = next;
    }

    // --- The Print Method ---
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

// This class acts as the manager for the sequence of nodes. It tracks the start of the list.
class LinkedList {

    // 'head' is a reference pointing to the very first Node in the sequence.
    private Node head;

    // Constructor: Initializes a new, empty linked list.
    LinkedList(){
        // Setting head to null indicates that the list currently contains zero nodes.
        this.head = null;
    }

    // Method to insert a new node at the very beginning of the sequence.
    public void addFirst(int data){

        // 1. Instantiate a new Node object containing the provided integer data.
        Node node = new Node(data);

        // 2. Check if the list is currently empty.
        if (head == null){
            // If empty, assign the new node as the 'head'. It is now the first and only item.
            head = node;
            return; // Exit the method early since the insertion is complete.
        }

        // 3. If the list already has nodes, point the new node's 'next' reference
        // to the current 'head' (the existing first node).
        node.setNext(head);

        // 4. Reassign the 'head' reference to the new node, officially making it the new start of the list.
        head = node;
    }

    // Method to append a new node to the end of the linked list.
    public void addLast(int data){

        // 1. Instantiate a new Node object containing the provided data.
        Node node = new Node(data);

        // 2. Check if the list is currently empty.
        if (head == null){
            // If empty, the new node becomes the head, and the insertion is complete.
            head = node;
            return;
        }

        // 3. Create a temporary traversal pointer ('ptr') starting at the head.
        // We use 'ptr' to move through the list without altering the permanent 'head' reference.
        Node ptr = head;

        // 4. Traverse the list to locate the final node.
        // The loop condition checks the node AFTER the current one. It stops executing exactly when 'ptr' is the last node (because ptr.getNext() will be null).
        while (ptr.getNext() != null){
            // Advance the pointer to the next node in the sequence.
            ptr = ptr.getNext();
        }

        // 5. Update the 'next' reference of the final node to point to the new node, officially adding it to the end of the list.
        ptr.setNext(node);
    }

    public void removeFirst(){
        if (head == null)
            return;
        head = head.getNext();
    }

    // Method to remove the final node from the linked list.
    public void removeLast(){

        // Case 1: The list is empty (0 nodes).
        if (head == null) {
            System.out.println("No nodes found");
            return; // Exit the method as there is nothing to remove.
        }

        // Case 2: The list contains exactly one node.
        // We check if the head node's 'next' reference is null.
        if (head.getNext() == null) {
            head = null; // Removing the head makes the list empty.
            return;
        }

        // Case 3: The list contains two or more nodes.
        // Initialize 'ptr' to traverse the list starting from the head.
        Node ptr = head;

        // Initialize 'prev' to keep track of the node immediately preceding 'ptr'.
        Node prev = null;

        // Traverse the list until 'ptr' reaches the final node.
        // The loop stops exactly when 'ptr.getNext()' is null.
        while(ptr.getNext() != null){

            // Update 'prev' to the current node before moving 'ptr' forward.
            prev = ptr;

            // Advance 'ptr' to the next node in the sequence.
            ptr = ptr.getNext();
        }

        // At the end of the loop, 'prev' is the second-to-last node, and 'ptr' is the last node.
        // Set 'prev.next' to null. This severs the connection to 'ptr', effectively removing it from the list.
        /// NOTE: this prevents the node from removing itself when it checks and sees that the next node is null
        prev.setNext(null);

    }

    public void display(){
        if (head == null)
            return;

        /// Here we ensure that WE DON'T TOUCH THE HEAD. We just manipulate a pointer(ptr) which is just a copy of head.
        Node ptr = head;

        /// This allows us to traverse the list of the linked list UNTIL ptr != null. At that point we exit
        while (ptr != null){
            System.out.println(ptr.getData());
            ptr = ptr.getNext();
        }
    }

    public boolean findValue(int value){

        // 1. Check if the list is empty. If so, the value cannot be found.
        if (head == null) {
            return false;
        }

        // 2. Initialize a pointer to start traversing from the head of the list.
        Node ptr = head;

        // 3. Traverse the list until the pointer reaches the end (null).
        while(ptr != null){

            // Check if the current node's data matches the target value.
            if (ptr.getData() == value){
                return true; // Match found, return true
            }

            // Advance the pointer to the next node to continue the search.
            // This must be outside the 'if' block so the loop keeps moving forward
            ptr = ptr.getNext();
        }

        // 4. If the loop completes without returning, the value does not exist in the list.
        return false;

    }

    /// Remove first node that contains the specific integer!
    public void removeValue(int value){

        // 1. Check if the list is empty. If so, nothing can be removed.
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        // 2. Initialize tracking pointers.
        // 'ptr' points to the current node being evaluated.
        Node ptr = head;
        // 'prev' tracks the node immediately preceding 'ptr'.
        Node prev = null;

        // 3. Traverse the list. The loop continues as long as two conditions are met:
        // a) The current node's data does NOT match the target value.
        // b) We have not reached the last node in the list.
        while (ptr.getData() != value && (ptr.getNext() != null)){
            prev = ptr;          // Update prev to the current node
            ptr = ptr.getNext(); // Advance ptr to the next node
        }

        // 4. Determine why the loop stopped.
        // If it stopped because it found the matching data:
        if (ptr.getData() == value){
            System.out.println("Found it! Removing node " + value);

            // Case A: The node to remove is the very first node (head).
            if(prev == null){
                // Update the head reference to skip the first node.
                head = head.getNext();
                return;
            }

            // Case B: The node to remove is in the middle or at the end.
            // Update the 'next' reference of the previous node to skip 'ptr'.
            prev.setNext(ptr.getNext());
            return;
        }

        // 5. If the loop finished and the data still doesn't match, the value isn't in the list.
        System.out.println("Could not find it :(");
        return;
    }

    public void sortedInsertion(int data){

        // 1. Instantiate the new Node.
        Node node = new Node(data);

        // 2. Case 1: The list is empty.
        if (head == null){
            head = node;
            return;
        }

        // 3. Initialize traversal pointers.
        Node ptr = head;
        Node prev = null;

        // 4. Traverse the list. The loop continues as long as:
        // a) The current node's data is strictly less than the new data.
        // b) We have not reached the final node in the list.
        while((ptr.getData() < data) && (ptr.getNext() != null)){
            prev = ptr;
            ptr = ptr.getNext();
        }

        // 5. Check if we found the correct insertion point (before 'ptr').
        if (ptr.getData() >= data){

            // Case 2: The new value is smaller than the current head.
            if (prev == null) {
                head = node;         // Update head to the new node.
                node.setNext(ptr);   // Link the new node to the old head.
                return;
            }

            // Case 3: The new value belongs in the middle of the list.
            prev.setNext(node);      // Link the previous node to the new node.
            node.setNext(ptr);       // Link the new node to the current node.
            return;
        }

        // 6. Case 4: We reached the end of the list, and the new data is the largest value.
        if (ptr.getNext() == null){
            ptr.setNext(node);       // Append the new node to the very end.
            return;
        }
    }
}

/// Main Driver
public class Main {

    public static void main(String[] args){

        LinkedList list = new LinkedList();

        // Adding to my created LinkedList, addFirst() follows first in, last out...

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        // Sanity check for finding value...
        System.out.println("Value Found: " + list.findValue(10));

        list.sortedInsertion(20);
        list.display();
    }

}