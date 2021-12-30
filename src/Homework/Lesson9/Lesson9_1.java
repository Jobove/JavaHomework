package Homework.Lesson9;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("Dividing by zero!");
    }

    public DivideByZeroException(String message) {
        super(message);
    }
}

class UnknownOpException extends Exception {
    public UnknownOpException() {
        super("UnknownOpException");
    }

    public UnknownOpException(char op) {
        super(op + " is an unknown operator.");
    }

    public UnknownOpException(String message) {
        super(message);
    }
}

class Calculator {
    protected double result;
    protected final double precision = 0.0001;

    public Calculator() {
        result = 0;
    }

    public void handleDivideByZeroException (DivideByZeroException e) {
        System.out.println("Dividing by zero.");
        System.out.println("Program aborted.");
        System.exit(0);
    }

    public void handleUnknownOpException(@NotNull UnknownOpException e) {
        System.out.println(e.getMessage());
        System.out.println("Try again from the beginning: ");

        try {
            System.out.print("Format of each line: ");
            System.out.println("operator number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter the letter e.");
            doCalculation();
        } catch (UnknownOpException e2) {
            System.out.println(e2.getMessage());
            System.out.println("Try again at some other time.");
            System.out.println("Program ending.");
            System.exit(0);
        } catch (DivideByZeroException e3) {
            handleDivideByZeroException(e3);
        }
    }

    public void reset() {
        result = 0;
    }

    public void setResult(double newResult) {
        result = newResult;
    }

    public double getResult() {
        return result;
    }

    public double evaluate(char op, double n1, double n2)
        throws DivideByZeroException, UnknownOpException {
        double answer;
        switch (op) {
            case '+':
                answer = n1 + n2;
                break;
            case '-':
                answer = n1 - n2;
                break;
            case '*':
                answer = n1 * n2;
                break;
            case '/':
                if ((-precision < n2) && (n2 < precision))
                    throw new DivideByZeroException();
                answer = n1 / n2;
                break;
            default:
                throw new UnknownOpException(op);
        }
        return answer;
    }

    public void doCalculation() throws DivideByZeroException,
            UnknownOpException {
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        result = 0;
        System.out.println("result = " + result);

        while (!done) {
            char nextOp = (keyboard.next()).charAt(0);
            if ((nextOp == 'e') || (nextOp == 'E'))
                done = true;
            else {
                double nextNumber = keyboard.nextDouble();
                result = evaluate(nextOp, result, nextNumber);
                System.out.println("result " + nextOp + " " +
                        nextNumber + " = " + result);
                System.out.println("updated result = " + result);
            }
        }
    }
}

class AnotherCalculator extends Calculator {
    protected double memory;

    public AnotherCalculator() {
        super();
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public void doCalculation() throws DivideByZeroException,
            UnknownOpException {
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        result = 0;
        System.out.println("result = " + getResult());

        while (!done) {
            char nextOp = (keyboard.next()).charAt(0);
            if ((nextOp == 'e') || (nextOp == 'E'))
                done = true;
            else if ((nextOp == 'c') || (nextOp == 'C')) {
                setResult(0);
                System.out.println("result = 0.0");
            }
            else if ((nextOp == 'm') || (nextOp == 'M')) {
                setMemory(getResult());
                System.out.println("result saved in memory");
            }
            else if ((nextOp == 'r') || (nextOp == 'R')) {
                System.out.println("recalled memory value = " + getMemory());
                System.out.println("result = " + getResult());
            }
            else {
                double nextNumber = keyboard.nextDouble();
                setResult(evaluate(nextOp, getResult(), nextNumber));
                System.out.println("result " + nextOp + " " +
                        nextNumber + " = " + getResult());
                System.out.println("updated result = " + getResult());
            }
        }
    }
}

public class Lesson9_1 {
    public static void main(String[] args) {
        AnotherCalculator calculator = new AnotherCalculator();

        try {
            System.out.println("Calculator is on.");
            System.out.print("Format of each line: ");
            System.out.println("operator space number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter the letter e.");
            calculator.doCalculation();
        } catch (UnknownOpException e) {
            calculator.handleUnknownOpException(e);
        } catch (DivideByZeroException e) {
            calculator.handleDivideByZeroException(e);
        }

        System.out.println("The final result is " + calculator.getResult());
        System.out.println("Calculator program ending.");
    }
}
