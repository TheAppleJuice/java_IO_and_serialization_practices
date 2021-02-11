package se.lexicon;


import se.lexicon.model.StringObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        //Exercise 1
        File file1 = new File("/Users/sebastianbocaciu/Documents/textfile.txt");
        String fileContent = readText(file1);
        //System.out.println(fileContent);

        //Exercise 2
        /*File url = new File("line_of_names.txt");
            for (String string : bufferedReadText(url)) {
                System.out.println(string);*/
            }
        //Exercise 3
            List<String> stringList = new ArrayList<>();
            stringList.add("Emma");
            stringList.add("Sebastian");
            stringList.add("Matteo");
            stringList.add("Oliver");

            File ex3 = new File("exercise3.txt");
            writeStringtoTextfile(ex3, stringList);



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

//Ex 2
    public static List<String> bufferedReadText(File source) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line); }
        } catch (IOException e) { e.printStackTrace();
        }
        return strings; }

//Ex 3
    public static List<String> writeStringtoTextfile (File destination, List<String> src){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            for (String writeTo : src){
                bufferedWriter.write(writeTo);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

}
