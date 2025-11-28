package ru.ablaeva.arithmetic;

class CalculateSum {
    public double findSum (double ... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Количество чисел должно быть больше 0, сударь.");
        }

        double result = 0;
        for (double num : values) {
            result += num;
        }

        return result;
    }
}