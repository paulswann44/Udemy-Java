# NOTES

## Exceptions

**Exceptions** are used to handle errors or exceptional conditions that occur during the execution of a program. They allow you to catch and handle errors or unexpected events that may occur during the program's execution, such as file not found, network errors, or invalid user input. _Exceptions are a way of signaling that something has gone wrong, and they can be used to gracefully handle these situations, providing helpful feedback to users and preventing the program from crashing._

**TL;DR:** Something went wrong somewhere.
a. What went wrong? 
b. What can we do about it?


#### EXEPTIONS LIST:
1. InputMismatchException --> input is not correct datatype
2. ArithmeticException --> dividing with a denominator by 0
3. Exception e --> Catch all Exception but is better to be specific
4. NoSuchElementException


### **Stack Trace Example**
#### ArithmeticException
Exception in thread "main" java.lang.ArithmeticException: / by zero
at InputsAndOutPuts.Example.divide(StackTraceCallStack.java:15) 
at InputsAndOutPuts.Example.main(StackTraceCallStack.java:7)  <-----first method

#### ArithmeticException
Exception in thread "main" java.util.InputMismatchException
at java.base/java.util.Scanner.throwFor(Scanner.java:939)
at java.base/java.util.Scanner.next(Scanner.java:1594)
at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
at InputsAndOutPuts.Example.getInt(StackTraceCallStack.java:20)
at InputsAndOutPuts.Example.divide(StackTraceCallStack.java:12) <-----**second call** 
at InputsAndOutPuts.Example.main(StackTraceCallStack.java:7) <-----**first call** 

### **Call Stack**
call stack is a list of all the method calls at any particular point in a program's execution.
It is all if the method calls up to the point the program crashed. Best to work at the botton than work up

### **Throw an Exception**

"throwing an exception" is a way to signal that an error or exceptional condition has occurred during the execution of a program.

An exception is an object that contains information about the error, such as an error message, an error code, a stack trace (a list of function calls that led to the error), or other relevant information. When an exception is thrown, the program stops executing at that point and looks for a "catch" block that can handle the exception.

If a catch block is found that matches the type of the exception being thrown, the block is executed, and the program can recover from the error. If no catch block is found, the program will terminate with an error message.


```
public class Example {
public static void main(String[] args) {
try {
        int result = divide(10, 0);
        System.out.println("Result: " + result);
} catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero"); //<--[HERE]
        }
        return a / b;
    }`
