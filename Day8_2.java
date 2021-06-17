import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8_2 {

  int acc = 0;
  List<Integer> ranInstructions = new ArrayList<>();
  ArrayList<String> lines = new ArrayList<>();
  String input8 = "input8";
  public void readFile(){
    try{
      File    file  = new File(input8);
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
  public List<String> getLines(){
    List<String> lines = new ArrayList<>();
    try(BufferedReader br = new BufferedReader(new FileReader(input8))){
      String line;
      while((line = br.readLine()) != null){
        lines.add(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
  public void run() {
    for(int i = 0; i < lines.size(); i++){
      if(ranInstructions.contains(i)){
        break;
      }
      ranInstructions.add(i);
      String s = lines.get(i);
      String instruction = s.substring(0,3);
      int number = Integer.parseInt(s.substring(4));
      switch(instruction){
        case "nop":
          break;
        case "acc":
          acc += number;
          break;
        case "jmp":
          i += (number - 1);
          break;
      }
    }
    System.out.println(acc);
  }
  //part 2:

  private boolean infiniteCheck() {
    String[] tracker  = new String[lines.size()];
    int      position = 0;
    String[] split;
    while (position != tracker.length) {
      if (tracker[position] == null) {
        tracker[position] = lines.get(position);
        split             = lines.get(position).split(" ");
        switch (split[0]) {
          case "nop":
            position++;
            break;
          case "acc":
            acc += Integer.parseInt(split[1]);
            position++;
            break;
          case "jmp":
            position += Integer.parseInt(split[1]);
            break;
        }
      } else {
        return false;
      }
    }
    System.out.println("acc: " + acc);
    return true;
  }
  public void findFault(){
    for(int i = 0; i < lines.size(); i++){
      acc = 0;
      String[] split = lines.get(i).split(" ");
      if(split[0].equals("nop")){
        lines.set(i, "jmp " + Integer.parseInt(split[1]));
        if(infiniteCheck()){
          break;
        }
        lines.set(i, "nop " + Integer.parseInt(split[1]));
      }
      else if(split[0].equals("jmp")){
        lines.set(i, "nop " + Integer.parseInt(split[1]));
        if(infiniteCheck()){
          break;
        }
        lines.set(i, "jmp " + Integer.parseInt(split[1]));
      }
    }
  }

  public static void main(String[] args) {
    Day8_2 day8_2 = new Day8_2();
    day8_2.readFile();
    day8_2.getLines();
    day8_2.run();
    //part 2:
    day8_2.findFault();

  }
}
