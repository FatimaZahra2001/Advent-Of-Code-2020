import java.io.*;
public class Day2_1 {
  int count = 0;
  int        maxSize = 1000;
  String[][] data    = new String[maxSize][4];
  public static void main(String[] args) throws IOException {
    try (BufferedReader in = new BufferedReader(new FileReader
          (("/home/fatimazahra/AdventOfCode/input2")))) {
      String line;
      int index = 0;
      while ((line = in.readLine()) != null) {
        Day2_1 myData = new Day2_1();
        //myData.performAction(line.split(" "), index);
        index++;
        System.out.println(line);
      }
    }
  }

  public void performAction(String[] lineInfo, int index) {
    data[index][0] = lineInfo[0].split("-")[0]; //add start
    data[index][1] = lineInfo[0].split("-")[1]; //add end
    data[index][2] = lineInfo[1].substring(0, 1); //character
    data[index][3] = lineInfo[2]; //password


  }
}

