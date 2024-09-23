package input;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ManualInputReader implements InputReader{
    @Override
    public HashMap<String, String> read() {
        var inputMap = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        String input;
        while(!(input = sc.nextLine()).equals("q")) {
            System.out.println(input);
            List<String> entry = Arrays.stream(input.split(":", 2))
                    .map(String::strip)
                    .toList();
            //System.out.println(entry.get(0) + " TEST " + entry.get(1));
            inputMap.put(entry.get(0), entry.get(1));
        }
        return inputMap;
    }
}
