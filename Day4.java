//Made by @Fatima Zahra Al Hajji.
//07/01/2021
/*import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4 {
  String input4      = "input4";
  Path   myPassports = Paths.get("my-passports.txt");
  StringBuilder sb = new StringBuilder();
  ArrayList<String> passports = new ArrayList<>();
  String thePassports;
  String         passportsFile = "my-passports.txt";
  List<String[]> tokens        = new ArrayList<>();
  String[]       arrayOfTokens;
  ArrayList<String> applicable            = new ArrayList<>();
  String[][]        dataArray;
  ArrayList<String> validPass = new ArrayList<>();
  int count = 0;
  public void readFile() throws FileNotFoundException {
    File    file  = new File(input4);
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      String line = input.nextLine();
      if (!line.isEmpty()) {
        sb.append(line).append(' ');
      } else {
        //System.out.println(sb.substring(0, sb.length() - 1));
        passports.add(sb.substring(0, sb.length() - 1));
        sb.setLength(0);
      }
    }
  }
  public void format(){
    thePassports = passports.toString().replace(", ","\n");
  }
  public void createTXTFile() {
    try {
      FileWriter writer = new FileWriter(String.valueOf(myPassports));
      writer.write(thePassports);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void readFile01(){
    try{
      File file = new File(passportsFile);
      Scanner input = new Scanner(file);
      while(input.hasNext()) {
        String line = input.nextLine();
        applicable.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void validPass(){
    for(String attributes : applicable){
      if (attributes.contains("byr") &&
          attributes.contains("iyr") &&
          attributes.contains("eyr") &&
          attributes.contains("hgt") &&
          attributes.contains("hcl") &&
          attributes.contains("ecl") &&
          attributes.contains("pid")){
        validPass.add(attributes);
        count++;
      }
    }
    System.out.println(count);
    System.out.println(validPass.toString());
  }
  public void validPass02(){
    for(int i = 0; i < validPass.size(); i++) {
      arrayOfTokens = validPass.get(i).split(" ");
      tokens.add(arrayOfTokens);
    }
  dataArray = tokens.toArray(new String[tokens.size()][]);
    System.out.println(Arrays.deepToString(dataArray));
    for(String[] details : dataArray){
      if((Arrays.toString(details).contains("iyr") && (details.toString().contains(
          "2010") || details.toString().contains("2011") || details.
           toString().contains("2012") || details.toString().contains("2013") ||
                                                       details.toString().contains("2014") || details.toString().contains("2015") ||
                                                       details.toString().contains("2016") || details.toString().contains("2017") ||
                                                       details.toString().contains("2018") || details.toString().contains(
              "2019") || details.toString().contains("2020"))) &&
         (Arrays.toString(details).contains("byr") && ());


    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Day4 day4 = new Day4();
    day4.readFile();
    day4.format();
    day4.createTXTFile();
    day4.readFile01();
    day4.validPass();
    day4.validPass02();
  }

}*/
