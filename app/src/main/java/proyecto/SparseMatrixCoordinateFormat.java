package proyecto;

import javax.naming.OperationNotSupportedException;
import lombok.Getter;
import lombok.Setter;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SparseMatrixCoordinateFormat {

    private LoadFile loader = LoadFile.getInstance();
    @Setter
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
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    if (this.matrix[i][j] != 0) {
                        values.add(this.matrix[i][j]);
                        rows.add(i);
                        columns.add(j);
                    }
                }
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
        //No usar this.matrix aqui.
        int elemento = 0;
        for (int k = 0; k < this.values.length; k++) {
            if (this.rows[k] == i && this.columns[k] == j) {
                elemento =  this.values[k];
                break;
            }
        }
        return elemento;

    }

    public int[] getRow(int i) throws OperationNotSupportedException
    {
        //No usar this.matrix aqui.
        int[] fila = new int[this.matrix[0].length];
        for (int k = 0; k < this.values.length; k++) {
            if (this.rows[k] == i) {
                fila[this.columns[k]] = this.values[k];
            }
        }
        return fila;
    }

    public int[] getColumn(int j) throws OperationNotSupportedException
    {
        //No usar this.matrix aqui.
        int[] columna = new int[this.matrix.length];
        for (int k = 0; k < this.values.length; k++) {
            if (this.columns[k] == j) {
                columna[this.rows[k]] = this.values[k];
            }
        }
        return columna;
    }

    public void setValue(int i, int j, int value) throws OperationNotSupportedException {

        //Cambiar los atributos rows, cols, values y matrix aqui
        int[][] nMatrix = new int[this.matrix.length][this.matrix[0].length];
        for (int a = 0; a < this.values.length; a++) {
            int column = this.columns[a];
            int row = this.rows[a];

            nMatrix[row][column] = this.values[a];
        }
        nMatrix[i][j] = value;
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        for (int x = 0; x < nMatrix.length; x++) {
            for (int y = 0; y < nMatrix[i].length; y++) {
                if (nMatrix[x][y] != 0) {
                    values.add(nMatrix[x][y]);
                    rows.add(x);
                    columns.add(y);
                }
            }
        }
        int[] valores = values.stream().mapToInt(n -> n).toArray();
        int[] filas = rows.stream().mapToInt(n -> n).toArray();
        int[] columnas = columns.stream().mapToInt(n -> n).toArray();
        this.setValues(valores);
        this.setRows(filas);
        this.setColumns(columnas);
    }

    /*
    * This method returns a representation of the Squared matrix
    * @return object that contests the squared matrix;
     */
    public SparseMatrixCoordinateFormat getSquareMatrix() throws OperationNotSupportedException
    {
        SparseMatrixCoordinateFormat squaredMatrix = new SparseMatrixCoordinateFormat();
        //Usar los metodos Set aqui de los atributos
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
    public SparseMatrixCoordinateFormat getTransposedMatrix() throws OperationNotSupportedException
    {
        SparseMatrixCoordinateFormat squaredMatrix = new SparseMatrixCoordinateFormat();
        //Usar los metodos Set aqui de los atributos
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> traspuesta = new ArrayList<>();
        for (int i = 0; i < this.matrix[0].length; i++) {
            traspuesta.add(new ArrayList<>());
        }
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                traspuesta.get(j).add(this.matrix[i][j]);
            }
        }
        for (int i = 0; i < traspuesta.size(); i++) {
            for (int j = 0; j < traspuesta.get(i).size(); j++) {
                if (traspuesta.get(i).get(j) != 0) {
                    values.add(traspuesta.get(i).get(j));
                    rows.add(i);
                    columns.add(j);
                }
            }
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
