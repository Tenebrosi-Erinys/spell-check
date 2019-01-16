import java.util.*;
import java.io.*;
public class SpellChecker{
   //instance property
   public String[] dictionary;
   
   public void doSpellCheck(String filename) throws FileNotFoundException {
   
   }
   
   public static void main(String[] args){
      SpellChecker checker = new SpellChecker();
      try{
         checker.loadDictionary("wordlist.txt");
         checker.doSpellCheck("englishEssay.txt");
      } catch(FileNotFoundException e){
         System.out.println(e.getMessage());
      }
   }
   
   public void loadDictionary(String filename) throws FileNotFoundException {
      File dFile = new File(filename);
      dictionary = new String[countWords(filename)];
      Scanner fileParser = new Scanner(dFile);
      System.out.println("Words in dictionary: " + dictionary.length);
      for(int index = 0; index < dictionary.length; index++){
         dictionary[index] = fileParser.next();
      }
   }
   
   public int countWords(String filename) throws FileNotFoundException {
      File dFile = new File(filename);
      Scanner parser = new Scanner(dFile);
      int count = 0;
      while(parser.hasNext()){
         count++;
         parser.next();
      }
      return count;
   }
   
   public boolean isInDictionary(String word){
      for(int index = 0; index < dictionary.length; index++){
         if(word.equalsIgnoreCase(dictionary[index])){
            return true;
         }
      }
      return false;
   }
}