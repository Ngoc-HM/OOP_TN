public class vidu6_6_Matrices {
        public static void main(String[] args) {
            int rows = 2, columns = 4;
            //Khai báo hai ma trận dưới dạng mảng đa chiều
            int[][] MatrixA = {{1, 1, 1, 1}, {2, 3, 5, 2}};
            int[][] MatrixB = {{2, 3, 4, 5}, {2, 2, 4, -4}};
        /* Khai báo một tổng ma trận, đó sẽ là tổng của MatrixA và MatrixB,
            ma trận tổng sẽ có cùng các hàng và cột như các ma trận đã cho.
         */
            int[][] sum = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    sum[i][j] = MatrixA[i][j] + MatrixB[i][j];
                }
            }
            //Hiển thị ma trận tổng
            System.out.println("Ma trận tổng của hai ma trận đã cho là: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(sum[i][j] + "    ");
                }
                System.out.println();
            }
    }
}
