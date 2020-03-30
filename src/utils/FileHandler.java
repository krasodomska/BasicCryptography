package utils;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileHandler {
    public static String findFile() {
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
        File[] f = fd.getFiles();
        if (f.length > 0) {
            return fd.getFiles()[0].getAbsolutePath();
        } else return "Something goes wrong";
    }

    public static String fileContent() throws IOException {
        String filePath;
        Matcher m;
        do {
            filePath = findFile();
            System.out.println(filePath);
            Pattern patternOnlyTxt = Pattern.compile("txt");
            m = patternOnlyTxt.matcher(filePath);

        } while (!m.find());
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder textFromFile = new StringBuilder();
        while (( br.readLine()) != null)
            textFromFile.append(br.readLine()).append("\n");

        return textFromFile.toString();

    }

    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky,\n but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

