package org.example;

import java.io.File;

public class UtilityTree {

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param args
     */
    public static String PATH = ".\\src\\main\\java\\org\\";

    public static void main(String[] args) {


        print(new File("."), "", true);
//        print(new File("src/main/java/org/example"), "", true);

    }

    static void print(File file, String indent, boolean isLast) {

        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

//        System.out.println(file.getName());

        if (file.isDirectory()) {
            if (file.getPath().contains(PATH)) {
                System.out.println("/" + file.getName() + " (work dir)");
            } else {
                System.out.println("/" + file.getName());
            }
        } else {
            System.out.println(file.getName());
        }

//        File[] files = file.listFiles();
//
//        int subDirTotal = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//            {
//                subDirTotal++;
//            }
//        }
//
//        int subDirCounter = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//            {
//                print(files[i], indent, subDirTotal == ++subDirCounter);
//            }
//        }


        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    boolean isLastChild = (i == files.length - 1);
                    print(files[i], indent, isLastChild);
                }
            }
        }


    }

}

