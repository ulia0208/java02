import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw2 {
    public static void main(String[] args) {

        // Дана json строка [{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
        // Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.        
        // Используйте StringBuilder для подготовки ответа        
        // Исходная json строка это просто String !!! Для работы используйте методы String, такие как replace, split, substring и т.д. по необходимости
        
        // Создать метод, который запишет результат работы в файл. Обработайте исключения и запишите ошибки в лог файл.
        ex1("[{  \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");         
    } 

    static void ex1(String s) {
        //s = "[{  \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        s=s.replace(" ", "");
        s=s.replace("[{", "");
        s=s.replace("}]", "");
        s=s.replace("\"", "");
        s=s.replace(",{", "");
        s=s.replace("фамилия", "Студент ");
        s=s.replace("оценка", " получил ");
        s=s.replace("предмет", " по предмету ");
        s=s.replace(":", "");
        s=s.replace(",", "");
        String[] sArray =s.split("}");
        //System.out.println(s);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sArray.length ; i++) {
            stringBuilder.append(sArray[i]+"\n");
        }
        String str_sb=stringBuilder.toString();
        System.out.println(str_sb);
        
        saveToFile(str_sb);
        
    }

    static void saveToFile(String s){
        Logger logger=Logger.getAnonymousLogger();
        FileHandler fHandler=null;
        try{
            fHandler=new FileHandler("log.txt");
        } catch(IOException e){
            e.printStackTrace();
        }
        
        
        logger.addHandler((fHandler));
        String path ="f/f/f/ftest.txt";
        
        try(FileWriter fileWriter=new FileWriter(path)) {    
            fileWriter.write(s);
            fileWriter.flush();
            } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "--//////--Ошибка--//////--");
        }
        fHandler.close();
    }

    
}
