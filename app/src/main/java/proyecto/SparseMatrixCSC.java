package proyecto;

import javax.naming.OperationNotSupportedException;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SparseMatrixCSC {
    private LoadFile loader = LoadFile.getInstance();
    private int[][] matrix;
    @Getter
    @Setter
    private int[] rows;
    @Getter
    @Setter
    private int[] columns;
    @Getter
    @Setter
    private int[] values;

    public void createRepresentation(String inputFile) throws OperationNotSupportedException, FileNotFoundException {
        //Load data
        loader.loadFile(inputFile);
        matrix = loader.getMatrix();
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        columns.add(0);
        int m = 0;
        for (int j = 0; j < this.matrix[0].length; j++) {
            int count = 0;
            for (int i = 0; i < this.matrix.length; i++) {
                if (this.matrix[i][j] != 0) {
                    values.add(this.matrix[i][j]);
                    rows.add(i);
                    count++;
                }
            }
            m += count;
            columns.add(m);
        }
        int[] valores = values.stream().mapToInt(i -> i).toArray();
        int[] filas = rows.stream().mapToInt(i -> i).toArray();
        int[] columnas = columns.stream().mapToInt(i -> i).toArray();
        this.setValues(valores);
        this.setRows(filas);
        this.setColumns(columnas);

    }

    public int getElement(int i, int j) throws OperationNotSupportedException
    {
        for (int x = this.columns[j]; x < this.columns[j + 1]; x++) {
            if (this.rows[x] == i) {
                return this.values[x];
            }
        }
        return 0;
    }

    public int[] getRow(int i) throws OperationNotSupportedException
    {
        int[] row = new int[this.matrix[0].length];
        for (int j = 0; j < row.length; j++) {
            int valor = 0;
            for (int x = this.columns[j]; x < this.columns[j + 1]; x++) {
                if (this.rows[x] == i) {
                    valor = this.values[x];
                    break;
                }
            }
            row[j] = valor;
        }
        return row;

    }

    public int[] getColumn(int j) throws OperationNotSupportedException
    {
        int[] column = new int[this.matrix.length];
        for (int x = this.columns[j]; x < this.columns[j + 1]; x++) {
            column[this.rows[x]] = this.values[x];
        }
        return column;
    }

    public void setValue(int k, int z, int value) throws OperationNotSupportedException
    {
        //Se crean representaciones desde cero por medio de ArrayList
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        //Es una matrix de arrayList
        ArrayList<ArrayList<Integer>> nMatrix = new ArrayList<>();
        //Crea la matriz
        for (int i = 0; i < this.matrix.length; i++) {
            nMatrix.add(new ArrayList<>());
        }
        //se pasan los valores de la matriz original a la nueva
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                nMatrix.get(i).add(matrix[i][j]);
            }
        }
        nMatrix.get(k).set(z, value);

        //A partir de aqui se reutiliza la representacion desde 0, pero con  la nueva matriz
        columns.add(0);
        int n = 0;
        for (int j = 0; j < nMatrix.get(0).size(); j++) {
            int count = 0;
            for (int i = 0; i < nMatrix.size(); i++) {
                if (nMatrix.get(i).get(j) != 0) {
                    values.add(nMatrix.get(i).get(j));
                    rows.add(i);
                    count++;
                }
            }
            n += count;
            columns.add(n);
        }
        //Mapeo de arrayList a Array normales
        int[] valores = values.stream().mapToInt(i -> i).toArray();
        int[] filas = rows.stream().mapToInt(i -> i).toArray();
        int[] columnas = columns.stream().mapToInt(i -> i).toArray();
        this.setValues(valores);
        this.setRows(filas);
        this.setColumns(columnas);
    }

    /*
     * This method returns a representation of the Squared matrix
     * @return object that contests the squared matrix;
     */
    public SparseMatrixCSC getSquareMatrix() throws OperationNotSupportedException
    {
        SparseMatrixCSC squaredMatrix = new SparseMatrixCSC();
        for (int k = 0; k < this.values.length; k++) {
            this.values[k] *= this.values[k];
        }
        squaredMatrix.setRows(this.rows);
        squaredMatrix.setColumns(this.columns);
        squaredMatrix.setValues(this.values);
        return squaredMatrix;
    }

    /*
     * This method returns a representation of the transposed matrix
     * @return object that contests the transposed matrix;
     */
    public SparseMatrixCSC getTransposedMatrix() throws OperationNotSupportedException
    {
        SparseMatrixCSC squaredMatrix = new SparseMatrixCSC();
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> traspuesta = new ArrayList<>();
        for (int i = 0; i < this.matrix[0].length; i++) {
            traspuesta.add(new ArrayList<>());
        }
        for (int[] ints : this.matrix) {
            for (int j = 0; j < ints.length; j++) {
                traspuesta.get(j).add(ints[j]);
            }
        }
        columns.add(0);
        int m = 0;
        for (int j = 0; j < traspuesta.get(0).size(); j++) {
            int count = 0;
            for (int i = 0; i < traspuesta.size(); i++) {
                if (traspuesta.get(i).get(j) != 0) {
                    values.add(traspuesta.get(i).get(j));
                    rows.add(i);
                    count++;
                }
            }
            m += count;
            columns.add(m);
        }
        int[] valores = values.stream().mapToInt(i -> i).toArray();
        int[] filas = rows.stream().mapToInt(i -> i).toArray();
        int[] columnas = columns.stream().mapToInt(i -> i).toArray();
        squaredMatrix.setRows(filas);
        squaredMatrix.setColumns(columnas);
        squaredMatrix.setValues(valores);
        return squaredMatrix;
    }
}
