//Import libaries
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class FileReadMain {
    public static void main(String[] args) {
        try {
            //Creating new file reader
            BufferedReader br = new BufferedReader(new FileReader("Metamorphosis.txt"));
            //setting variables
            int numberOfCharacters = 0, numberOfSentences = 0, numberOfParagraphs = 0, numbersOfWords = 0;
            ArrayList<String[]> strings = new ArrayList<>();

            while(br.ready()) {
                String currentLine = br.readLine();
                ///Checking num of chars
                numberOfCharacters += currentLine.length();

                if(currentLine.length() > 3) {
                    numberOfParagraphs++;
                }
                //checking num of sentences
                numberOfSentences += Pattern
                        .compile("[.!?]")
                        .matcher(currentLine)
                        .results()
                        .count();

                strings.add(currentLine
                        .toLowerCase()
                        .replaceAll("—", " ")
                        .replaceAll("([.,!?\"\'“”;]|'s|’s)", "")
                        .split(" "));
            }

            // counts the number of words
            for(String[] array : strings) {
                numbersOfWords += array.length;
            }

            // counts the number of duplicate words
            File file = new File("frequencies.txt");

            if(!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            HashMap<String, Integer> hashMap = new HashMap<>();


            for(String[] array : strings) {
                for(String word : array) {
                    if (hashMap.containsKey(word)) {
                        hashMap.put(word, hashMap.get(word) + 1);
                    } else {
                        hashMap.put(word, 1);
                    }
                }
            }

            for(String word : hashMap.keySet()) {
                bw.write(word + ": " + hashMap.get(word));
                bw.newLine();
            }

            // outputs the results
            System.out.println("Number of characters: " + numberOfCharacters);
            System.out.println("Number of words: " + numbersOfWords);
            System.out.println("Number of sentences: " + numberOfSentences);
            System.out.println("Number of paragraphs: " + numberOfParagraphs);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
