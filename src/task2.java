public import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class ReadFileTests {

    @Test
      public static void secondLineShouldHabAlloha(String[] args) {
        try {
            File file = new File("src/test/resources/ReadFileTests.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line);  можно выводить все содержимое файла по строчно
                if (line.contains("аллоха")) {
                  System.out.println("Line: " + getLineCountByReader(fr) +"строка содержит слово аллоха");} // идея такая:  getLineCountByReader это счетчик (изначально 0),
                // на каждом цикле считывания строки из файла он должен расти n = n+1; 
                // public static long getLineCountByReader(String file) throws IOException {
                // try (var lnr = new LineNumberReader(new BufferedReader(new FileReader(file)))) {
                // while (lnr.readLine() != null) ;
                // return lnr.getLineNumber(); к сожалению, на данный момент объединить эти участки без подсказки у меня не получается

                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
          e.printStackTrace();}
          finally { System.out.println("");        
        }}}
