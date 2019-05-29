/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n) == 0) return n;
        int min = 0;
        int max = n;
        while(min < max) {
            int mid = min + ((max - min) / 2);
            int guessRes = guess(mid);
            if(guessRes == 0) return mid;
            else if(guessRes < 0) {
                max = mid;
            } else if(guessRes > 0) {
                min = mid;
            }
        }
        return -1;
    }
}
