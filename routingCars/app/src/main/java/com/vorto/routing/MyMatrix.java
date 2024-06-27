package com.vorto.routing;

public class MyMatrix<T> {

    private T[][] array;

    public MyMatrix(T[][] array) {
        this.array = array;
    }

    public T get(int n, int m) {
        return array[n][m];
    }

    public void set(int n, int m, T value) {
        array[n][m] = value;
    }

    @Override
    public String toString() {

        int columnWidth = 4;

        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < array.length; n++) {
            for(int m = 0; m < array[n].length; m++) {
                if(array[n][m] instanceof Double) {
                    Long elem = ((Double)array[n][m]).longValue();
                    sb.append(String.format("%" + columnWidth + "d ", elem));
                } else {
                    sb.append(String.format("%" + columnWidth + "d ", array[n][m]));
                }
            }

            sb.append("\n");
        }
        return sb.toString();
    }


    public int length() {
        return array.length;
    }


}
