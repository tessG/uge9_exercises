g# uge9_exercises
Exercises for week 9

Opgaverne tager udgangspunkt i StringWorks projektet som vi startede op i tirsdagens lektion. Her loadede vi noget tekst og lagde det ind i en datafil.
Herefter byggede vi nogle metoder der foretog forskellige analyser på teksten. Så start med at finde projektet frem. Hvis du ikke har projektet kan det findes som link under flow 1 på moodle.
I to første opgaver skal du fortsætte med at analysere samme tekst. I de to sidste skal du tilføje metoder som bare arbejder med en enkelt streng som du sender med som argument.

Som altid, fortvivl ikke hvis en opgave er for svær. Selvom  jeg har prøvet at sørge for at nogle af opgaverne er nemme, skal der ikke så meget til før det bliver kompliceret.
vær aldrig for stolt til at bede om hjælp - heri lægger det meste af din læring - og tutorerne er til for det samme ;)

Det er ikke nødvendigvis den letteste opgave først og den sværeste sidst i dette sæt.


## Task 1 - Print alle ord der har dobbeltkonsonant i sig.  
        Til denne opgave skal du fortsætte i StringWorks projektet, hvor vi har loadet noget tekst fra wikipedia ind og lagt linierne i et dobbelt array (text[][])
        Du skal derfor følge samme fremgangsmåde med forloops, som vi anvendte da vi løste de første par opgaver i projektet. 
        Denne opgave kan givetvis løses med regular expression, men det er ikke formålet, så prøv at løse den 'manuelt.
        
    1.a Lav en ny metode printWordsWithDoubleConsonant() 
    1.b Metoden skal gennemløb hver linie og hvert ord i hver linie
    1.c Tjek om den enkelte karakter i hvert ord er identisk med forrige karakter. Hint: Det kan være en god ide FØRST at tjekke bogstavet er en konsonant.
        Det anbefales her at du skriver en separat metode, der alene tager sig af dét. Denne metode skal både sikre at karakteren hverken er en vokal eller et tal (hint: Character.isDigit(c))
    1.d Kald metoden fra main.


## Task 2. - Print den længste sætning i teksten. 
         I denne opgave vil du få brug for at læse filen ind igen, så du kan splitte på .(punktum) istedet for " " (mellemrum)

    1.a Kopier linie 12 til 19 ind i metoden (eller de linier der henter filen ind, scanner og splitter den i et while loop). 
    1.b På linien hvor der laves et split array, skal du ændre så du istedet bruger denne kommando til at splitte:   String[] splitarray = scan.nextLine().split("\\. ");
    1.c Hold styr på mens du løber gennem teksten om sætningen er længere end den sætning der pt. er længst.
    1.d Kald metoden fra main
    
    
## Task 3. - print en delmængde (substring) af et ord 
        I denne opgave skal du brug substring metoden, og du skal fange StringIndexOutOfBounds exeption som Java vil smide i tilfælde hvor metoden bliver kaldt med for høje tal.

     1.a Lav en metode, printPartOfWord(), med tre parametre: 1. parameter er ordet, 2. parameter er index for det bogstav delmængden starter med og 3.  parameter er længden på delmængden
     Ex: argumenterne "Købehavn", 1 og 4  skal give outputtet "øben". 
     1.b Sørg for at metoden kan håndtere at blive kaldt med tal-argumenter som er for høje. Brug en try catch hvor du håndterer undtagelsen StringIndexOutOfBounds.
     1.c: I catch blokken skal du tjekke om argument 2 er lavere end ordets længe. Hvis det er tilfældet, skal delmængden starte ved argument 2 og til og med sidste bogstav. Hvis argument 2 er højere end ordets længde skal du give en passende fejlmeddelelse
     Ex:  Købehavn, 6, 4  skal . give outputtet 'avn'
     
     
 ## Task 4.  - print ordet hvis det er et palindrom (kan skrive bagfra og forfra uden at ændre sig)
     1.a Skriv en metode printIfPalindrome() som tager en tekststreng som argument og printer den HVIS den kan skrives bagfra uden at ændre sig. (Hint: Lad dig inspirere i dokumentationen for String klassen)
     1.b Sørg for at metoden ikke er case-sensitiv.
     1.c Kald metoden fra main med argumentet "Den laks skal ned", for at teste den.
        
       
