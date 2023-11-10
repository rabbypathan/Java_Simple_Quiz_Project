import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {

        try{
            String fileLocation ="./src/main/resources/users.json";

            JSONParser parser = new JSONParser();
            JSONArray usersArray = (JSONArray) parser.parse(new FileReader(fileLocation));

            Scanner scanner =new Scanner(System.in);
            System.out.println("Enter your username:");
            String username = scanner.next();
            System.out.println("Enter password:");
            String password = scanner.next();

            for(int i=0; i<usersArray.size();i++){
                JSONObject userObj = (JSONObject) usersArray.get(i);
                String _username = userObj.get("username").toString();
                String _password = userObj.get("password").toString();
                String role = userObj.get("role").toString();

                if(username.equals(_username) && password.equals(_password)){
                    if(role.equals("admin")){
                        System.out.println("Welcome admin! Please create new questions in the question bank.");
                        Questions.createQuestion();
                        break;
                    }
                    else if(role.equals("student")){
                        System.out.println("Welcome " + _username + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking.Are you ready?Press 's' for start");
                        char ch = scanner.next().charAt(0);
                        if(ch=='s'){
                            Quiz.quiz();
                        }
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input...");
        }
    }
}