import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsersList {
    public static void main(String[] args) throws IOException, ParseException {

        String fileLocation ="./src/main/resources/users.json";

        JSONParser parser = new JSONParser();
        JSONArray usersArray = (JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject adminObj = new JSONObject();
        JSONObject studentObj = new JSONObject();

        adminObj.put("username", "admin");
        adminObj.put("password","1234");
        adminObj.put("role","admin");

        studentObj.put("username","salman");
        studentObj.put("password","1234");
        studentObj.put("role","student");

        usersArray.add(adminObj);
        usersArray.add(studentObj);

        FileWriter fileWriter =new FileWriter(fileLocation);
        fileWriter.write(usersArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();



    }
}