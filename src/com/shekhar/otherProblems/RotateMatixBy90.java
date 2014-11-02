package com.shekhar.otherProblems;

import java.util.Scanner;

/**
 * 
 * @author shashank
 *	Implementation of the program where one matrix is rotated by 90 degrees, no more operations to be done.
 *  
 *  To run the program, export as Runnable JAR and use command line for running the jar
 *  use the following command:
 *  java -jar <jar-name>.jar
 *  
 *  To debug the program, use the runnable JAR and run with the following command:
 *  java -Xdebug -Xrunjdwp:transport=dt_socket,address=8001,server=y,suspend=y -jar [JAR NAME HERE]
 *  
 */

public class RotateMatixBy90 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//dimension of the square matrix
		System.out.println("What is the dimension of your matrix?");
		int matrixdim = input.nextInt();

		double [][] matrix = new double[matrixdim][matrixdim];

		//content of the matrix
		System.out.println("Enter the value for the matrix:");
		for(int i=0; i<matrixdim;i++){
			for(int j=0; j<matrixdim; j++){
				matrix[i][j] = input.nextDouble();

			}
		}

		//displaying the matrix
		System.out.println("Value for the matrix is:");
		for(int i=0; i<matrixdim;i++){
			for(int j=0; j<matrixdim; j++){
				System.out.print(matrix[i][j] + "->");
			}
			System.out.println();
		}


		TwoDimensionalMatrix matrix2 = new TwoDimensionalMatrix(matrix, matrixdim);

		double[][] matrixRotated;

		matrixRotated = matrix2.rotateBy90();

		System.out.println("Value for the Rotated Matrix is:");
		for(int i=0; i<matrixdim;i++){
			for(int j=0; j<matrixdim; j++){
				System.out.print(matrixRotated[i][j] + "->");
			}
			System.out.println();
		}




		input.close();
	}

	
}


