package archisoft.data;

public class Main {
	
	public static void main(String[] args) {
		double[][] m = DataLoad.loadMatrix("./data-app/src/main/resources/matrix_b.txt");
		for (int i = 0; i < m.length; i ++) {
			for (int j = 0; j < m[0].length; j ++) {
				System.out.println(m[i][j]);
			}
		}
	}

}
