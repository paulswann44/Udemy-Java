package InputsAndOutPuts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {
//    int x =98;
//    int y =0;
//        System.out.println("divideLBYL: " + divideLBYL(x, y));
//        System.out.println("divideEAFP: "+ divideEAFP(x,y));
//        System.out.println("divide: "+ divide(x,y));

        //.2
//        int x=getInteger();
//        System.out.println("x is " + x);

        //.3
//        int x = getIntLBYL();
//        System.out.println("x is " + x);

        //4.
        int x = getIntEAFP();
        System.out.println("x is " + x);


    }
    //2.
    //This will cause an input error if not an int
    private static int getInteger(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    //3.
    private static int getIntLBYL(){
        Scanner s= new Scanner(System.in);
        boolean isValid = true;
        System.out.println("please enter an integer.");
        String input = s.next();
        //loops through until it finds a digit at that specific index of i, then it breaks
        for (int i=0; i <input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
    if(isValid){
        return Integer.parseInt(input);
    }
    return 0;
    }

    //4.
    private static int getIntEAFP() {
        Scanner s= new Scanner(System.in);
        System.out.println("please enter an integer.");
try{
    return s.nextInt();
} catch(InputMismatchException e){
    System.out.println(e);
    return 0;
}

    }

    //Look before you leap
    private static int divideLBYL(int x , int y){
        if (y !=0){
            return x/y;
        } else{
            return 0;
        }
    }
    //easy to ask for forgiveness than permission
    private static int divideEAFP(int x, int y){
        try{
            return x/y;
        } catch (ArithmeticException e){
            System.out.println(e);
            return 0;
        }
    }
    //this method call will cause it to crash
    private static int divide(int x, int y){
        return x /y;
    }
}
