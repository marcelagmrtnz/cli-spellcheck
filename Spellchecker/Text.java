import java.util.*;
import java.io.*;

class Text {
    public List<String> content;
    public List<String> checkedContent;

    public Text (File textFile) {
        this.content = parseFile(textFile);
        this.checkedContent = new ArrayList<>();
    }

    // Pulls text from file to be checked to initialize content variable
    public List<String> parseFile (File textFile) {
        List<String> textContent = new ArrayList<>();

        try {
            Scanner textReader = new Scanner(textFile);
            textReader.useDelimiter(" ");
            while (textReader.hasNext()) {
                textContent.add(textReader.next());
            }
            textReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return textContent;
    }

    // Checks text against the spellcheck Trie
    public void spellcheck (Trie spellings) {
        for (int i = 0; i<=content.size()-1; i++) {
            String word = content.get(i);
            String strippedWord = word.replaceAll("[^A-Za-z]", "").toLowerCase();
            
            if (!spellings.checkTrie(strippedWord)) {
                if (word.charAt(word.length()-1) == '\n') {
                    word = word.replaceAll("[\n]", "");
                    word = "*["+word+"]*\n";
                } else {
                    word = "*["+word+"]*";
                }
            }
            checkedContent.add(word);
        }
    }

    // Writes results to file
    public void outputCorrections (String filename) {
        try {
            File output = new File(filename);
            if (!output.createNewFile()) {
                if (!output.delete()) {
                    System.out.println("File could not be created! Try a new filename.");
                    return;
                }
                output.createNewFile();
            }

            try {
                FileWriter textWriter = new FileWriter(filename);
                String outputContent = String.join(" ", checkedContent);
                textWriter.write(outputContent);
                textWriter.close();
            } catch (IOException e) {
                System.out.println("Results could not be output!");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("File could not be created!");
            e.printStackTrace();
        }
    }
}