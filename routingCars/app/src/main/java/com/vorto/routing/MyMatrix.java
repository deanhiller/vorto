package com.vorto.routing;

public class MyMatrix<T> {

    private T[][] array;

    public MyMatrix(T[][] array) {
        this.array = array;
    }

    public void set(int n, int m, T value) {
        array[n][m] = value;
    }

    @Override
    public String toString() {

        String multiLine = "";
        for(int n = 0; n < array.length; n++) {
            for(int m = 0; m < array[n].length; m++) {
                multiLine += " "+array[n][m];
            }

            multiLine += "\n";
        }
        return multiLine;
    }


}
