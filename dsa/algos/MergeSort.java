public class MergeSort {

    /// Iteratively separating an Array into its simplest form, which are sorted!
    /// Once it is sorted to it's most basic components, you reconstitute and combine!
    /// MOST efficient because it is linearithmic O(n * log * n)
    /// No matter how large the data set is, the best case and worst case are the same = VERY SAFE and RELIABLE algorithm!

    // PHASE 1: Setting up the array...
    public static void main(String[] args){

        int [] arr = {99, 2, 54, 1, 8, 77, 5};
        // Indices = 0, 1, 2, 3, 4, 5, 6

        //int [] arr = {1,2,3,4,5,6,7};

        mergeSort(arr, 0, arr.length-1);
        for (int i : arr)
            System.out.println(i);
    }

    // PHASE 2: Recursion here... DIVIDE INDICES HERE!!!
    /// The components here are viewing the elements of the array via INDICES.
    /// We are strictly doing the math ONLY on the INDEX-POSITION values (e.g., 0,1,2,3...)
    /// We do the actual value calculation when we call our merge(arr, lower, mid, higher) method!!

    public static void mergeSort(int[] arr, int lower, int higher){

        // Terminating Case!
        // Here we are comparing the values at each index of the array with one another...

        if (lower >= higher){
            return;
        }

        /// NOTE: The computer executing recursion reads depth-first.
        // Finding the mid-point of the array so that we can pull the left and right sides...
        int mid = lower + (higher - lower) / 2;
        // mid = 0 + (6 - 0)/2
        // mid = 3

        // Sorting the LEFT (lower)...
        /// MEANING: Look at the array starting from our current left bookmark (lower), and stop exactly at the center bookmark (mid).
        mergeSort(arr, lower, mid);

        // Sorting the RIGHT (higher)...
        /// MEANING: Look at the array starting one spot after the center (mid + 1), and go all the way to our current right bookmark (higher).
        mergeSort(arr, mid + 1, higher);

        // Merging the lower, middle, and higher back together again...
        /// Looks at the values inside the boxes, compares them, and glues them back together in numerical order.
        merge(arr, lower, mid, higher);

        int x = 0;
    }

    // PHASE 3: Actually organizing and iterative logic to sort the arrays!
    /// CONQUER HERE AND SORT THE VALUE AT EACH INDEX HERE (e.g., 0,1,2 = 99,2,4)
    public static void merge(int [] arr, int lower, int mid, int higher) {

        int left = mid - lower + 1;
        int right = higher - mid;
        int combined = left + right;

        ///  This is essentially getting the length of each of the arrays that we're passing similar to arr.length
        int [] arr_left = new int[left];
        int [] arr_right = new int[right];
        int [] arr_comb = new int[combined];

        for (int i = 0; i < left; i++)

        /// Here we are grabbing the "left most" side of the array...
            arr_left[i] = arr[lower + i];

        for (int i = 0; i < right; i++)

        /// Here we are grabbing the "right side" of the array...
            arr_right[i] = arr[mid + i + 1];


        int i = 0; // for arr_left
        int j = 0; // for arr_right
        int k = 0; // for arr_comb that is the length of arr_left + arr_right...

        /// Same process for sorting and merging as before...
        // Here we are comparing the values of each list to one another (ORDERING)
        // IF index[0] in arr1 < index[0] in arr2, move arr1 to the left of the list
        // ELSE swap move arr2 to the right of the list
        // Assign arr1 to the left

        while ((i < arr_left.length) && (j < arr_right.length))
            if(arr_left[i] < arr_right[j])
                arr_comb[k++] = arr_left[i++];

            else
                arr_comb[k++] = arr_right[j++];

        /// This portion of the list will take apart both of separated list
        while (i < arr_left.length)
            arr_comb[k++] = arr_left[i++];

        while (j < arr_right.length)
            arr_comb[k++] = arr_right[j++];

        for (i =0; i < arr_comb.length; i++)
            arr[lower + i] = arr_comb[i];
    }
}