/// Java program to find all permutations of a string recursively. For example, all permutations of string...

// === FOR LOOP EXPLANATION ===
//
// Inside the recursive method, the for-loop is what generates every possible branch
// of the permutation tree. Here's exactly what's happening, line by line:

// 1. remaining  = the characters STILL WAITING to be placed
//    prefix    = the characters we have ALREADY chosen (built so far)
//
// 2. We loop through every possible character we could pick NEXT:
//    for (int i = 0; i < remaining.length(); i++) {
//
//    At each step we do three things:
//
//    a) Create a newRemaining by REMOVING the character at position i
//       String newRemaining = remaining.substring(0, i)          // everything BEFORE i
//                         + remaining.substring(i + 1);         // everything AFTER i
//       → This skips the chosen character so it doesn't appear again in future calls.
//
//    b) Build the newPrefix by adding the chosen character to whatever we already have
//       String newPrefix = prefix + remaining.charAt(i);
//       → This grows the permutation one letter at a time.
//
//    c) Recurse with the updated pieces
//       permutation(newRemaining, newPrefix);
//       → This starts the exact same process on the smaller string (one character shorter).
//    }
//
// The loop runs exactly "remaining.length()" times on each level, and because we create
// fresh newRemaining + newPrefix every iteration, each branch of the tree is completely
// independent. When remaining finally becomes empty, the base case prints the finished
// prefix (a complete permutation).

public class Permutations {

    public static void main(String[] args){
        String remaining_word = "JSP";
        permutation(remaining_word, "");
    }

    public static void permutation(String remaining, String prefix){

        if (remaining.isEmpty()){
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            String newPrefix = prefix + remaining.charAt(i);
            permutation(newRemaining, newPrefix);
        }

    }

}
