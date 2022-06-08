package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    public static List<String[]> read(String file){
        List<String[]> data = new LinkedList<>();
        BufferedReader br = null;
        String dataRow;
        try {
            br = new BufferedReader(new FileReader(file));
            while((dataRow = br.readLine())!= null){
                String[] dataRecord = dataRow.split(",");
                data.add(dataRecord);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could Not Read File!");
            e.printStackTrace();
        }

        return data;
    }
}
