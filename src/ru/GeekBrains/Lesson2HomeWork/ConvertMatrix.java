package ru.GeekBrains.Lesson2HomeWork;

public class ConvertMatrix {
    private final int N = 4;
    private String[][] matrix;
    private int sum;

    public ConvertMatrix(String[][] matrix) throws MyArraySizeException {
        if(matrix.length != N){
            this.matrix = null;
            throw new MyArraySizeException(N);
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != N){
                this.matrix = null;
                throw new MyArraySizeException(i,N);
            }
        }
        this.matrix = matrix;
    }

    public int getSum() throws MyArrayDataException {
        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j, e);
                }
            }
        }
        return sum;
    }
}
