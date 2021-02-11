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
        System.out.println(fileContent);

        //Exercise 2
        File file2 = new File("line_of_names.txt");
           for (String string : bufferedReadText(file2)) {
                System.out.println(string);
            }
        //Exercise 3
        List<String> stringList = new ArrayList<>();
            stringList.add("Emma");
            stringList.add("Sebastian");
            stringList.add("Matteo");
            stringList.add("Oliver");

            File file3 = new File("exercise3.txt");
            writeStringtoTextfile(file3, stringList);

        //Exercise 4
        File source = new File("line_of_names.txt");
        File destination = new File("exercise4_destination.txt");
        bufferedCopyFile(source, destination);





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
    public static List<String> writeStringtoTextfile (File destination, List<String> source){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            for (String writeTo : source){
                bufferedWriter.write(writeTo);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

//Ex 4
    public static void bufferedCopyFile (File source, File destination){
        try (
                FileInputStream fileInputStream = new FileInputStream(source);
                BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destination))
                ){
            byte [] buffer = new byte[2048];
            int byteRead;

            while ((byteRead = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,byteRead);
            }
            outputStream.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
