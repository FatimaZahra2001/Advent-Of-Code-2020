import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Day2 {
  public static void main(String[] args) {
    File file = new File("/home/fatimazahra/Documents/AdventOfCode/" +
                         "input2");
    try(Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())){
      FileInputStream fis = new FileInputStream(file);
      byte[] byteArray = new byte[(int)file.length()];
      fis.read(byteArray);
      String data = new String(byteArray);
      String[] stringArray = data.split("\r\n");

      int rows = stringArray.length;
      int columns =4;
      String[][] eachLine = new String[rows][columns];
      //splitting each line into 4 tokens:

      while(sc.hasNextLine()) {
        for (int i = 0; i < eachLine.length; i++) {
          String[] passwords = eachLine.toString().split(" ");
          for (int j = 0; j < passwords.length; j++) {
            passwords.toString().split("-");
          }
        }
      }
      for(int i = 0; i < rows; i++){

        String MIN = eachLine[i][0];
        String MAX       = eachLine[i][1];
        String character = eachLine[i][2].substring(0,1);
        String password  = eachLine[i][3];
        int count = 0;
        int validPasswords = 0;

        for(int y = 0; y < columns; y++)
        for( i = 4; i < password.length(); i++){
          if(password.charAt(i) == character.toCharArray()[0]){
            count = count + 1;
          }
        }
        for(int j = 0; j < password.length(); j++ ){
          if(count >= Integer.parseInt(MIN) && count <= Integer.parseInt(MAX)){
            validPasswords = validPasswords + 1;
          }
          System.out.println(validPasswords);
        }
      }
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}
