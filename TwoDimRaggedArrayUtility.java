import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility extends java.lang.Object {

	public TwoDimRaggedArrayUtility() {		
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles
	 * @param file  the file to read from
	 * @return ragged a two dimensional ragged (depending on data) array of
	 * doubles if the file is not empty, returns a null if file is empty
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(java.io.File file)
            throws java.io.FileNotFoundException{
	
		
		double [][] ragged;
		double [][] temp; //a temporary array	
		int row =0;
		
		
		//create scanner object
		Scanner x = new Scanner(file);

		
		
		//temporary array null
		temp = new double[10][10];
		
		
		
		//read the file into a temporary array
		
		String [] tempo = new String [10];
		
		
		for(int r = 0; r < 10 && x.hasNextLine() ; r++) {
			tempo[r]=x.nextLine();
			String parts[]=tempo[r].split("\\s");
			for(int c = 0; c< parts.length; c++) {
				temp[r][c]=Double.parseDouble(parts[c]);
			}
		}
		x.close();
		
		
		//find the valid row
		for(int i = 0; i<10; i++) {
			if(temp[i][0]!=0) {
				row++;			
			}
		}
		
		
		

		int [] colOfRow = new int[row]; 
		//find the valid column of a row
		for(int i = 0; i < row ; i++) {
			for( int j = 0; j <10 ; j++) {
				if(temp[i][j]==0) {
					colOfRow[i]=j;
					break;
				}
			}
		}
		
		
		//create the  fixed size array
		ragged = new double [row][];
		for (int i = 0; i<row; i++) {
			for (int j = 0; j < colOfRow[i] ; j++) {
				ragged[i]= new double [colOfRow[i]];
			}
		}

		
		//copy data to the ragged array
		for(int r = 0; r<ragged.length; r++) {
			for(int c=0; c<ragged[r].length; c++) {
				ragged[r][c]=temp[r][c];
			}		
		}
	
			

		return ragged;
	}
	
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.

	 * @param data two dimensional ragged array of doubles
	 * @param outputFile the file to write to
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data,
            java.io.File outputFile)
     throws java.io.FileNotFoundException{
		
		//create object PrintWriter to write on file and open a file
		PrintWriter x2 = new PrintWriter(outputFile);

		for(int i= 0; i<data.length ; i++ ) {
			for(int j=0; j< data[i].length; j++) {
				x2.print(data[i][j]+" ");
			}
			x2.print("\n");
		}
		x2.close();
	}
	
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data  the two dimensional array getting total of
	 * @return total the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		for(int i= 0; i<data.length ; i++ ) {
			for(int j=0; j< data[i].length; j++) {
				total += data[i][j];
			}
		}
		
		return total;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array 
	 * (total of elements/num of elements)
	 */
	public static double getAverage(double[][] data) {
		
		double ave=0;
		double total = 0;
		int num= 0;
		int row=data.length;
		int [] col = new int[data.length];
		
		for(int i= 0; i<data.length ; i++ ) {
			for(int j=0; j< data[i].length; j++) {
				total += data[i][j];
			}
			col[i]=data[i].length;
		}
		
		for(int i = 0; i<col.length; i++) {
			num+=col[i];
		}
		
		ave=total/num;
				
		return ave;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array 
	 * index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row  the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		
		for(int i= 0; i<data[row].length ; i++ ) {
			total += data[row][i];
		}	
		return total;	
	}

	/**
	 * Returns the total of the selected column in the two dimensional array 
	 * index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {

		double total = 0;
		
		for(int i= 0; i<data.length ; i++ ) {
			if(col>= data[i].length)
				total+=0;
			else
			total += data[i][col];
		}	
		return total;	
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array 
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row

	 */
	public static double getHighestInRow(double[][] data, int row) {
		
		double max=data[row][0];
		
		for(int i= 1; i<data[row].length ; i++ ) {
			if(data[row][i]>max) {
				max=data[row][i];
			}
		}
		
		return max;
	}
	
	/**
	 * Returns the largest element index of the selected row in the two dimensional array 
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row's index

	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		int index=0;
		double max=data[row][0];
		
		for(int i= 1; i<data[row].length ; i++ ) {
			if(data[row][i]>max) {
				max=data[row][i];
				index= i;
			}
		}
		
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array	 
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		
		double min=data[row][0];
		
		for(int i= 1; i<data[row].length ; i++ ) {
			if(data[row][i]<min) {
				min=data[row][i];
			}
		}
		
		return min;
		
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array
	 *  index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data,  int row) {
		
		int index=0;
		double min=data[row][0];
		
		for(int i= 1; i<data[row].length ; i++ ) {
			if(data[row][i]<min) {
				min=data[row][i];
				index= i;
			}
		}
		
		return index;		
	}
	
	//continue
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array 
	 * index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data  the two dimensional array
	 * @param col  the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {

		double max=data[0][col];
		
		for(int i= 1; i<data.length ; i++ ) {
			if(col >= data[i].length) {
				continue;
			}
			else if(data[i][col]>max) {
				max=data[i][col];
			}
		}
		
		return max;
		
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array 
	 * index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data  the two dimensional array
	 * @param col  the column index to find the largest element of (0 refers to the first column)
	 * @return the index of the largest element of the column

	 */
	public static int getHighestInColumnIndex(double[][] data,  int col) {
		
		double max=data[0][col];
		int index = 0;
		
		for(int i= 1; i<data.length ; i++ ) {
			if(col >= data[i].length) {
				continue;
			}
			else if(data[i][col]>max) {
				max=data[i][col];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array 
	 * index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data  the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 * 
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		
		double min=data[0][col];
		
		for(int i= 1; i<data.length ; i++ ) {
			if(col >= data[i].length) {
				continue;
			}
			else if(data[i][col]<min) {
				min=data[i][col];
			}
		}
		
		return min;
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array 
	 * index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, 
	 * it is not an error, it doesn't participate in this method.
	 * @param data  the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return  the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		double min=data[0][col];
		int index = 0;
		
		for(int i= 1; i<data.length ; i++ ) {
			if(col >= data[i].length) {
				continue;
			}
			else if(data[i][col]<min) {
				min=data[i][col];
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * Returns the largest element in the two dimensional array
	 * @param data  the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		
		double max = data[0][0];
		
		for(int r=0;r<data.length;r++) {
			for (int c=0; c<data[r].length;c++) {
				if(data[r][c]>max) {
					max=data[r][c];
				}
			}
		}
		return max;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data  the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		
		double min = data[0][0];
		
		for(int r=0;r<data.length;r++) {
			for (int c=0; c<data[r].length;c++) {
				if(data[r][c]<min) {
					min=data[r][c];
				}
			}
		}
		return min;
	}
}


