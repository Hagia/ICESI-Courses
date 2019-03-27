package archisoft.data;

import archisoft.matrix.*;

import org.osoa.sca.annotations.Reference;

public class MatrixClient implements Runnable{
	
	@Reference(required = true)
	private IMatrixOperations matrixOperation;
		
	public MatrixClient() {
		System.out.println("Cliente created");
	}

	public void run() {
		// TODO Auto-generated method stub
		double[][] matrixA = DataLoad.loadMatrix("./resources/matrix_a.txt");
		double[][] matrixB = DataLoad.loadMatrix("./resources/matrix_b.txt");
//		double[][] matrixC = matrixOperation.mulMat(matrixA, matrixB);
	}

}
