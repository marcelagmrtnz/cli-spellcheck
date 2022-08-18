import java.io.*;

public class Main {
    public static void main (String[] args) {
        // Open training file, create and train spelling Trie
        File trainText;
        if (args.length>=1) {
            trainText = new File(args[0]);
        } else {
            trainText = new File("../utils/train.txt");
        }
        Trie spellings = new Trie();
        spellings.buildTrie(trainText);

        // Pull test text and spellcheck text
        File checkTextFile;
        if (args.length>=2) {
            checkTextFile = new File(args[1]);
        } else {
            checkTextFile = new File("../utils/text.txt");
        }
        Text checkText = new Text(checkTextFile);
        checkText.spellcheck(spellings);

        // Write results to file
        String filename;
        if (args.length>=3) {
            filename = args[2];
        } else {
            filename = "../utils/out.txt";
        }
        checkText.outputCorrections(filename);
    }
}
