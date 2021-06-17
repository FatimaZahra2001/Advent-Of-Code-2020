import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Day9 {
  ArrayList<String> lines  = new ArrayList<>();
  String                  input9   = "input9";
  ArrayList<List<String>> preamble = new ArrayList<>();
  static ArrayList<Long> list = new ArrayList<>();
  ArrayList<Long>    prefixSum    = new ArrayList<>();

  public void readFile(){
    try{
      File    file  = new File(input9);
      Scanner input = new Scanner(file);
      BufferedReader br = new BufferedReader(new FileReader(input9));
      String line = br.readLine();
      long sum = 0;
      while(input.hasNext()) {
        long l = Long.parseLong(line);
        prefixSum.add(sum);
        list.add(l);
        sum += l;
        line = input.nextLine();
      }
      System.out.println(lines);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public long ContiguousSet() {
    for(int i = 0; i < prefixSum.size(); i++){
      for(int j = 1; j < prefixSum.size(); j++){
        long start = prefixSum.get(i);
        long finish = prefixSum.get(j);
        if(finish - start == 25){
         long min = Long.MAX_VALUE;
         long max = Long.MIN_VALUE;
          for(int k = i; k < j; k++){
            if(list.get(k) < min){
              min = list.get(k);
            }
            else if(list.get(k) > max){
              max = list.get(k);
            }
          }
          return min + max;
        }
      }
    }
    return -1;
  }
  public long partOne(List<Long> list){
    for(int i = 25; i < list.size(); i++){
      if(!checkValidity(list, i)){
        return list.get(i);
      }
    }
    return -1;
  }
  public boolean checkValidity(List<Long> list, int index){
    //uses hashing for an O(N)
    Set<Long> values = new HashSet<>();
    for(int i = index - 25; i < index; i++){
      if(values.contains(list.get(index) - list.get(i))){
        return true;
      }
      values.add(list.get(i));
    }
    return false;
  }

  public static void main(String[] args) {
    Day9 day9 = new Day9();
    day9.readFile();
    day9.ContiguousSet();
    day9.partOne(list);
  }
}
