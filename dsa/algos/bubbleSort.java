public class BubbleSort {

    public static void main(String[] args) {

        int [] bubbleSort = {10, 5, 5, 8, 2};
        int size = bubbleSort.length;

        /// NOTE: Here we have a nested loop demonstrating in-efficiency (O(n^2) time complexity) NO GOOD.
        for (int i = 0; i < size - 1; i++){

            /// Here we are subtracting the length at "i" - 1
            for (int j = 0; j < size - i - 1; j++)

            /// Here we are initiating the "swap"
            /// If the value at the index position of "j" is > the index position at "i", initiate swap...
                if (bubbleSort[j] > bubbleSort [j + 1]){

                    ///  Universal way to swap low and high elements for comparison.
                    int tempPosition = bubbleSort[j];
                    bubbleSort[j] = bubbleSort[j+1];
                    bubbleSort[j+1] = tempPosition;
                }
        }

        // New school way...
        for (int j : bubbleSort) System.out.print(j + " ");

    }
}