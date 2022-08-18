import java.io.*;

public class Main {
    public static void main (String[] args) {
        // Open training file, create and train spelling Trie
        File trainText = new File(args[0]);
        Trie spellings = new Trie();
        spellings.buildTrie(trainText);

        // Pull test text and spellcheck text
        File checkTextFile = new File(args[1]);
        Text checkText = new Text(checkTextFile);
        checkText.spellcheck(spellings);

        // Write results to file
        if (args.length>=3) {
            checkText.outputCorrections(args[2], false);
        } else {
            checkText.outputCorrections(null, true);
        }
    }
}
