package com.shekhar.otherProblems;


public class TwoDimensionalMatrix {

	double [][] matrix = null;
	int size;

	public TwoDimensionalMatrix(double[][] matrix, int size){
		this.matrix = matrix;
		this.size = size;
/*		double[][] elements = new double[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				elements[i][j] = matrix[i][j];
			}
		}
*/
	}

	public double[][] rotateBy90(){
		double[][] matrix90 = new double [size][size];
		try{
			for(int i=0; i<size ; i++){
				for(int j=0; j<size; j++){
					matrix90[i][j] = matrix[size-j-1][i];
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return matrix90;
	}
	
}

