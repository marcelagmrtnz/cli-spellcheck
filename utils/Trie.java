import Node;
import java.util.Scanner;

class Trie {
    public Node root;

    public Trie (Node root) {
        this.root = root;
    }

    public static void addWord(String word, Node root) {
        Node curNode = root;
        for (int i = word.length; i>=0; i--) {
            // if curLetter is curNode value, stay
            // elif curLetter is in curNode children go to that node
            // else add curLetter to curNode children and go to that node
        }
    }

    public static String buildTrie (File trainText) {
        Scanner textReader = new Scanner(trainText);
        while (textReader.hasNextLine()) {
            String word = textReader.nextLine();
            addWord(word);
        }
    }
}
