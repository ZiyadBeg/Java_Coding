package src.com.java.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SampleCode {
   public static Map<String,String> mapWordsToNumber=
           Map.of("one","1","two","2","three","3");
    public static String convertWordToNumber(String stringWords){
        return mapWordsToNumber.getOrDefault(stringWords,stringWords);
    }
    public static String convertStringCharToNum(String str){
        String strValue[]=str.split(" ");
        StringBuilder sd=new StringBuilder();
  Stream<String> stream= Arrays.stream(strValue);
  stream.forEach((s -> {
      sd.append(convertWordToNumber(s)+" ");
          })
  );

return sd.toString();

    }
    //There is two cat and three dogs in home.
    //output - There is 2 cat and 3 dogs in home.
    //
    public static void main(String[] args) {
        String input="There is two cat and three dogs in home.";
      String result=  convertStringCharToNum(input);
        System.out.println(result);

    }
}
