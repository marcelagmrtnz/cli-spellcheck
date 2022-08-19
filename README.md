# cli-spellcheck
Simple command line tool to spellcheck files created with terminal text editors, or otherwise basic text files.

## System Requirements
- Java 1.8.0_201+

## System Set-Up

### Compile Code
```
javac -cp /src /src/Main.java
```

### Download a Word List
The system depends on a new line delimited (one word-per-line) text file with the vocabulary you want to represent your correctly-spelled word list.
You can use any resource that meets this requirement, but the system was tested with the "alpha_words.txt" file provided in [dwyl's](https://github.com/dwyl) 
[english-words](https://github.com/dwyl/english-words) repository. You can use the code below to download the file directly.

```
wget https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt
```

#### Expected Format
If you are using your own resource, be sure it uses the following format:
```
Alpha
Bravo
Charlie
```

## Running the System
The easiest way to run the system is with the provided bash script. You can also use java directly, but in that case it must be run from within the src directory.
Be sure to adjust your filepaths correctly, as both the bash script and java methods assume your current directory is the src directory.
So, if your files were in the root directory, you would need to pass in ```../file.txt```.

```
./spellcheck.sh [training_file] [text_file] [output_filename]
java Main [training_file] [text_file] [output_filename]
```
- ```training_file``` specifies the word list to build the spellcheck Trie from
- ```text_file``` specififes the text file that needs to be spellchecked
- ```output_filename``` specifies the title/location you want for the final text. By default the system prints to the terminal

## Output Format
The system will output your original text with ```*[ ]*``` surrounding any words misspelled, or not recognized by the system.
The system makes an assumption that the text the Trie is trained with is alphabetic characters only, and so removes non-alphabetic characters from the words as they are processed.
However, punctuation, numbers, etc. will be preserved in the output, just ignored at comparison time. This leads to some quirks with hyphenated words being treated as singular words,
so the system is not perfect and results should be reviewed.

Here's an example of input and expected output.
```
**Input**
Hello World! This si a system tht checks yur spelling.
```

```
**Output**
Hello World! This *[si]* a system *[tht]* checks *[yur]* spelling.
```

## Future Updates
- Implementing terminal nodes and backtracking/caching to allow for replacement suggestions in addition to identifying typos

## Credits
- [dwyl/english_words](https://github.com/dwyl/english-words)
