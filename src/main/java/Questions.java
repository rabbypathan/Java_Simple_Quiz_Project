import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Questions {

    public static void createQuestion() throws IOException, ParseException {
        char ch='s';
        String fileName ="./src/main/resources/quiz.json";

        do {
            JSONParser jsonParser = new JSONParser();
            JSONArray questionsArray = (JSONArray) jsonParser.parse(new FileReader(fileName));

            JSONObject questionObj =new JSONObject();
            Scanner input = new Scanner(System.in);
            System.out.println("Input your question");
            questionObj.put("question", input.nextLine());
            System.out.println("Input option 1: ");
            questionObj.put("option 1", input.nextLine());
            System.out.println("Input option 2: ");
            questionObj.put("option 2", input.nextLine());
            System.out.println("Input option 3: ");
            questionObj.put("option 3", input.nextLine());
            System.out.println("Input option 4: ");
            questionObj.put("option 4", input.nextLine());
            System.out.println("What is the answer key?");
            questionObj.put("answerkey", input.nextInt());


            questionsArray.add(questionObj);
            FileWriter file = new FileWriter(fileName);
            file.write(questionsArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            ch=input.next().charAt(0);

        }
        while(ch!='q');
    }
}