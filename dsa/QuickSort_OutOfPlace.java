/*
 * Quick Sort is similar to Merge Sort, however instead of selecting or determining the exact mid-point, we set the mid-point ourselves. Depending on where the mid-point (pivot) is selected will determine the Time Complexity of the solution (https://www.w3schools.com/dsa/dsa_algo_quicksort.php).
 *
 * NOTE: as the algorithm progresses, the pivot point will reset to whatever index it is set to (e.g., a low value (0) or high value (4)). This will be used as a comparison for the other values.
 *
 * We are picking a point (pivot) within the list, and we follow this rule of thumb:
 * * IF the compared value, is GREATER than the pivot, then we move that value to the RIGHT of the pivot.
 * * ELSE IF the compared value is LESS than the pivot, then we move that value to the LEFT of the pivot.
 * * Best case scenario is O(N log N), worst case is O(N^2)
 */
public class QuickSort_OutOfPlace {

    public static void main(String[] args) {

        int[] arr = {1, 20, 9, 3, 12, 35, 10, -12};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Your Sorted List: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /// Recursion Implementation
    public static void quickSort(int[] arr, int low, int high) {

        // Base condition, that the compiler will stop at when reached.
        if (low >= high) {
            return;
        }

        // Here we are setting the pivotIndex or the specific pivot position that will be used to recursively sort the list.
        // NOTE: I removed the duplicate partition call here! We only need this one.
        int pivotIndex = partition(arr, low, high);

        // Sorting the left side
        quickSort(arr, low, pivotIndex - 1);

        // Sorting the right side
        quickSort(arr, pivotIndex + 1, high);
    }

    /// Method Implementation
    public static int partition(int[] arr, int low, int high) {

        // ANSWERING YOUR QUESTION: 'high' is coming directly from the parameters passed into this method by quickSort().
        // It represents the very last index of the specific "chunk" of the array we are currently looking at.
        int pivot = arr[high];

        // Here we are creating physical temporary arrays to hold the smaller (left) and larger (right) numbers.
        // The size is 'high - low' because that is the maximum possible number of elements in this chunk (excluding the pivot itself).
        int[] left = new int[high - low];
        int[] right = new int[high - low];

        /// Size trackers for our temporary arrays
        // Because they are using temporary arrays ('left' and 'right'), we don't need boundary pointers like 'low - 1' anymore. 'n1' and 'n2' do that job now.

        int n1 = 0; // Tracks how many items we put in 'left'
        int n2 = 0; // Tracks how many items we put in 'right'


        // The loop needs to start at 'low' and go up to 'high' (excluding 'high' because that is our pivot).
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                left[n1++] = arr[i]; // Add to left array, then increase n1
            } else {
                right[n2++] = arr[i]; // Add to right array, then increase n2
            }
        }

        // Now we paste the 'left' array back into our original main array.
        // We start pasting at index 'low', because that's where our current chunk begins!
        for (int i = 0; i < n1; i++) {
            arr[low + i] = left[i];
        }

        /// NOTE: Here we are placing the pivot exactly in the middle of our smaller and larger numbers.
        /// Its correct index is our starting point ('low') plus the number of smaller items that came before it ('n1').
        arr[low + n1] = pivot;

        /// Very important to pay attention here. We are adding and iterating using the indexes.
        /// Taking the starting index (low) + the size of the smaller numbers (n1) + 1 (to skip the pivot we just placed) + the incrementing index (i).
        for (int i = 0; i < n2; i++) {
            arr[low + n1 + 1 + i] = right[i];
        }

        // Return the absolute, permanent index where we placed the pivot
        return low + n1;
    }
}