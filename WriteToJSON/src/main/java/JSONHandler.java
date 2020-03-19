import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONHandler {
    JSONParser parser = new JSONParser();
    Scanner input = new Scanner(System.in);

    private JSONArray getJSONArray(){
        //Getting the JSONArray from the file
        try {
            System.out.println("Write file you want to read from: ");
            String file = input.nextLine();
            Reader reader = new FileReader(file);
            return (JSONArray) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void readValues () {
        JSONArray jsonArray = getJSONArray();

        List<Country> countries = new ArrayList<>();

        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            countries.add(new Country(jsonObject.get("country").toString(), Integer.parseInt(jsonObject.get("Rank").toString()), jsonObject.get("population").toString()));
        }

        //JSON values have been read and put in an ArrayList as a Country object
        System.out.println(countries);

        writeToJSON(countries);
    }

    private void writeToJSON(List<Country> countries) {
        JSONArray newJSONarray = new JSONArray();

        //Country objects are taken from the array and transformed to a JSONobject, and then put in a JSONArray
        for (Country country : countries) {
            JSONObject object = new JSONObject();
            object.put("Rank", country.getRank());
            object.put("Country", country.getCountryName());
            object.put("Population", country.getPopulation());
            newJSONarray.add(object);
        }

        try{
            System.out.println("Write name of new file: ");
            String file = input.nextLine();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(newJSONarray.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
