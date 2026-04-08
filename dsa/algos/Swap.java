public class Swap {

    /// Simple program for swapping where we swap two string variables without using third or temp variable.


    public static void main(String[] args) {
        String x = "abc";
        String y = "def";

        System.out.println("X was: " + x);
        System.out.println("Y was: " + y );

        System.out.println("\n===========\n");

        // Concatenating both of the strings together... (abcdef) length of 6...
        x = x + y;

        /// Substring method: String substring(int start, int end)

        // Overriding (swapping) the initial String variable of "def" with the "front half" of the original String (last three chars)...
        // It's basically setting y = (start 0; to end position at 6 - 3 = 3)
        // Thereby getting the chars from index 0 to 3 (or abc)
        y = x.substring(0, x.length() - y.length());


        /// Substring method: String substring(int start)
        // Here we are assigning x to the remainder of y.length(), which is 3.
        x = x.substring(y.length());

        System.out.println("X is now: " + x);
        System.out.println("Y is now: " + y);

    }
}