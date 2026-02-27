package src.com.java.code;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringProgramCheck {

    public  static  boolean getStringMatch(String input,String output){
        IntStream streamString= input.toLowerCase().chars();
        Pattern p=Pattern.compile("[a-zA-Z]");
        String str= streamString.filter(Character::isLetter).
        mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        return  output.equals(str);
    }
    public  static  boolean getStringMatchWithSimpleCode(String input,String output){
    String outputString=   input.toLowerCase().replaceAll("[^a-z]", "");
        System.out.println(outputString);
        return  output.equals(outputString);
    }
    public static void main(String[] args) throws  Exception{
        //Input: s = "A man, a plan, a canal: Panama"
        //Processed String: amanaplanacanalpanama
        String   input = "A man, a plan, a canal: Panama";
        String output= "amanaplanacanalpanama";
        System.out.println(getStringMatch(input,output));
        System.out.println(getStringMatchWithSimpleCode(input,output));
    }
}
