import java.io.*;

public class Main {
    public static void main (String[] args) {
        // Open training file, create and train spelling Trie
        File trainText = new File("/Users/marcusmartinez/cli-spellcheck/utils/train.txt");
        Trie spellings = new Trie();
        spellings.buildTrie(trainText);

        // Pull test text and spelcheck text
        File checkTextFile = new File("/Users/marcusmartinez/cli-spellcheck/utils/text.txt");
        Text checkText = new Text(checkTextFile);
        checkText.spellcheck(spellings);
        // TODO add check for default when using args
        checkText.outputCorrections("/Users/marcusmartinez/cli-spellcheck/utils/out.txt");
    }
}