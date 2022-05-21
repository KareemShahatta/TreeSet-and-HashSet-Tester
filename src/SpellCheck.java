import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
   This program checks which words in a file are not present in a dictionary.
*/
public class SpellCheck
{
   Set<String> dictionaryWords;
   Set<String> documentWords;
   Set<String> carWords;
   Set<String> war_peace;

   public static void main(String[] args) throws FileNotFoundException
   {
      SpellCheck object = new SpellCheck();

      // Read the dictionary and the document
      object.dictionaryWords = readWordsHashSet("resources/words");
      object.documentWords = readWordsHashSet("resources/alice30.txt");
      object.carWords = readWordsHashSet("resources/Test.txt");
      object.war_peace = readWordsHashSet("resources/war-and-peace.txt");

      System.out.println("======================================================================");
      System.out.println("LAB PART A");
      object.labPart1(); //Part A of the lab
      System.out.println("======================================================================");
      System.out.println("LAB PART B");
      object.labPart2(); //Part B of the lab
      System.out.println("======================================================================");

      /*TreeSet<String> word1 = readWordsTreeSet("resources/war-and-peace.txt");
      Set<String>  word2 = readWordsHashSet("resources/war-and-peace.txt");

      System.out.println(word1.toString());
      System.out.println(word2.toString());*/
   }

   /**
      Reads all words from a file.
      @param filename the name of the file
      @return a set with all lowercased words in the file. Here, a 
      word is a sequence of upper- and lowercase letters.
   */
   public static ArrayList<String> readWordsArrayList(String filename) throws FileNotFoundException {
      ArrayList<String> words = new ArrayList<>();
      Scanner in = new Scanner(new File(filename));
      // Use any characters other than a-z or A-Z as delimiters
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext())
      {
         words.add(in.next().toLowerCase());
      }
      return words;
   }
   public static Set<String> readWordsHashSet(String filename) throws FileNotFoundException {
      Set<String> words = new HashSet<>();
      Scanner in = new Scanner(new File(filename));
      // Use any characters other than a-z or A-Z as delimiters
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext())
      {
         words.add(in.next().toLowerCase());        
      }
      return words;
   }
   public static TreeSet<String> readWordsTreeSet(String filename) throws FileNotFoundException {
      TreeSet<String> words = new TreeSet<>();
      Scanner in = new Scanner(new File(filename));
      // Use any characters other than a-z or A-Z as delimiters
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext())
      {
         words.add(in.next().toLowerCase());
      }
      return words;
   }


   void spellCheck(Set<String> set) {
      for (String word : set)
      {
         if (!dictionaryWords.contains(word))
         {
            System.out.println(word);
         }
      }
   }


   void testCaseArrayList() throws FileNotFoundException {
      System.out.println("Starting Read ArrayList Test");
      long arrayListTime;
      StopWatch timer = new StopWatch();
      timer.start();
      ArrayList<String>  words = readWordsArrayList("resources/war-and-peace.txt");
      timer.stop();
      arrayListTime = timer.getElapsedTime();
      timer.reset();
      System.out.println("Elapsed time for arraylist "
              + arrayListTime + " milliseconds.  Number of words: " + words.size());
   }
   void testCaseHashSet() throws FileNotFoundException {
      System.out.println("Starting Read HashSet Test");
      long hashSetTime;
      StopWatch timer = new StopWatch();
      timer.start();
      Set<String>  words = readWordsHashSet("resources/war-and-peace.txt");
      timer.stop();
      hashSetTime = timer.getElapsedTime();
      timer.reset();
      System.out.println("Elapsed time for hashset "
              + hashSetTime + " milliseconds.  Number of words: " + words.size());
   }
   void testCaseTreeSet() throws FileNotFoundException {
      System.out.println("Starting Read TreeSet Test");
      long treeSetTime;
      StopWatch timer = new StopWatch();
      timer.start();
      TreeSet<String>  words = readWordsTreeSet("resources/war-and-peace.txt");
      timer.stop();
      treeSetTime = timer.getElapsedTime();
      timer.reset();
      System.out.println("Elapsed time for treeset "
              + treeSetTime + " milliseconds.  Number of words: " + words.size());
   }

   void labPart1() {
      System.out.println("====Given File====");
      spellCheck(documentWords);
      System.out.println("====My File====");
      spellCheck(carWords);
   }
   void labPart2() throws FileNotFoundException {
      testCaseArrayList();
      testCaseHashSet();
      testCaseTreeSet();
   }
}

