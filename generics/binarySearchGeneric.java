public class Main {

    public static void main(String[] args){

        /// NOTE: List needs to be sorted!
        Integer[] arr = {10, 20, 30, 70, 80, 90, 110};
        System.out.println(binarySearch(arr, 20));

    }

    public static <T extends Comparable<T>> boolean binarySearch(T[] arr, T value){

        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if (arr[mid].compareTo(value) == 0)
                return true;

            if (arr[mid].compareTo(value) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
