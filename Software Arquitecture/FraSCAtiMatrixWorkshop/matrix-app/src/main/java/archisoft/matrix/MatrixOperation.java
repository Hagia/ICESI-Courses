package archisoft.matrix;

public class MatrixOperation implements IMatrixOperation{
	
	public MatrixOperation() {
		System.out.println("Server created");
	}

	public <T> void rotate(T[][] matrix, double phi) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}

}
