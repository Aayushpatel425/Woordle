//Aayush Patel - 7/19/2022
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //The user can put any word in this parameter to guess
        checkWord("smile");
    }

    public static void checkWord(String targetWord) {
        System.out.println("Please enter a " + targetWord.length() +  " letter word");

        //The user get 6 tries to get the word correct
        for (int j = 6; j >= 0; j--) {
            // Scanner Objects for the user to type in the word
            Scanner myScanner = new Scanner(System.in);
            System.out.println();
            String userInput = myScanner.nextLine();

            // Throw illegalArgumentException if the userInput size is not equal to target word
            if (userInput.length() != targetWord.length()) {
                throw new IllegalArgumentException("Enter a " + targetWord.length() + " letter word");
            }
            List<Character> newList = new ArrayList<>();
            List<Character> targetList = new ArrayList<>();
            // Checks to see if the userInput word is correct with the target word
            for (int i = 0; i < targetWord.length(); i++) {
                if (targetWord.charAt(i) == userInput.charAt(i)) {
                    newList.add(targetWord.charAt(i));
                } else {
                    newList.add('#');
                }
                targetList.add(targetWord.charAt(i));
            }
            //Prints out if the letter in the userInput is present in the target word
            for (int p = 0; p < userInput.length(); p++) {
                if (targetList.contains(userInput.charAt(p))) {
                    System.out.println("The word contains the letter: " + userInput.charAt(p));
                }
            }

            //Prints out the userInput with # (if incorrect) or the correct letter
            for (int k = 0; k < newList.size(); k++) {
                System.out.print(newList.get(k));
            }
            System.out.println();
            System.out.println("___________________________");

            //Checks to see if the userInput is equal to the target word
            if (targetWord.equals(userInput)) {
                System.out.println();
                System.out.println("You are correct");
                int x = 6 - j + 1;
                System.out.println("You finished in " + x + " tries");
                break;
            }
            //Prints out the number of tries remaing
            System.out.println("You have " + j + " tries remaining");
        }
    }
}