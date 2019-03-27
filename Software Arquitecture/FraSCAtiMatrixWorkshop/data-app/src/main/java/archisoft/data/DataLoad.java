package archisoft.data;

import java.io.*;

public class DataLoad {

    public static double[][] loadMatrix(String path) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            int height = Integer.parseInt(br.readLine());
            int width = Integer.parseInt(br.readLine());

            double[][] matrix = new double[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = Double.parseDouble(br.readLine());
                }
            }

            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}