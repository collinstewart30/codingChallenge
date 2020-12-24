import java.util.*;

public class codingChallenge {
    public static void main(String[] args) {

        //INPUT SECTION
//        System.out.println("How many currencies are you listing? (Ex: Quarter, Dime, Penny would be 3):");
//        Scanner scans = new Scanner(System.in);
//        int numberOfCurrency = scans.nextInt();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the currencies seperated by commas (Ex: Quarter,25,Dime,10,Penny,1):");
        String input = scanner.nextLine();
        System.out.println("Enter the total amount (Ex: if you are looking for $1 enter 100):");
        int totalAmt = scanner.nextInt();
        // Initialize Scanner object
        Scanner scan = new Scanner(input);
        //Initialize the string delimiter
        scan.useDelimiter(",");
        //Printing the tokenized Strings

        String denoms = input;
        String[] splitStrings = denoms.split(",");

        String[] stringArray = new String[splitStrings.length/2];
        int start = 0;
        while ( start<stringArray.length){
            stringArray[start] = splitStrings[start*2];
            start++;
        }

        String[] numArray = new String[splitStrings.length/2];
        int start2 = 0;
        while ( start2<numArray.length){
            numArray[start2] = splitStrings[(start2*2)+1];
            start2++;
        }

        //Add only numbers to the coinsArray (strings are already in stringArray)
        int [] coinsArray = new int[splitStrings.length/2];
        for (int x = 0; x<splitStrings.length/2;x++){
            coinsArray[x] = Integer.parseInt(numArray[x]);
        }

        //prints out the currency name inputs
        System.out.println("The currencies you listed are: ");
        for (int x = 0; x<splitStrings.length/2;x++){
            if (x == (splitStrings.length/2) - 1) {
                System.out.print(stringArray[x] + "");
            }
            else {
                System.out.print(stringArray[x] + ", ");
            }
        }
        System.out.println();
        //output corresponding nums for currencies
        System.out.println("The corresponding amounts for the currency above you listed are: ");
        for (int x = 0; x<splitStrings.length/2;x++){
            if (x == (splitStrings.length/2) - 1) {
                System.out.print(numArray[x] + "");
            }
            else {
                System.out.print(numArray[x] + ", ");
            }
        }
        System.out.println();

        scan.close();

        //COIN SECTION
        System.out.println("Total Combinations: " + change(totalAmt, coinsArray));
    }

    public static int change(int amount, int[] coins){
        int[] combinations = new int[amount + 1];

        combinations[0] = 1;

        for(int coin : coins){
            for(int i = 1; i < combinations.length; i++){
                if(i >= coin){
                    combinations[i] += combinations[i - coin];
                    //System.out.println("COMBO: " + combinations[i]);
                }
            }
            //System.out.println();
        }

        return combinations[amount];
    }
}
