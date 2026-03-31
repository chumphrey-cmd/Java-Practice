public class Main {

    public static void main(String[] args) {

        Integer[] arr = {10, 50, 30, 70, 80, 20, 90, 40};
        System.out.println(linearSearch(arr, 20));
    }

    /// Generic Implementation Here!
    public static <T> boolean linearSearch(T[] arr, T value) {

        for (T item : arr)
            if (item == value)
                return true;
        return false;
    }

}