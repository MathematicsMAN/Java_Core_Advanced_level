package ru.GeekBrains.Lesson2HomeWork;

public class Main {

    public static void main(String[] args) {
        String[][] array1 = {{"1","2","3","4"},{"3","4","5","6"},{"5","6","7","8"},{"7","8","9","11"}};
        String[][] array2 = {{"1","2","3"},{"4","5","6","6","7"},{"8","9","9","8"},{"7","6","5","4"}};
        String[][] array3 = {{"1","3","4","7"},{"3","2","one","two"},{"2","3","4","5"},{"7","8","9","2"}};
        String[][] array4 = {{"9","8","7","4"},{"2","3","4","5"},{"3","8","4","9"}};

        String[][][] matrices = {array1, array2, array3, array4};

        for (int i = 0; i < matrices.length; i++) {
            System.out.println("Обработка массива №" + (i + 1) + ":");
            try {
                ConvertMatrix convMatr = new ConvertMatrix(matrices[i]);
                System.out.println("Сумма элементов массива №" + (i + 1) + " = " + convMatr.getSum());
            }catch (MyArraySizeException | MyArrayDataException e){
                System.out.println("Ошибка обработки массива №" + (i + 1) + ". Причина ошибки следующая:");
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
        }
    }
}
