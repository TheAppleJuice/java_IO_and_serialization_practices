package se.lexicon;

import sun.font.GlyphList;

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

        //Exercise 5
        ArrayList <Car> cars = new ArrayList<>();
        Car citroen = new Car("ABC123", "Citroen", "C3", 2018);
        Car volvo = new Car("DEF456", "Volvo", "V60", 2012);
        Car porsche = new Car("LOL246", "Porsche", "Targa", 2020);
        cars.add(citroen);
        cars.add(volvo);
        cars.add(porsche);

        saveToList(cars, "exercise5Cars.ser");
        System.out.println("---------------------------------------");
        List<Car> result = readFromFile("exercise5Cars.ser");
        System.out.println("registrationNr: " + result.getRegistrationNr());
        System.out.println("brand: " + result.getBrand());
        System.out.println("model: " + result.getModel());
        System.out.println("modelYear: " + result.getModelYear());
        System.out.println("---------------------------------------");




        //Exercise



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
        } catch (IOException e) {
            e.printStackTrace();
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

// Ex 5b
    public static List<Car> saveToList (List<Car> source, String filePath){
        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))
        ){
            objectOutputStream.writeObject(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }

// Ex 5c
    public static List<Car> readFromFile (String filePath){
        try (
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))
            ){
                    objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /*<T> T readFromFile (String fileName){
        try (
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
                ){
            return (T) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }*/

    }

}
