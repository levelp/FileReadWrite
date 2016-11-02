import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class ReadWriteTest extends Assert {
    private Random gen = new Random();

    @Test
    public void testReadWrite() throws IOException {
        String fileName = "file.txt";
        String encoding = "UTF-8";
        // Запись в файл
        PrintWriter writer = new PrintWriter(fileName, encoding);
        writer.println("# первая строка, а дальше 3 числа");
        writer.println("3 4 5");
        double d = gen.nextDouble();
        writer.println(d);
        writer.close();

        // Чтение из файла
        Scanner scanner = new Scanner(Paths.get(fileName));
        scanner.useLocale(Locale.ENGLISH);
        String s = scanner.nextLine();
        System.out.println("Первая строка файла: " + s);
        assertEquals("# первая строка, а дальше 3 числа", s);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.println("Число из файла: " + i);
        }
        double d2 = scanner.nextDouble();
        assertEquals(d, d2, 1e-15);

        scanner.close();
    }
}
