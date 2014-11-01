package com.shekhar.otherProblems;

import java.util.Scanner;

public class RotateMatixBy90 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the dimension of your matrix?");
		int matrixdim = input.nextInt();

		double [][] matrix = new double[matrixdim][matrixdim];
		matrix[0][0] =10.33;

		System.out.println("Enter the value for the matrix:");
		for(int i=0; i<matrixdim;i++){
			for(int j=0; j<matrixdim; j++){
				matrix[i][j] = input.nextInt();

			}
		}


		System.out.println("Value for the matrix is:");
		for(int i=0; i<matrixdim;i++){
			for(int j=0; j<matrixdim; j++){
				System.out.print(matrix[i][j] + "->");
			}
			System.out.println();
		}


		TwoDimensionalMatrix matrix2 = new TwoDimensionalMatrix(matrix, matrixdim);

		double[][] matrixRotated;// = new double[matrixdim][matrixdim];

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


