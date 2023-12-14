import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileSearch {
    public static final Path PATH = Paths.get("C:\\\\testdir");

    public static void main(String[] args) throws IOException {

        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        int age = console.nextInt();

        System.out.println(Files.list(PATH).collect(Collectors.toList()));
        System.out.println(Files.find(PATH, 1, (p, a) -> a.isRegularFile() && p.getFileName().toString().endsWith(".txt")).collect(Collectors.toList()));

        Files.find(PATH, 1, (p, a) -> a.isRegularFile() && p.getFileName().toString().endsWith(".txt"))
                .forEach(p -> {
                    try {
                        System.out.println("File " + p.getFileName());
                        List<String> lines = Files.readAllLines(p);
                        System.out.println("2nd line: " + lines.get(1));
//                        System.out.println("4th line: " + lines.get(3));
//                        System.out.println("5th line: " + lines.get(4));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}