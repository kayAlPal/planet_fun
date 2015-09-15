
package planetcompare;

//import java.math.BigDecimal; 
//import java.math.BigInteger; 
//import java.math.RoundingMode;
//import java.text.DecimalFormat; 
import java.util.Scanner; 
//import static planetcompare.PlanetArray.compareVolume;
//import static planetcompare.PlanetArray.findIt;


public class PlanetCompare {



/**
 * returns a String with the names of two possible Planets to be parsed by planetSearch()
 * @return 
 */    
    public static String planetInput()
    {
        System.out.println("Type the name of two planets");
        Scanner in = new Scanner(System.in); 
        String oneLine = in.nextLine(); 
        return oneLine; 
    }
    
    /**
     * Method used when comparing the sizes of two Planets. Takes in a String from 
     * planetInput() and parses the String turning it into two Planet names. It then
     * searches the array using findIt() to get the index of the array where the planet is located
     * or -1 if not present and then gives the user the breakdown by calling compareVolume()
     * with the two planets. 
     * @param planets 
     */
    private static boolean planetSearch(String planets, PlanetArray array)
    {
        Scanner str = new Scanner(planets); 
        String firstName = str.next().toLowerCase(); 
        String secondName = str.next().toLowerCase(); 
        System.out.println("You typed " + capitalize(firstName) + " " + capitalize(secondName) + "\n");
        
        
        int firstIndex = array.findIt(firstName); 
        
        int secondIndex = array.findIt(secondName); 
        
        if (firstIndex == -1 || secondIndex == -1)
        {
            System.out.println("Unable to determine which planets you would like to compare.\n"
                    + "Mercury \n Venus \n Earth \n Mars \n Ceres \n Jupiter \n Saturn \n Uranus"
                    + "\n Neptune \n Pluto \n Eris \n Makemake \n Haumea \n Sedna");
            return false; 
        }
        //System.out.println(array[firstIndex]);
        array.getIndex(firstIndex); 
        //System.out.println(array[secondIndex]);
        array.getIndex(secondIndex); 
        array.compareAnyTwo(firstIndex, secondIndex);
//        System.out.println(array[firstIndex].getName() 
//                + " would fit inside " + array[secondIndex].getName() 
//                + " "+ compareVolume(array[secondIndex], 
//                        array[firstIndex]) + " times.");
        return true; 
    }
private static String capitalize(String line)
{
  return Character.toUpperCase(line.charAt(0)) + line.substring(1);
}
   /**
    * details the user's options for playing. If entries are not 0, 1, 2, 3, 4 the user
    * is directed to try again. 
    * @return 
    */
    private static int chooseIt()
    {
        int choice = 0;    
        System.out.println("\n\nWhat would you like to do today?");
        System.out.println("\nTo exit, enter the number 0");
        System.out.println("To compare two planets, enter the number 1"); 
        System.out.println("To find your weight on planets, enter the number 2");
        System.out.println("To list the planets by size, enter the number 3");
        System.out.println("To list the planets by gravity, enter the number 4");
        
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt())
        {
            choice = in.nextInt();
            if ((choice < 0) || (choice > 4))
            {
                System.out.println("I'm sorry. Please try again. Enter a number between 0 and 4");
                choice = chooseIt(); 
            }
        }
        else
        {
            System.out.println("I'm sorry. Please try again. Enter a number between 0 and 4");
            choice = chooseIt(); 
        }
        return choice; 
    }
    
    /**
     * calls the methods for the game that the user has chosen. Only numbers 1-4 can be passed
     * as others are eliminated by chooseIt() and 0 creates a break in main(). The first choice
     * is a do/while loop which will execute once if the user types the names correctly and numerous
     * times if the names are typed incorrectly. 
     * @param choice
     * @param array 
     */
    private static void callIt(int choice, PlanetArray array)
    {
        if (choice == 1)
        {
            boolean passFail = true; 
            do {
                    String oneLine = planetInput(); 
                    passFail = planetSearch(oneLine, array); 
                
            } while (passFail == false); 
        }
        if (choice == 2)
        {
            array.printWeight();
        }
        if (choice == 3)
        {
            array.sortBySize();
            array.printSize();
        }
        if (choice == 4)
        {
            array.sortByGravity();
            array.printGravity();
        }
    }
    
    
    public static void main(String[] args) {
       PlanetArray array = new PlanetArray(); 
        int next; 
        do {
            
            next = chooseIt(); 
            if (next == 0)
            {
                break; 
            }
            callIt(next, array); 
        } while (next != 0); 
        
        System.out.println("Goodbye"); 
    } 
}
