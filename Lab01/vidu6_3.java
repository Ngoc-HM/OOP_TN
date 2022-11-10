import java.util.Scanner;
public class vidu6_3 {

public static void insao(int i){
    for (int j = 1; j <= i ;j++) {
     for(int k = 1; k <= j ; k++)
        System.out.print("*");
        System.out.print("\n");
    }

}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap vao chieu cao cua tam gia n sao: ");
    int n = sc.nextInt();
    insao(n);
}

}
