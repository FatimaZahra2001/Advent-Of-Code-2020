import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
  String input3 = "input5";
  static List<String> lines = new ArrayList<>();
  ArrayList<Integer> applicable            = new ArrayList<>();

  public void readFile(){
    try{
      File    file  = new File(input3);
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
  public void letterMeans(){
    for(String letter : lines){
      int rowLow = 0;
      int rowHigh = 127;
      int columnLow = 0;
      int columnHigh = 7;
      for(char c : letter.toCharArray()){
        if( c == 'F'){
          rowHigh -= (rowHigh - rowLow + 1) / 2;
        }
        else if( c == 'B'){
          rowLow += (rowHigh - rowLow + 1) / 2;
        }
        else if( c == 'L'){
          columnHigh -= (columnHigh - columnLow + 1) / 2;
        }
        else if( c == 'R'){
          columnLow += (columnHigh - columnLow + 1) / 2;
        }
      }
      applicable.add(rowHigh * 8 + columnHigh);
    }
    System.out.println(applicable.toString());
  }
  public void biggestOne(){
    int max;
    max = applicable.get(0);
    for(int i = 0; i < applicable.size() - 1; i++){
      if(applicable.get(i) > max){
        max = applicable.get(i);
      }
    }
    System.out.println(max);
  }
  public void findSeat() {
    for (int i = 0; i < 1024; i++) { // 128 x 8 = 1024 seats.
     if(!applicable.contains(i) && applicable.contains(i + 1) &&
        applicable.contains(i - 1)){
       System.out.println("Seat is " + i);
     }
    }
  }

  public static void main(String[] args) {
    Day5 day5 = new Day5();
    day5.readFile();
    day5.letterMeans();
    day5.biggestOne();
    day5.findSeat();
  }

}
