package ru.ablaeva.arithmetic;

public class TerminalPow {
    public static double calculatePow (String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        return Math.pow(x, y);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Требуется два аргумента: X и Y");
            return;
        }
        double result = calculatePow(args[0], args[1]);
        System.out.println(result);
    }
}