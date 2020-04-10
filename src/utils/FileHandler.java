package utils;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileHandler {
    private static String createdFileName = "encryptedText.txt";
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
        String myLine = br.readLine();
        while (myLine != null) {
            textFromFile.append(myLine).append("\n");
            myLine = br.readLine();
        }

        return textFromFile.toString();

    }

    private static void createTxtFile() {
        try {
            File myObj = new File(createdFileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {

            System.out.println("Can not create file.");
            e.printStackTrace();
        }
    }

    private static void fillFileWithText(String text){
        try {
            FileWriter myWriter = new FileWriter(createdFileName);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Can not wrote to the file.");
            e.printStackTrace();
        }
    }

    public static void createFilledFile(String text){
        createTxtFile();
        fillFileWithText(text);
    }
}

