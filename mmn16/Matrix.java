// Comment - Good work!


/**
 * Matrix class represents 2d array of numbers from 0-255.
 * the matrix represents  a 2d black and white picture, as the numbers represent the grey shades of the picture  
 * 0 is white and 255 is black.
 *
 * @author (Ephraim Phil -)
 * @version (19/1/2019)
 */
public class Matrix
{
    private int [][] _intArray;

    /**
     * Construcs a Matrix from a two dimensional array, the dimensions as well as the values of this matrix 
     * will be the same as the dimension and the values of the two dimensional array.
     * @param array is a 2d array matrix contains numbers 0-255. 
     */
    public Matrix(int[][]array)
    {
        int intArrayRows = array.length;
        int arrayColumns = array[0].length;

        _intArray  = new int [intArrayRows][arrayColumns];
        for(int i = 0 ; i < array.length;i++)
        {
            for(int j = 0 ; j < array[i].length; j++)
            {
                _intArray[i][j] =  array[i][j];
            }
        }
    }

    /**
     * Construcs a size1 by size2 Matrix of zeros
     * @param size1 represents the rows.
     * @param size2 represents the columns.
     */
    public Matrix(int size1, int size2)
    {
        _intArray = new int [size1][size2];
    }

    /**
     * Returns a string representation of the Matrix.
     * @override toString in class java.lang.Object
     * @return A String representation of the Matrix.
     */
    public String toString()
    {
        String toString = "";
        for(int i = 0; i < _intArray.length ; i++)
        {
            toString += "\n";
            for(int j = 0; j < _intArray[i].length; j++)
            {
                toString += _intArray[i][j]+"\t";
            }
        }
        return toString;
    }

    /**
     * This method flips a Matrix vertically.
     * \nthe first row becomes the last row, the second row becomes the second row from the bottom.
     * @return a vertically flipped Matrix.
     */
    public Matrix flipVertical()
    {
        int rows = getRows();
        int columns = getColms();
        int [][] intArray = newArray(rows, columns);

        for(int i = 0; i < (intArray.length / 2); i++) {
            int []array = intArray[i];
            intArray[i] = intArray[intArray.length - i - 1];
            intArray[intArray.length - i - 1] = array;
        }

        return new Matrix(intArray);
    }

    /**
     * This method flips a Matrix horizontally.
     * the first row becomes the last row, the second row becomes the second row from the bottom.
     * @return a horizontally flipped Matrix.
     */
    public Matrix flipHorizontal()
    {
        int rows = getRows();
        int columns = getColms();
        int [][] intArray = newArray( rows, columns) ;

        for(int i = 0; i < intArray.length; i++)
        {
            for(int j = 0; j < intArray[i].length / 2; j++) 
            {
                int array = intArray[i][j];
                intArray[i][j] = intArray[i][intArray[i].length - j - 1];
                intArray[i][intArray[i].length - j - 1] = array;
            }
        }
        return new Matrix(intArray);
    }

    /**
     * This method rotates a Matrix 90 degrees clockwise.
     * @return a 90 degrees rotated Matrix.
     */
    public Matrix rotateClockwise() 
    {
        int rows = getRows();
        int columns = getColms();
        int [][] intArray = newArray(rows, columns);

        int[][] newArray = new int[ columns ][ rows ];
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < columns; j++ ) {
                newArray[ j ][ rows - 1 - i ] = intArray[ i ][ j ];
            }
        }
        return new Matrix(newArray);
    }

    /**
     * This method rotates a Matrix 90 degrees Counter-clockwise.
     * @return a 90 degrees Counter-clockwise rotated Matrix.
     */
    public Matrix rotateCounterClockwise()
    {
        int rows = getRows();
        int columns = getColms();
        int [][] intArray = newArray(rows, columns);

        int[][] newArray = new int[ columns ][ rows ];
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < columns; j++ ) {
                newArray[ j ][ rows - rows + i ] = intArray[ i ][ columns - 1 - j ];
            }
        }
        return new Matrix(newArray);
    }

    private  int [][] newArray( int rows, int columns )
    {
        int [][]array = new int[rows][columns];

        for (int i = 0 ; i < _intArray.length; i++)
        {
            for(int j = 0; j < _intArray[0].length ; j++)
            {
                array[i][j] = _intArray[i][j];
            }
        }
        return array;
    }

    private int getRows()
    {
        int rows = _intArray.length;
        return rows;
    }

    private int getColms()
    {
        int columns = _intArray[0].length;
        return columns;
    }
}
