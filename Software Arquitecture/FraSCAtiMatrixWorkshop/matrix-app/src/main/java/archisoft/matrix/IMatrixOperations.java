package archisoft.matrix;

import org.osoa.sca.annotations.Service;

@Service
public interface IMatrixOperations {
	
	public double[][] mulMat(double[][] matrixA, double[][] matrixB);

}
