import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordInitialization {
    public static String getRandomWord() {
        String word;
        List<String> words = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/words.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            words.add(word);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }
}