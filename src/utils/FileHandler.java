package utils;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class FileHandler {
    public static String findFile() {
        FileDialog fd = new FileDialog(new JFrame());
        fd.setVisible(true);
        File[] f = fd.getFiles();
        if (f.length > 0) {
            return fd.getFiles()[0].getAbsolutePath();
        } else return "Something goes wrong";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(findFile());
    }
}
