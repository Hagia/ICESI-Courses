package archisoft.matrix;

import org.osoa.sca.annotations.Service;

@Service
public interface IMatrixOperation {
	
	public <T> void rotate(T[][] matrix, double phi);

}
