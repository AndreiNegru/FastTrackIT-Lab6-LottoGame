package fasttrackit.lottogame;

import java.util.*;

public class LottoV1 {

    public static final int BOUND = 40;
    public static final int INT = 5;

    public static void main(String[] args) {

        //  read users' numbers and store them
        //  prepare the lotto machine and init it
        //  generate the lotto numbers
        // compare the user numbers with the lotto numbers and tell if won something (4,5,6)

        // all in one or in different classes
        // all in one and a single method or in different methods


        // here is the simple and the most dummy idea

        // comment
        // ...

        // 1 read
        int[] myNumbers = new int[INT];
        Random myNumbersMachine = new Random();
       
        for (int i = 0; i < INT; i++) {
            int nr = myNumbersMachine.nextInt(BOUND) + 1;
            //check if nr is not already in the array, if it is generate a new one
            for (int j = 0; j < i; j++)
                if (myNumbers[j] == nr) nr = myNumbersMachine.nextInt(BOUND) + 1;
            myNumbers[i] = nr;
        }
        // here are my numbers
        System.out.println("here are my numbers:");
        for (int i = 0; i < INT; i++)
            System.out.print(myNumbers[i] + " |");

        System.out.println("");




        // 2 prepare the lotto machine and init it
        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());

        // 2 generate the numbers
        int[] sixGeneratedNumbers = new int[INT];
        for (int i = 0; i < INT; i++) {

            int nr = lottoMachine.nextInt(BOUND) + 1;

            //check if nr is not already in the array, if it is generate a new one
            for (int j = 0; j < i; j++)
                if (sixGeneratedNumbers[j] == nr)
                    nr = lottoMachine.nextInt(BOUND) + 1;

            sixGeneratedNumbers[i] = nr;

            // wait , not necessary anyway
            try {
                Thread.currentThread().sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        // 3 print the extraction
        System.out.println("here is the extraction today:");
        for (int i = 0; i < INT; i++)
            System.out.print(sixGeneratedNumbers[i] + " |");

        System.out.println("");

        //compare and tell if won
        int howManyWons = 0;
        int[] wonNumbers = new int[INT];

        for (int i = 0; i < INT; i++)
            for (int j = 0; j < INT; j++) {

                if (myNumbers[i] == sixGeneratedNumbers[j]) {
                    howManyWons++;
                    wonNumbers[howManyWons - 1] = sixGeneratedNumbers[j];
                }
            }

        switch (howManyWons) {

            case 3: // that is 4 numbers
                System.out.println("congrat, you won at 3rd category");
                break;
            case 4: // that is 5 numbers
                System.out.println("congrat, you won at 2rd category");
                break;
            case 5: // that is 6 numbers
                System.out.println("WOW, you won at 1st category");
                break;
            default:
                System.out.println("you are a looser, but keep trying, you guessed " + howManyWons +" numbers");
                break;
        }

        System.out.println("here is what you won: ");
        for (int i = 0; i < INT; i++)
            if (wonNumbers[i] != 0)
                System.out.print(wonNumbers[i] + " |");

    }
}
