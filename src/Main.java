import java.util.Random;

public class Main {
    static final String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void main(String[] args) {
        final Random rand = new Random();
        StringBuilder currentWord;
        boolean keepGoing;

        do {
            final int wordLength = InputHelper.getInt("What do you want the length of the word to be?");

            do {
                currentWord = new StringBuilder();
                for (int i = 0; i < wordLength; i++) {

                    currentWord.append(alphabet[rand.nextInt(alphabet.length)]);

                }

            }while(!hasVowelCheck(currentWord.toString()));

            System.out.println("[WORD]: "+currentWord);

            keepGoing = InputHelper.getYN("Do you want to generate another word?");
        }while (keepGoing);
    }

    private static boolean hasVowelCheck(String word){
        final char[] vowels = {'a','e','i','o','u'};
        final char[] wordAsList = word.toCharArray();

        for(char currentChar:wordAsList){
            for(char vowel:vowels){if(currentChar==vowel){return true;}}
        }

        return false;
    }
}