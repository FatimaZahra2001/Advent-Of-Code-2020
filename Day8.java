import java.io.File;
import java.util.*;

public class Day8 {
  String input8 = "input8";
  ArrayList<String> lines = new ArrayList<>();
  String[]       tokens        = new String[646];
  List<String[]> arrayOfTokens = new ArrayList<>();
  String[][] dataArray;
  int    count = 0;
  int acc = 0;
  int result = 0;
  HashSet<String> keys = new HashSet<>();

  public void readFile(){
    try{
      File    file  = new File(input8);
      Scanner input = new Scanner(file);
      while(input.hasNext()) {
        String line = input.nextLine();
        lines.add(line);
        keys.add(line);
        tokens = line.toString().split(" ");
        arrayOfTokens.add(tokens);
      }
      System.out.println(lines);
      System.out.println(keys);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void findRepeat(){
    dataArray =
        arrayOfTokens.toArray(new String[arrayOfTokens.size()][]);
    System.out.println(Arrays.deepToString(dataArray));
    for(int i = 0; i < dataArray.length; i++){
      for(int j = 1; j < dataArray.length; j++) {
        while (!(dataArray[i][0].equals(dataArray[j][0]) &&
            dataArray[i][1].equals(dataArray[j][1]))){
          if(dataArray[i][0].equals("acc")){
            acc += Integer.parseInt(dataArray[i][1]);
          }
          break;
        }
      }
    }
    System.out.println(count);

    for(int k = 0; k < keys.size(); k++){
      if(keys.contains("acc")){
        String value =  keys.toString().substring(3);
        result += Integer.parseInt(value);
      }
    }
    System.out.println(result);
  }

  public static void main(String[] args) {
    Day8 day8 = new Day8();
    day8.readFile();
    day8.findRepeat();
  }
}
