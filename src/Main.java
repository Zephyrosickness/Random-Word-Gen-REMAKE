import java.util.Random;

public class Main {
    static final String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void main(String[] args) {
        final Random rand = new Random();
        StringBuilder currentWord;
        boolean keepGoing;

        do {
            final int wordLength = InputHelper.getPositiveInt("What do you want the length of the word to be?");

            final int vowelLength = InputHelper.getRangedInt("How many vowels do you want the word to have? (Type 0 for any)",0);

            do {
                currentWord = new StringBuilder();
                for (int i = 0; i < wordLength; i++) {
                    currentWord.append(alphabet[rand.nextInt(alphabet.length)]);
                }

            }while(!(hasVowelCheck(currentWord.toString(),vowelLength)&&!hasUncommonLetterCheck(currentWord.toString())));

            System.out.println("[WORD]: "+currentWord);

            keepGoing = InputHelper.getYN("Do you want to generate another word?");
        }while(keepGoing);
    }

    private static boolean hasVowelCheck(String word, int targetVowelCount){
        final String halfWord = word.substring(0, word.length()/2); //cut word in half because there should be a vowel in the first half
        final char[] vowels = {'a','e','i','o','u'};

        boolean hasVowel = false;
        int vowelCount = 0;

        for(char currentChar: halfWord.toCharArray()){
            for(char vowel:vowels){if(currentChar==vowel){hasVowel = true;}}
        }

        for(char currentChar:word.toCharArray()){
            for(char vowel:vowels){
                if(currentChar==vowel){
                    vowelCount++;
                }
            }
        }

        return hasVowel&&vowelCount>=targetVowelCount;
    }

    private static boolean hasUncommonLetterCheck(String word){
        final char[] uncommon = {'q','x','j','z','v'};
        final char[] wordAsList = word.toCharArray();

        for(char currentChar:wordAsList){
            for(char uncommonLetter : uncommon){if(currentChar==uncommonLetter){return true;}}
        }

        return false;
    }
}