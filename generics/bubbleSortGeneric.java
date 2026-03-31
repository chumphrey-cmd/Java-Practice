package mar.mar_30.bubbleSortGenerics;

public class Main {

    public static void main(String[] args){

        Integer [] arr = {10, 5, 5, 8, 2};
        bubbleSort(arr);
        for (Integer item : arr)
            System.out.println(item);

    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr){

        int size = arr.length;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0){

                    /// Generic implementation here!
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }


    }
}