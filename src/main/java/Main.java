import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = "file.txt";
        String encoding = "UTF-8";
        // Запись в файл
        PrintWriter writer = new PrintWriter(fileName, encoding);
        writer.println("# первая строка, а дальше 3 числа");
        writer.println("3 4 5");
        writer.close();

        // Чтение из файла
        Scanner scanner = new Scanner(Paths.get(fileName));
        String s = scanner.nextLine();
        System.out.println("Первая строка файла: " + s);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            System.out.println("Число из файла: " + i);
        }

        scanner.close();
    }
}
