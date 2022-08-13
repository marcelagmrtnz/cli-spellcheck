import java.io.*;

public class Main {
    public static void main (String[] args) {
        // Open training file, create and train spelling Trie
        File trainText = new File("/Users/marcusmartinez/cli-spellcheck/utils/train.txt");
        Trie spellings = new Trie();
        spellings.buildTrie(trainText);

        // Pull test text and print spellcheck result 
        String test = args[0];
        boolean result = spellings.checkTrie(test);
        System.out.println(result);
    }
}