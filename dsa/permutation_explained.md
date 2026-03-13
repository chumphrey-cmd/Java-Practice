# Explanation

`for (int i = 0; i < remaining.length(); i++)`

* This `for` loop iterates through the available letters we have left to pick from. "i" gradually increments through the length of the `remaining` string. **Because `remaining` shrinks as we build the word, this loop runs fewer times the deeper we go into the recursion.**

`String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);`

* Here we instantiate a new variable `newRemaining` to hold the letters we *didn't* pick.
* We use the `substring` built-in method to slice the word from index `0` up to `i`.
* We concatenate that left slice with the right slice starting at `i + 1`. What this does is perfectly grab the "left" and "right" side of the string, **entirely excluding the character at `i**` (which is the letter we just picked).

`String newPrefix = prefix + remaining.charAt(i);`

* Here we are building a `newPrefix`. We take our existing `prefix` (which starts off as an empty string) and concatenate the single character we just picked out of the pile using `remaining.charAt(i)`.

`permutation(newRemaining, newPrefix);`

* Lastly, we call the recursive `permutation` method on itself, passing in our freshly updated `newRemaining` and `newPrefix` variables.
* **NOTE:** Every single time the loop runs, a brand new `newRemaining` and `newPrefix` are created, and the recursive method is called. This is what causes the algorithm to branch out and explore every possible alternate reality of the word.