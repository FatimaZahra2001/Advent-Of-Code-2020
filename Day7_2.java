import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day7_2 {

  int        maxSize    = 594;
  int        secondSize = 9;
  String[][] sacks      = new String[maxSize][secondSize];

  public Day7_2() {
    readFile();
  }

  public void readFile() {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader("input7"));
      String line = reader.readLine();
      int index = 0;
      while(line != null){
        getInputSacks(line, index);
        line = reader.readLine();
        index++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void getInputSacks(String line, int index){
    String[] lineSplit = line.split(" ");
    sacks[index][0] = lineSplit[0] + " " + lineSplit[1] + " ";

    if(!lineSplit[4].equals("no")){
      String newLine = line.substring(line.indexOf(lineSplit[4]));
      String[] colours = newLine.split(", ");
      String[][] coloursSplit = new String[colours.length][3];

      int add = 1;
      for(int i = 0; i < colours.length; i++){
        String[] tempSplit = colours[i].split(" ");
        coloursSplit[i][0] = tempSplit[0];
        coloursSplit[i][1] = tempSplit[1];
        coloursSplit[i][2] = tempSplit[2];
        sacks[index][add] = coloursSplit[i][0];
        sacks[index][add + 1] = coloursSplit[i][1] + " " + coloursSplit[i][2];
        add += 2;
      }
    }
    else{
      sacks[index][1] = "0";
    }
  }
  public void printSacks(){
    for(int row = 0; row < maxSize; row++){
      for(int col = 0; col < secondSize; col++){
        System.out.println(sacks[row][col]);
      }
    }
  }
  //Day 7 - Challenge 1:
  public int getAllShiny(){
    int count = 0;

    for(int index = 0; index < sacks.length; index++){
      if(hasShinyGoldBag(index)){
        count++;
      }
    }
    return count;
  }
  public boolean hasShinyGoldBag(int index){
    if(index == -1){
      return false;
    }
    int currentIndex = 0;
    while(currentIndex < sacks[index].length && sacks[index][currentIndex] != null){
      if(sacks[index][currentIndex].equals("shiny gold")){
        return true;
      }
      currentIndex++;
    }
    boolean output;
    for(int i = 1; i < sacks[index].length && sacks[index] != null; i++){
      if(i % 2 == 0){
        output = hasShinyGoldBag(findIndexOfBag(sacks[index][i]));

        if (output){
          return true;
        }
      }
    }

    return false;
  }

  public int findIndexOfBag(String bag){
    for (int k = 0; k < sacks.length; k++){
      if (sacks[k][0].substring(0, sacks[k][0].length()-1).equals(bag)){
        return k;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Day7_2 day7_2 = new Day7_2();
    System.out.println(day7_2.getAllShiny());
  }
}