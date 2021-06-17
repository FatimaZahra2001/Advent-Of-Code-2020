import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day7 {
  String input7 = "input7";
  ArrayList<String> lines  = new ArrayList<>();
  List<String[]>    tokens = new ArrayList<>();
  String[]          arrayOfTokens;
  ArrayList<String> applicable            = new ArrayList<>();
  String[][]        dataArray;
  int count = 0;
  public void readFile(){
    try{
      File    file  = new File(input7);
      Scanner input = new Scanner(file);
      while(input.hasNext()) {
        String line = input.nextLine();
        arrayOfTokens = line.split(",");
        tokens.add(arrayOfTokens);
        lines.add(line);
      }
      System.out.println(lines);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void findAmount(){

    dataArray = tokens.toArray(new String[tokens.size()][]);
    System.out.println(Arrays.deepToString(dataArray));
    String[] find = {"shiny gold"};
    for(String[] bag : dataArray) {
      if (bag.length == 1) {
        if (bag[0].contains(find[0])) {
          count += 1;
        }
      }
      else if (bag.length == 2) {
        if (bag[0].contains(find[0]) || bag[1].contains(find[0])) {
          count += 1;
        }
      }
      else if (bag.length == 3) {
        if (bag[0].contains(find[0]) || bag[1].contains(find[0]) ||
            bag[2].contains(find[0])) {
          count += 1;
        }
      }
      else if (bag.length == 4) {
        if (bag[0].contains(find[0]) || bag[1].contains(find[0]) ||
            bag[2].contains(find[0]) || bag[3].contains(find[0])) {
          count += 1;
        }
      }
      else if (bag.length == 5) {
        if (bag[0].contains(find[0]) || bag[1].contains(find[0]) ||
            bag[2].contains(find[0]) || bag[3].contains(find[0]) ||
            bag[4].contains(find[0]) ) {
          count += 1;
        }
      }
    }
    System.out.println(count);
  }


  public static void main(String[] args) {
    Day7 day7 = new Day7();
    day7.readFile();
    day7.findAmount();
  }
}
