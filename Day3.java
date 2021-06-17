import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

  String input3 = "input3";
  static List<String> lines = new ArrayList<>();

  public void readFile(){
    try{
      File file = new File(input3);
      Scanner input = new Scanner(file);
      while(input.hasNext()) {
        String line = input.nextLine();
        lines.add(line);
      }
      System.out.println(lines);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void countTrees(List<String> lines, int right, int down){
    int x = 0;
    int counter = 0;
    for(int y = down; y < lines.size(); y = y + down){
      String line = lines.get(y);
      x = x + right;
      if(x >= line.length()){
        x = x - line.length();
      }
      if(lines.get(y).charAt(x) == '#'){
        counter++;
      }
    }
    System.out.println(counter);
  }
    public static void main(String[] args) {
    Day3 day3 = new Day3();
    day3.readFile();
    day3.countTrees(lines, 3, 1);
  }
}
