package archisoft.matrix;

import org.osoa.sca.annotations.Reference;

public class MatrixClient implements Runnable{
	
	@Reference(required = true)
	private IMatrixOperation matrixOperation;
	
	private static Integer[][] matrix = new Integer[2][2];
	
	public MatrixClient() {
		System.out.println("Cliente created");
	}
	
	public void setMatrixOperation(IMatrixOperation matrixOperataion) {
		this.matrixOperation = matrixOperataion;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[1][0] = 1;
		matrix[1][1] = 1;
		matrixOperation.rotate(matrix, 90);
	}

}
