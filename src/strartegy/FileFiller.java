package strartegy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileFiller implements Filler{
    @Override
    public List<?> fillCollection(String fileName,List<?> list) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName));){
            String line;
            while ((line = br.readLine()) != null) {
                String[] field = line.split(",");
                String field0 = field[0];
                int field1 = Integer.parseInt(field[1]);
                int field2 = Integer.parseInt(field[2]);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
