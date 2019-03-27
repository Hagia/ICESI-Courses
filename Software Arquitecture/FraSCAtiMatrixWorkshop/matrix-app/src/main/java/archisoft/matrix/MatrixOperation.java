package archisoft.matrix;

public class MatrixOperation implements IMatrixOperations{
	
	public MatrixOperation() {
		System.out.println("Server created");
	}

	public double[][] mulMat(double[][] matrixA, double[][] matrixB){
		
		int width = matrixA.length;
		int height = matrixB.length;
		double[][] matrixC = new double[width][height];

		for(int i = 0; i < width; i++){
			for(int j = 0; i < height; j++){
				for(int k = 0; k < width; k ++){
					matrixC[i][j] += matrixA[j][k] + matrixB[k][j];
				}
			}
		}

		return matrixC;
	}

}
