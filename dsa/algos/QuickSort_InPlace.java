/*
 * Quick Sort is similar to Merge Sort, however instead of selecting or determining the exact mid-point, we set the mid-point ourselves. Depending on where the mid-point (pivot) is selected will determine the Time Complexity of the solution (https://www.w3schools.com/dsa/dsa_algo_quicksort.php).
 *
 * NOTE: as the algorithm progresses, the pivot point will reset to whatever index set it to (e.g., a low value (0) or high value (4). This will be used as a comparison for the other values.
 *
 * We are picking a point (pivot) within the list, and we follow this rule of thumb:
 * * IF the compared value, is GREATER than the pivot, then we move that value to the RIGHT of the pivot.
 * * ELSE IF the compared value is LESS than the pivot, then we move that value to the LEFT of the pivot.
 */
public class QuickSort_InPlaceSort {

    public static void main(String[] args){

        int [] arr = {1,20, 9, 3, 12, 35, 10, -12};

        // We pass the array, the starting index (0), and the final index (length - 1)
        quickSort(arr, 0, arr.length-1);

        System.out.println("Your Sorted List: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /// Recursion Implementation
    public static void quickSort(int [] arr, int low, int high){

        // Base condition, that the compiler will stop at when reached (when the array is size 1 or 0).
        if (low >= high){
            return;
        }

        // Here we are setting the pivotIndex or the specific pivot position that will be used to recursively sort the list.
        // NOTE: We only need to call partition ONCE here. It shuffles the data AND returns the index!
        int pivotIndex = partition(arr, low, high);

        // Sorting the left side (everything BEFORE the pivot)
        quickSort(arr, low, pivotIndex - 1);

        // Sorting the right side (everything AFTER the pivot)
        quickSort(arr, pivotIndex + 1, high);
    }

    /// Method Implementation
    public static int partition(int [] arr, int low, int high){

        // CLARIFICATION: We are NOT creating a new array here. We are just creating a standard integer variable to hold a single number.
        // 'high' is the index passed down from the method parameters. We are just grabbing the last number in our current chunk to act as the pivot.
        int pivot = arr[high];

        // Creating a "tracker" (or boundary) to identify where the "smaller than pivot" section ends.
        // CLARIFICATION: We use 'low - 1' because at the very start, we haven't found ANY numbers smaller than the pivot yet.
        // So, the boundary of our "smaller" section starts just outside/behind our current working area.
        int i = low - 1;

        // Simple for loop here where we are iterating through the original array.
        // CLARIFICATION: We use 'low' as the start instead of '0' because recursion breaks the array into smaller chunks.
        // If we are sorting the right half of the array, our chunk might start at index 5. 'low' tells our loop exactly where this specific chunk begins!
        for (int j = low; j <= high - 1; j++) {

            // IF the value at the position of arr[j] is LESS THAN the pivot, move the boundary up by one
            // THEN swap the value at arr[i] with arr[j] and set arr[j] equal to temp.
            if (arr[j] < pivot) {
                i++; // move boundary forward by 1

                // Standard Java swapping procedure (using a temporary int variable, not an array)
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // CLARIFICATION: Again, we are not creating an array, just a temporary 'int' variable to help us swap.
        // This is the grand finale of the method: We swap the pivot (which has been sitting at arr[high] this whole time)
        // into its permanent home right AFTER the boundary of smaller items (arr[i + 1]).
        int temp2 = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp2;

        // Return that permanent home index so the quickSort method knows where to split next!
        return i + 1;
    }
}

