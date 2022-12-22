package proyecto;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SparseMatrixCSCTest {
    private String file0 = "inputs/matrix0.in";
    private String file1 = "inputs/matrix1.in";
    private String file2 = "inputs/matrix2.in";
    private String file3 = "inputs/matrix3.in";
    private String file4 = "inputs/matrix4.in";
    private String file5 = "inputs/matrix5.in";


    @Test
    void createRepresentation() throws FileNotFoundException, OperationNotSupportedException {
        SparseMatrixCSC instance = new SparseMatrixCSC();

        //Test 0
        instance.createRepresentation(file0);
        int rows[] = {4, 5, 6, 0, 1, 5, 1, 7, 2, 1, 4, 7, 0};
        int cols[] = {0, 3, 6, 8, 9, 9, 12, 13};
        int values[] = {5, 1, 4, 2, 8, 2, 9, 7, 3, 1, 6, 11, 4};
        assertTrue(Arrays.equals(rows, instance.getRows()));
        assertTrue(Arrays.equals(cols, instance.getColumns()));
        assertTrue(Arrays.equals(values, instance.getValues()));

        //Test 1
        instance.createRepresentation(file1);
        int rowsA[] = {0, 1, 2, 4, 0, 2, 3, 4, 2, 4};
        int colsA[] = {0, 0, 4, 8, 8, 8, 9, 9, 10};
        int valuesA[] = {1, 1, 1, 1, 4, 2, 3, 4, 8, 9};
        assertTrue(Arrays.equals(rowsA, instance.getRows()));
        assertTrue(Arrays.equals(colsA, instance.getColumns()));
        assertTrue(Arrays.equals(valuesA, instance.getValues()));

        //Test 2
        instance.createRepresentation(file2);
        int rowsB[] = {6, 8, 9, 0, 1, 2, 4, 6, 8, 0, 2, 3, 4, 6, 5, 2, 5, 7, 8, 4};
        int colsB[] = {0, 3, 9, 14, 14, 15, 17, 19, 20};
        int valuesB[] = {1, 1, 9, 1, 1, 1, 1, 2, 1, 4, 2, 3, 4, 3, 7, 8, 3, 9, 7, 9};

        assertTrue(Arrays.equals(rowsB, instance.getRows()));
        assertTrue(Arrays.equals(colsB, instance.getColumns()));
        assertTrue(Arrays.equals(valuesB, instance.getValues()));

        //Test 3
        instance.createRepresentation(file3);
        int rowsC[] = {6, 8, 9, 0, 1, 2, 4, 6, 8, 0, 2, 3, 4, 6, 5, 2, 5, 7, 8, 4, 1, 1, 7, 3, 4, 5, 6, 9, 8};
        int colsC[] = {0, 3, 9, 14, 14, 15, 17, 19, 20, 21, 23, 28, 29};
        int valuesC[] = {1, 1, 9, 1, 1, 1, 1, 2, 1, 4, 2, 3, 4, 3, 7, 8, 3, 9, 7, 9, 1, 1, 9, 3, 9, 7, 6, 4, 1};

        assertTrue(Arrays.equals(rowsC, instance.getRows()));
        assertTrue(Arrays.equals(colsC, instance.getColumns()));
        assertTrue(Arrays.equals(valuesC, instance.getValues()));

        //Test 4
        instance.createRepresentation(file4);
        int rowsD[] = {6, 8, 9, 13, 14, 0, 1, 2, 4, 6, 8, 12, 13, 14, 0, 2, 3, 4, 6, 12, 13, 14, 11, 13, 5, 13, 2, 5, 11, 13, 7, 8, 11, 13, 4, 14, 1, 14, 1, 7, 14, 3, 4, 5, 6, 9, 8};
        int colsD[] = {0, 5, 14, 22, 24, 26, 30, 34, 36, 38, 41, 46, 47};
        int valuesD[] = {1, 1, 9, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 4, 2, 3, 4, 3, 1, 1, 2, 4, 1, 7, 1, 8, 3, 3, 1, 9, 7, 6, 1, 9, 2, 1, 2, 1, 9, 2, 3, 9, 7, 6, 4, 1};

        assertTrue(Arrays.equals(rowsD, instance.getRows()));
        assertTrue(Arrays.equals(colsD, instance.getColumns()));
        assertTrue(Arrays.equals(valuesD, instance.getValues()));

        //Test 5
        instance.createRepresentation(file5);
        int rowsE[] = {6, 8, 9, 13, 14, 0, 1, 2, 4, 6, 8, 12, 13, 14, 0, 2, 3, 4, 6, 12, 13, 14, 11, 13, 5, 13, 2, 5, 11, 13, 7, 8, 11, 13, 4, 14, 1, 14, 1, 7, 14, 3, 4, 5, 6, 9, 8, 3, 6, 7, 9, 11, 12, 13, 1, 2, 3, 6, 8};
        int colsE[] = {0, 5, 14, 22, 24, 26, 30, 34, 36, 38, 41, 46, 47, 47, 54, 59};
        int valuesE[] = {1, 1, 9, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 4, 2, 3, 4, 3, 1, 1, 2, 4, 1, 7, 1, 8, 3, 3, 1, 9, 7, 6, 1, 9, 2, 1, 2, 1, 9, 2, 3, 9, 7, 6, 4, 1, 2, 7, 7, 2, 9, 2, 3, 1, 2, 4, 3, 1};

        assertTrue(Arrays.equals(rowsE, instance.getRows()));
        assertTrue(Arrays.equals(colsE, instance.getColumns()));
        assertTrue(Arrays.equals(valuesE, instance.getValues()));
    }

    @Test
    void getElement() throws OperationNotSupportedException, FileNotFoundException {
        SparseMatrixCSC instance = new SparseMatrixCSC();
        //Test 1
        instance.createRepresentation(file1);
        assertEquals(instance.getElement(0, 0), 0);
        assertEquals(instance.getElement(1, 2), 0);
        assertEquals(instance.getElement(4, 7), 9);

        //Test 2
        instance.createRepresentation(file2);
        assertEquals(instance.getElement(0, 0), 0);
        assertEquals(instance.getElement(5, 3), 0);
        assertEquals(instance.getElement(6, 2), 3);

        //Test 3
        instance.createRepresentation(file3);
        assertEquals(instance.getElement(0, 0), 0);
        assertEquals(instance.getElement(4, 10), 9);
        assertEquals(instance.getElement(9, 9), 0);

        //Test 4
        instance.createRepresentation(file4);
        assertEquals(instance.getElement(0, 0), 0);
        assertEquals(instance.getElement(4, 10), 9);
        assertEquals(instance.getElement(14, 8), 2);

        //Test 5
        instance.createRepresentation(file5);
        assertEquals(instance.getElement(0, 0), 0);
        assertEquals(instance.getElement(4, 10), 9);
        assertEquals(instance.getElement(14, 14), 0);
    }

    @Test
    void getRow() throws OperationNotSupportedException, FileNotFoundException {
        SparseMatrixCSC instance = new SparseMatrixCSC();
        //Test 1
        instance.createRepresentation(file1);
        assertTrue(Arrays.equals(
                instance.getRow(2),
                new int[]{0, 1, 2, 0, 0, 8, 0, 0}
        ));
        assertTrue(Arrays.equals(
                instance.getRow(4),
                new int[]{0, 1, 4, 0, 0, 0, 0, 9}
        ));

        //Test 2
        instance.createRepresentation(file2);
        assertTrue(Arrays.equals(
                instance.getRow(5),
                new int[]{0, 0, 0, 0, 7, 3, 0, 0}
        ));
        assertTrue(Arrays.equals(
                instance.getRow(8),
                new int[]{1, 1, 0, 0, 0, 0, 7, 0}
        ));
        //Test 3
        instance.createRepresentation(file3);
        assertTrue(Arrays.equals(
                instance.getRow(5),
                new int[]{0, 0, 0, 0, 7, 3, 0, 0, 0, 0, 7, 0}
        ));
        assertTrue(Arrays.equals(
                instance.getRow(9),
                new int[]{9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0}
        ));
        //Test 4
        instance.createRepresentation(file4);
        assertTrue(Arrays.equals(
                instance.getRow(9),
                new int[]{9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0}
        ));
        assertTrue(Arrays.equals(
                instance.getRow(14),
                new int[]{2, 2, 2, 0, 0, 0, 0, 2, 2, 2, 0, 0}
        ));

        //Test 5
        instance.createRepresentation(file5);
        assertTrue(Arrays.equals(
                instance.getRow(2),
                new int[]{0, 1, 2, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 2}
        ));
        assertTrue(Arrays.equals(
                instance.getRow(13),
                new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 3, 0}
        ));
    }

    @Test
    void getColumn() throws OperationNotSupportedException, FileNotFoundException {
        SparseMatrixCSC instance = new SparseMatrixCSC();
        //Test 1
        instance.createRepresentation(file1);
        assertTrue(Arrays.equals(
                instance.getColumn(1),
                new int[]{1, 1, 1, 0, 1}
        ));
        assertTrue(Arrays.equals(
                instance.getColumn(4),
                new int[]{0, 0, 0, 0, 0}
        ));

        //Test 2
        instance.createRepresentation(file2);
        assertTrue(Arrays.equals(
                instance.getColumn(5),
                new int[]{0, 0, 8, 0, 0, 3, 0, 0, 0, 0}
        ));
        assertTrue(Arrays.equals(
                instance.getColumn(6),
                new int[]{0, 0, 0, 0, 0, 0, 0, 9, 7, 0}
        ));
        //Test 3
        instance.createRepresentation(file3);
        assertTrue(Arrays.equals(
                instance.getColumn(5),
                new int[]{0, 0, 8, 0, 0, 3, 0, 0, 0, 0}
        ));
        assertTrue(Arrays.equals(
                instance.getColumn(9),
                new int[]{0, 1, 0, 0, 0, 0, 0, 9, 0, 0}
        ));
        //Test 4
        instance.createRepresentation(file4);
        assertTrue(Arrays.equals(
                instance.getColumn(9),
                new int[]{0, 1, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 2}
        ));
        assertTrue(Arrays.equals(
                instance.getColumn(10),
                new int[]{0, 0, 0, 3, 9, 7, 6, 0, 0, 4, 0, 0, 0, 0, 0}
        ));

        //Test 5
        instance.createRepresentation(file5);
        assertTrue(Arrays.equals(
                instance.getColumn(2),
                new int[]{4, 0, 2, 3, 4, 0, 3, 0, 0, 0, 0, 0, 1, 1, 2}
        ));
        assertTrue(Arrays.equals(
                instance.getColumn(13),
                new int[]{0, 0, 0, 2, 0, 0, 7, 7, 0, 2, 0, 9, 2, 3, 0}
        ));
    }

    @Test
    void setValue() throws OperationNotSupportedException, FileNotFoundException {
        SparseMatrixCSC instance = new SparseMatrixCSC();
        //Test 0
        instance.createRepresentation(file0);
        instance.setValue(0, 4, 10);
        int rows[] = {4, 5, 6, 0, 1, 5, 1, 7, 2, 0, 1, 4, 7, 0};
        int cols[] = {0, 3, 6, 8, 9, 10, 13, 14};
        int values[] = {5, 1, 4, 2, 8, 2, 9, 7, 3, 10, 1, 6, 11, 4};
        assertTrue(Arrays.equals(rows, instance.getRows()));
        assertTrue(Arrays.equals(cols, instance.getColumns()));
        assertTrue(Arrays.equals(values, instance.getValues()));

        //Test 1
        instance.createRepresentation(file1);
        instance.setValue(0, 4, 10);
        int rowsA[] = {0, 1, 2, 4, 0, 2, 3, 4, 0, 2, 4};
        int colsA[] = {0, 0, 4, 8, 8, 9, 10, 10, 11};
        int valuesA[] = {1, 1, 1, 1, 4, 2, 3, 4, 10, 8, 9};
        assertTrue(Arrays.equals(rowsA, instance.getRows()));
        assertTrue(Arrays.equals(colsA, instance.getColumns()));
        assertTrue(Arrays.equals(valuesA, instance.getValues()));

        //Test 2
        instance.createRepresentation(file2);
        instance.setValue(0, 4, 10);
        int rowsB[] = {6, 8, 9, 0, 1, 2, 4, 6, 8, 0, 2, 3, 4, 6, 0, 5, 2, 5, 7, 8, 4};
        int colsB[] = {0, 3, 9, 14, 14, 16, 18, 20, 21};
        int valuesB[] = {1, 1, 9, 1, 1, 1, 1, 2, 1, 4, 2, 3, 4, 3, 10, 7, 8, 3, 9, 7, 9};


        assertTrue(Arrays.equals(rowsB, instance.getRows()));
        assertTrue(Arrays.equals(colsB, instance.getColumns()));
        assertTrue(Arrays.equals(valuesB, instance.getValues()));

        //Test 3
        instance.createRepresentation(file3);
        instance.setValue(0, 4, 10);
        int rowsC[] = {6, 8, 9, 0, 1, 2, 4, 6, 8, 0, 2, 3, 4, 6, 0, 5, 2, 5, 7, 8, 4, 1, 1, 7, 3, 4, 5, 6, 9, 8};
        int colsC[] = {0, 3, 9, 14, 14, 16, 18, 20, 21, 22, 24, 29, 30};
        int valuesC[] = {1, 1, 9, 1, 1, 1, 1, 2, 1, 4, 2, 3, 4, 3, 10, 7, 8, 3, 9, 7, 9, 1, 1, 9, 3, 9, 7, 6, 4, 1};

        assertTrue(Arrays.equals(rowsC, instance.getRows()));
        assertTrue(Arrays.equals(colsC, instance.getColumns()));
        assertTrue(Arrays.equals(valuesC, instance.getValues()));

        //Test 4
        instance.createRepresentation(file4);
        instance.setValue(0, 4, 10);
        int rowsD[] = {6, 8, 9, 13, 14, 0, 1, 2, 4, 6, 8, 12, 13, 14, 0, 2, 3, 4, 6, 12, 13, 14, 11, 13, 0, 5, 13, 2, 5, 11, 13, 7, 8, 11, 13, 4, 14, 1, 14, 1, 7, 14, 3, 4, 5, 6, 9, 8};
        int colsD[] = {0, 5, 14, 22, 24, 27, 31, 35, 37, 39, 42, 47, 48};
        int valuesD[] = {1, 1, 9, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 4, 2, 3, 4, 3, 1, 1, 2, 4, 1, 10, 7, 1, 8, 3, 3, 1, 9, 7, 6, 1, 9, 2, 1, 2, 1, 9, 2, 3, 9, 7, 6, 4, 1};
        assertTrue(Arrays.equals(rowsD, instance.getRows()));
        assertTrue(Arrays.equals(colsD, instance.getColumns()));
        assertTrue(Arrays.equals(valuesD, instance.getValues()));

        //Test 5
        instance.createRepresentation(file5);
        instance.setValue(0, 4, 10);
        int rowsE[] = {6, 8, 9, 13, 14, 0, 1, 2, 4, 6, 8, 12, 13, 14, 0, 2, 3, 4, 6, 12, 13, 14, 11, 13, 0, 5, 13, 2, 5, 11, 13, 7, 8, 11, 13, 4, 14, 1, 14, 1, 7, 14, 3, 4, 5, 6, 9, 8, 3, 6, 7, 9, 11, 12, 13, 1, 2, 3, 6, 8};
        int colsE[] = {0, 5, 14, 22, 24, 27, 31, 35, 37, 39, 42, 47, 48, 48, 55, 60};
        int valuesE[] = {1, 1, 9, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 4, 2, 3, 4, 3, 1, 1, 2, 4, 1, 10, 7, 1, 8, 3, 3, 1, 9, 7, 6, 1, 9, 2, 1, 2, 1, 9, 2, 3, 9, 7, 6, 4, 1, 2, 7, 7, 2, 9, 2, 3, 1, 2, 4, 3, 1};
        assertTrue(Arrays.equals(rowsE, instance.getRows()));
        assertTrue(Arrays.equals(colsE, instance.getColumns()));
        assertTrue(Arrays.equals(valuesE, instance.getValues()));
    }

    @Test
    void getSquareMatrix() throws OperationNotSupportedException, FileNotFoundException {
        SparseMatrixCSC instance = new SparseMatrixCSC();
        SparseMatrixCSC inst;

        //Test 0
        instance.createRepresentation(file0);
        inst = instance.getSquareMatrix();
        int rows[] = {4, 5, 6, 0, 1, 5, 1, 7, 2, 1, 4, 7, 0};
        int cols[] = {0, 3, 6, 8, 9, 9, 12, 13};
        int values[] = {25, 1, 16, 4, 64, 4, 81, 49, 9, 1, 36, 121, 16};
        assertTrue(Arrays.equals(rows, inst.getRows()));
        assertTrue(Arrays.equals(cols, inst.getColumns()));
        assertTrue(Arrays.equals(values, inst.getValues()));

        //Test 1
        instance.createRepresentation(file1);
        inst = instance.getSquareMatrix();

        int rowsA[] = {0, 1, 2, 4, 0, 2, 3, 4, 2, 4};
        int colsA[] = {0, 0, 4, 8, 8, 8, 9, 9, 10};
        int valuesA[] = {1, 1, 1, 1, 16, 4, 9, 16, 64, 81};
        assertTrue(Arrays.equals(rowsA, inst.getRows()));
        assertTrue(Arrays.equals(colsA, inst.getColumns()));
        assertTrue(Arrays.equals(valuesA, inst.getValues()));

        //Test 2
        instance.createRepresentation(file2);
        inst = instance.getSquareMatrix();

        int rowsB[] = {6, 8, 9, 0, 1, 2, 4, 6, 8, 0, 2, 3, 4, 6, 5, 2, 5, 7, 8, 4};
        int colsB[] = {0, 3, 9, 14, 14, 15, 17, 19, 20};
        int valuesB[] = {1, 1, 81, 1, 1, 1, 1, 4, 1, 16, 4, 9, 16, 9, 49, 64, 9, 81, 49, 81};

        assertTrue(Arrays.equals(rowsB, inst.getRows()));
        assertTrue(Arrays.equals(colsB, inst.getColumns()));
        assertTrue(Arrays.equals(valuesB, inst.getValues()));

        //Test 3
        instance.createRepresentation(file3);
        inst = instance.getSquareMatrix();

        int rowsC[] = {6, 8, 9, 0, 1, 2, 4, 6, 8, 0, 2, 3, 4, 6, 5, 2, 5, 7, 8, 4, 1, 1, 7, 3, 4, 5, 6, 9, 8};
        int colsC[] = {0, 3, 9, 14, 14, 15, 17, 19, 20, 21, 23, 28, 29};
        int valuesC[] = {1, 1, 81, 1, 1, 1, 1, 4, 1, 16, 4, 9, 16, 9, 49, 64, 9, 81, 49, 81, 1, 1, 81, 9, 81, 49, 36, 16, 1};

        assertTrue(Arrays.equals(rowsC, inst.getRows()));
        assertTrue(Arrays.equals(colsC, inst.getColumns()));
        assertTrue(Arrays.equals(valuesC, inst.getValues()));

        //Test 4
        instance.createRepresentation(file4);
        inst = instance.getSquareMatrix();

        int rowsD[] = {6, 8, 9, 13, 14, 0, 1, 2, 4, 6, 8, 12, 13, 14, 0, 2, 3, 4, 6, 12, 13, 14, 11, 13, 5, 13, 2, 5, 11, 13, 7, 8, 11, 13, 4, 14, 1, 14, 1, 7, 14, 3, 4, 5, 6, 9, 8};
        int colsD[] = {0, 5, 14, 22, 24, 26, 30, 34, 36, 38, 41, 46, 47};
        int valuesD[] = {1, 1, 81, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 16, 4, 9, 16, 9, 1, 1, 4, 16, 1, 49, 1, 64, 9, 9, 1, 81, 49, 36, 1, 81, 4, 1, 4, 1, 81, 4, 9, 81, 49, 36, 16, 1};

        assertTrue(Arrays.equals(rowsD, inst.getRows()));
        assertTrue(Arrays.equals(colsD, inst.getColumns()));
        assertTrue(Arrays.equals(valuesD, inst.getValues()));

        //Test 5
        instance.createRepresentation(file5);
        inst = instance.getSquareMatrix();

        int rowsE[] = {6, 8, 9, 13, 14, 0, 1, 2, 4, 6, 8, 12, 13, 14, 0, 2, 3, 4, 6, 12, 13, 14, 11, 13, 5, 13, 2, 5, 11, 13, 7, 8, 11, 13, 4, 14, 1, 14, 1, 7, 14, 3, 4, 5, 6, 9, 8, 3, 6, 7, 9, 11, 12, 13, 1, 2, 3, 6, 8};
        int colsE[] = {0, 5, 14, 22, 24, 26, 30, 34, 36, 38, 41, 46, 47, 47, 54, 59};
        int valuesE[] = {1, 1, 81, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 16, 4, 9, 16, 9, 1, 1, 4, 16, 1, 49, 1, 64, 9, 9, 1, 81, 49, 36, 1, 81, 4, 1, 4, 1, 81, 4, 9, 81, 49, 36, 16, 1, 4, 49, 49, 4, 81, 4, 9, 1, 4, 16, 9, 1};

        assertTrue(Arrays.equals(rowsE, inst.getRows()));
        assertTrue(Arrays.equals(colsE, inst.getColumns()));
        assertTrue(Arrays.equals(valuesE, inst.getValues()));
    }

    @Test
    void getTransposedMatrix() throws OperationNotSupportedException, FileNotFoundException {
        SparseMatrixCSC instance = new SparseMatrixCSC();
        SparseMatrixCSC inst;

        //Test 0
        instance.createRepresentation(file0);
        inst = instance.getTransposedMatrix();
        int rows[] = {1, 6, 1, 2, 5, 3, 0, 5, 0, 1, 0, 2, 5};
        int cols[] = {0, 2, 5, 6, 6, 8, 10, 11, 13};
        int values[] = {2, 4, 8, 9, 1, 3, 5, 6, 1, 2, 4, 7, 11};
        assertTrue(Arrays.equals(rows, inst.getRows()));
        assertTrue(Arrays.equals(cols, inst.getColumns()));
        assertTrue(Arrays.equals(values, inst.getValues()));

        //Test 1
        instance.createRepresentation(file1);
        inst = instance.getTransposedMatrix();
        int rowsA[] = {1, 2, 1, 1, 2, 5, 2, 1, 2, 7};
        int colsA[] = {0, 2, 3, 6, 7, 10};
        int valuesA[] = {1, 4, 1, 1, 2, 8, 3, 1, 4, 9};
        assertTrue(Arrays.equals(rowsA, inst.getRows()));
        assertTrue(Arrays.equals(colsA, inst.getColumns()));
        assertTrue(Arrays.equals(valuesA, inst.getValues()));

        //Test 2
        instance.createRepresentation(file2);
        inst = instance.getTransposedMatrix();
        int rowsB[] = {1, 2, 1, 1, 2, 5, 2, 1, 2, 7, 4, 5, 0, 1, 2, 6, 0, 1, 6, 0};
        int colsB[] = {0, 2, 3, 6, 7, 10, 12, 15, 16, 19, 20};
        int valuesB[] = {1, 4, 1, 1, 2, 8, 3, 1, 4, 9, 7, 3, 1, 2, 3, 9, 1, 1, 7, 9};
        assertTrue(Arrays.equals(rowsB, inst.getRows()));
        assertTrue(Arrays.equals(colsB, inst.getColumns()));
        assertTrue(Arrays.equals(valuesB, inst.getValues()));

        //Test 3
        instance.createRepresentation(file3);
        inst = instance.getTransposedMatrix();
        int rowsC[] = {1, 2, 1, 8, 9, 1, 2, 5, 2, 10, 1, 2, 7, 10, 4, 5, 10, 0, 1, 2, 10, 6, 9, 0, 1, 6, 11, 0, 10};
        int colsC[] = {0, 2, 5, 8, 10, 14, 17, 21, 23, 27, 29};
        int valuesC[] = {1, 4, 1, 1, 1, 1, 2, 8, 3, 3, 1, 4, 9, 9, 7, 3, 7, 1, 2, 3, 6, 9, 9, 1, 1, 7, 1, 9, 4};
        assertTrue(Arrays.equals(rowsC, inst.getRows()));
        assertTrue(Arrays.equals(colsC, inst.getColumns()));
        assertTrue(Arrays.equals(valuesC, inst.getValues()));

        //Test 4
        instance.createRepresentation(file4);
        inst = instance.getTransposedMatrix();
        int rowsD[] = {1, 2, 1, 8, 9, 1, 2, 5, 2, 10, 1, 2, 7, 10, 4, 5, 10, 0, 1, 2, 10, 6, 9, 0, 1, 6, 11, 0, 10, 3, 5, 6, 1, 2, 0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 7, 8, 9};
        int colsD[] = {0, 2, 5, 8, 10, 14, 17, 21, 23, 27, 29, 29, 32, 34, 41, 47};
        int valuesD[] = {1, 4, 1, 1, 1, 1, 2, 8, 3, 3, 1, 4, 9, 9, 7, 3, 7, 1, 2, 3, 6, 9, 9, 1, 1, 7, 1, 9, 4, 4, 3, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        assertTrue(Arrays.equals(rowsD, inst.getRows()));
        assertTrue(Arrays.equals(colsD, inst.getColumns()));
        assertTrue(Arrays.equals(valuesD, inst.getValues()));

        //Test 5
        instance.createRepresentation(file5);
        inst = instance.getTransposedMatrix();
        int rowsE[] = {1, 2, 1, 8, 9, 14, 1, 2, 5, 14, 2, 10, 13, 14, 1, 2, 7, 10, 4, 5, 10, 0, 1, 2, 10, 13, 14, 6, 9, 13, 0, 1,
                6, 11, 14, 0, 10, 13, 3, 5, 6, 13, 1, 2, 13, 0, 1, 2, 3, 4, 5, 6, 13, 0, 1, 2, 7, 8, 9};
        int colsE[] = {0, 2, 6, 10, 14, 18, 21, 27, 30, 35, 38, 38, 42, 45, 53, 59};
        int valuesE[] = {1, 4, 1, 1, 1, 1, 1, 2, 8, 2, 3, 3, 2, 4, 1, 4, 9, 9, 7, 3, 7, 1, 2, 3, 6, 7, 3, 9, 9, 7, 1, 1, 7, 1, 1, 9, 4, 2, 4, 3, 6, 9, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 3, 2, 2, 2, 2, 2, 2};
        assertTrue(Arrays.equals(rowsE, inst.getRows()));
        assertTrue(Arrays.equals(colsE, inst.getColumns()));
        assertTrue(Arrays.equals(valuesE, inst.getValues()));
    }
}
