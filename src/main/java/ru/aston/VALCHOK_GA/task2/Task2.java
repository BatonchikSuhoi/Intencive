package ru.aston.VALCHOK_GA.task2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args){
        String path1 = "D:\\JavaProjects\\Intencive\\src\\main\\java\\ru\\aston\\VALCHOK_GA\\task2\\File1.txt";
        String path2 = "D:\\JavaProjects\\Intencive\\src\\main\\java\\ru\\aston\\VALCHOK_GA\\task2\\File2.txt";
        String path3 = "D:\\JavaProjects\\Intencive\\src\\main\\java\\ru\\aston\\VALCHOK_GA\\task2\\FileToRead.txt";
        uniteFiles(path1,path2,path3);
        wantSomeMoney(path3);
        List<String> strings = stringFromTxt(path3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
    //Написать метод, который читает текстовый файл и возвращает его в виде списка строк.
    private static List<String> stringFromTxt(String filePath){
        List<String> strList = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)){
            int c;
            int i = 0;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1){
                str.append((char)c);
                if (str.indexOf("\n") == str.length()-1){
                    str.delete(str.length()-1,str.length());
                    strList.add(String.valueOf(str));
                    str.delete(0,str.length());
                    i++;
                }
            }
            strList.add(String.valueOf(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strList;
    }

    //Написать метод, который записывает в файл строку, переданную параметром
    private static void addStringToFile(String filePath,String strToAdd){
        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(strToAdd+"\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void uniteFiles(String firstToUnitePath, String secondToUnitePath, String saveFilePath){
        List<String> strings = stringFromTxt(firstToUnitePath);
        strings.addAll(stringFromTxt(secondToUnitePath));
        for (String s : strings){
            addStringToFile(saveFilePath,s);
        }
    }

    private static void wantSomeMoney(String filePath){
        List<String> strings = stringFromTxt(filePath);
        for (int j = 0; j < strings.size(); j++){
            StringBuilder sb = new StringBuilder(strings.get(j));
            for (int i = 0; i < sb.length(); i++){
                if (!Character.isLetterOrDigit(sb.charAt(i))){
                    sb.setCharAt(i,'$');
                    strings.set(j, sb.toString());
                }
            }
        }
        try (FileWriter writer = new FileWriter(filePath, false)){
            for (String s : strings) {
                writer.write(s+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
