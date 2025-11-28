package ru.ablaeva.list;

public class ImmutableListofValues {
    private int[] arr;
    
    // Конструктор для массива
     public ImmutableListofValues(int[] arr) {
        this.arr = (arr == null) ? new int[0] : arr.clone();
    }
    
    // Фабричный метод для независимых значений
    public static ImmutableListofValues of(int... values) {
        return new ImmutableListofValues(values);
    }
    
    // Конструктор копирования
    public ImmutableListofValues(ImmutableListofValues other) {
        this.arr = (other != null && other.arr != null) ? other.arr.clone() : new int[0];
    }

    public int[] getArr() {
        return arr.clone();
    }

    public int getValueInN (int n) {
        int size = this.getLength();
        
        if (n >= size || n < 0) {
            throw new ArrayIndexOutOfBoundsException("N не входит в допустимый диапазон-с. Попробуйте снова-с!");
        }

        return arr[n];
    }

    public void setValueInN (int n, int x) {
        int size = this.getLength();

        if (n >= size || n < 0) {
            throw new ArrayIndexOutOfBoundsException("N не входит в допустимый диапазон-с. Попробуйте снова-с!");
        }

        arr[n] = x;
    }

    public boolean isNull() {
        return this.getLength() == 0 ? true : false;
    }

    public int getLength() {
        return arr.length;
    }

    @Override
    public String toString () {
        String result = "[";
        int size = this.getLength();

        for (int i = 0; i < size-2; i++) {
            result = result + arr[i] + ",";
        }
        
        return result + arr[size-1] + "]";
    }
}
