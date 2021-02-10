package se.lexicon;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) {
        //Exercise 1
        File file = new File("/Users/sebastianbocaciu/Documents/textfile.txt");
        String fileContent = readText(file);
        System.out.println(fileContent);


    }

//Ex 1
    public static String readText (File source) {
        StringBuilder readText = new StringBuilder();
            try (
                    FileReader reader = new FileReader(source)
            ) {
                int i;
                while ((i = reader.read()) != -1) {
                    char letter = (char) i;
                    readText.append(letter);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readText.toString();
        }



}
