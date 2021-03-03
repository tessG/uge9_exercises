import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[][] text = new String[12][1];

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("data.txt");
        scan = new Scanner(file);
        int i = 0;
        while (scan.hasNextLine()) {
            text[i] = scan.nextLine().split(" ");
           
            i++;
        }

        // todo: print alle ord der starter med det der sendes med som argument,
        printWordsStartingWith("Ø");
        //todo: print alle ord der har præcis det antal bogstaver der sendes med som argument (inkluderer IKKE tal og tegnene '.' og ',')
        printWordsOfLength(3);
        //todo: print alle ord der har dobbeltkonsonant i sig. (Denne opgave kan løses med regular expression, men det er ikke formålet, så prøv at løse den 'manuelt')
        // Hint: Det kan være en god ide at starte med at tjekke hvert bogstav i et ord, om det er en konsonant.
        // Det anbefales her at du skriver en separat metode, der alene tager sig af dét. Denne metode skal både sikre at karakteren hverken er en vokal eller et tal (hint: Character.isDigit(c))
        
        printWordsWithDoubleConsonants();
        //todo: print den længste sætning i teksten. Her vil du  få brug for at læse filen ind igen, så du kan splitte på .(punktum) istedet for " " (mellemrum)
        // Kopier derfor linie 12 til 19 ind i metoden, men brug denne kommando til at splitte:   String[] splitarray = scan.nextLine().split("\\. ");
        //
        try {
            printLongestSentence();
        }catch(IOException e){
        }

        //todo: print en delmængde (hint: substring) af et ord, hvor 1. argument er ordet, 2. argument er index for det bogstav delmængden starter med og 3. argument er længden på delmængden
        // Ex: Købehavn, 1, 4  skal . give outputtet 'øben'
        //      Metoden skal kunne håndtere at blive kaldt med tal argumenter som er for høje.
        //      Brug derfor en try catch hvor du håndterer undtagelsen StringIndexOutOfBounds.
        //      I catch blokken skal du tjekke om argument 2 er lavere end ordets længe. Hvis det er tilfældet,
        //      skal delmængden starte ved argument 2 og til og med sidste bogstav.
        //      Hvis argument 2 er højere end ordets længde skal du give en passende fejlmeddelelse

        //
        // Ex:  Købehavn, 6, 4  skal . give outputtet 'avn'
        printPartOfWord("København",6, 4);


        //todo: Skriv en metode som tager en tekststreng som argument og printer den den kan skrives bagfra. Metoden er ikke case-sensitiv.
        printIfPalindrome("Den laks skal ned");

    }

    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                if (s.length() == l) {
                    if (s.contains(",") || s.contains(".")) {
                        wordisvalid = false;
                    }
                     /*for (int j = 0; j < s.length(); j++) {
                         char c = s.charAt(j);
                         if(c == '.' || c == ','){
                             wordisvalid = false;
                         }
                     }*/
                    if (wordisvalid) {
                        System.out.println(s);
                    }

                }
            }
        }

    }

    private static void printWordsStartingWith(String pattern) {

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                    System.out.println(s);
                }
            }

        }

    }

    private static void printWordsWithDoubleConsonants() {

        for (int i = 0; i < text.length; i++) {
            for (String s : text[i]) {
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    //Tjek kun om der er dobbeltkonsonant hvis det ikke er det første ord, eller hvis bogstavet er en konsonant
                    if (j > 0 && isConsonant(c)) {
                        char previous = s.charAt(j - 1);
                        if (c == previous) {

                            System.out.println(s);
                        }
                    }
                }

            }
        }
    }
    private static boolean isConsonant(char ch){

        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return false;
        }else if(Character.isDigit(ch)){
            return false;
        }

        return true;
    }
    private static void printPartOfWord(String word, int start, int l) {
        try{

            System.out.println(word.substring(start,start+l));

        }catch(StringIndexOutOfBoundsException e){
            if(start<word.length()) {
                System.out.println(word.substring(start));
            }else{
                System.out.println("start index er længere end ordet: "+e.getMessage());
            }
        }
    }
    private static void replaceLetterOfWord(String word, char c, char newchar) {

        System.out.println(word.toLowerCase().replace(c, newchar));
    }
    public static void printLongestSentence() throws IOException {
        String longest="";
        File file = new File("src/data.txt");
        scan = new Scanner(file);
        int i=0;
        while(scan.hasNextLine()){
            String[] splitarray = scan.nextLine().split("\\. ");
            longest = splitarray[0];
            for (String sentence:splitarray) {
                System.out.println("sætning i linie "+i+": "+sentence);
                if(sentence.length()>longest.length()){
                    longest=sentence;
                }
            }
            i++;
        }
        System.out.println("længste sætning: "+longest);
    }


    public static void printIfPalindrome(String s){
        boolean res = true;
        String rev= "";
        s= s.toLowerCase();
        for(int j=s.length();j>0;--j)
        {
            rev=rev+(s.charAt(j-1));
        }

        if(rev.equals(s)){

            System.out.println(s + " is a palindrome");
        }


    }
}
