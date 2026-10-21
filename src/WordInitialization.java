import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordInitialization {
    public static String wordInit() {
        List<String> ArrayList = new ArrayList<>(List.of("шприц", "слово", "томат", "шпала", "плита"));

        Random random = new Random();
        int randomIndex = random.nextInt(ArrayList.size());

        return ArrayList.get(randomIndex);
    }
}