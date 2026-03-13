/// Java program to find all permutations of a string recursively. For example, all permutations of string...

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
