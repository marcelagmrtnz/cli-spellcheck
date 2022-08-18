import java.util.*;
import java.io.*;

class Trie {
    public Node root;

    public Trie () {
        this.root = new Node('0');
    }

    // Adds single word to Trie
    public void addWord (String word) {
        Node curNode = root;
        for (int i = 0; i<=word.length()-1; i++) {
            char curLetter = word.charAt(i);
            int curAscii = ((int) curLetter)-((int) 'a');

            // if curLetter is in curNode's children go to that node
            if (curNode.children.get(curAscii)!=null) {
                curNode = curNode.children.get(curAscii);
            } else {
                // else add curLetter to curNode's children and go to that node
                curNode.children.set(curAscii, new Node(curLetter));
                curNode = curNode.children.get(curAscii);
            }
        }
    }

    // Builds Trie word by word, pulling words from a word-per-line text file
    public void buildTrie (File trainText) {
        try {
            Scanner textReader = new Scanner(trainText);
            while (textReader.hasNextLine()) {
                String word = textReader.nextLine();
                addWord(word);
            }
            textReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    // Checks if word exists in Trie
    public boolean checkTrie (String word) {
        Node curNode = root;
        for (int j=0; j<=word.length()-1; j++) {
            char curLetter = word.charAt(j);
            int curAscii = ((int) curLetter)-((int) 'a');
            
            // word, as spelled, is not found
            if (curNode.children.get(curAscii)==null) {
                return false;
            } else {
                curNode = curNode.children.get(curAscii);
            }
        }
        // word, as spelled, is found
        return true;
    }
}
