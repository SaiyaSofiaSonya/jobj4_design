package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;

    }

    @Override
    public boolean hasNext() {
        while (row < (data.length - 1) && data[row].length == 0) {
            if (column < data[0].length - 1) {
                column = column + 1;
            } else if (row < data.length - 1) {
                row = row + 1;
                column = 0;
            }
        }
        return row < data.length
                && column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw  new NoSuchElementException();
        }
        return (data[row].length != 0 && column < (data[row].length - 1))  ? data[row][column++] : data[row++][column];
    }

    public static void main(String[] args) {
        int[][] in = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixIt it = new MatrixIt(in);
        for (int i = 0; i <= 7; i++) {
            System.out.println("For " + i + " it is: " + it.hasNext() + " and it is equal to " + it.next());
        }
    }
}
