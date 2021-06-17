import java.io.*;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Arrays.compareUnsigned;

public class Day6 {
  static List<String> lines = new ArrayList<>();
  String input6 = "input6";
  public void readFile(){
    try{
      File    file  = new File(input6);
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
  public void letterCount(){
    int    count = 0;

    Map<Character, Integer> map = new HashMap<>();
      for(String letter : lines){
        for(char c : letter.toCharArray()){
          if(!map.containsKey(c)){
            int counter;
            counter = map.get(c);
            map.put(c, ++counter);
          }
          else{
            map.put(c,1);
          }
        }
      }
    for(char c : map.keySet()){
      if(map.get(c) == 1){
        count += 1;
      }
    }
    System.out.println(count);
  }
  public void reading() throws IOException {
    File file = new File("input6");
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String st;
    while ((st = bufferedReader.readLine()) != null)
      System.out.println(st);
  }
  public void sum1Letters(){
    long sum =  Arrays.stream(lines.toString().split(", ,"))
        .map(i -> i.replace(",",""))
        .mapToLong(i -> i.chars().distinct().count()).sum();
    System.out.println(sum);
  }

  public static void main(String[] args) throws IOException {
    Day6 day6 = new Day6();
    day6.readFile();
    day6.sum1Letters();
  }
}
