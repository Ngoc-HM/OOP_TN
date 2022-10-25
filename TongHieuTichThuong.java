
import javax.swing.JOptionPane;

public class TongHieuTichThuong {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Ket Qua Can Tim : \n";
        // nhập 2 số 
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        // double num1 = Double.parseDouble (strNum1);
        // double num2 = Double.parseDouble (strNum2);
        double Tong = Double.parseDouble(strNum1) + Double.parseDouble(strNum2) ;
        double Hieu = Double.parseDouble(strNum1) - Double.parseDouble(strNum2) ;
        double Tich = Double.parseDouble(strNum1) * Double.parseDouble(strNum2) ;
        double Thuong = Double.parseDouble(strNum1) / Double.parseDouble(strNum2) ;
        strNotification += strNum1 + " + " + strNum2 + " = " + Tong + "\n";
        strNotification += strNum1 + " - " + strNum2 + " = " + Hieu + "\n";
        strNotification += strNum1 + " * " + strNum2 + " = " + Tich + "\n";
        strNotification += strNum1 + " / " + strNum2 + " = " + Math.ceil(Thuong * 1000) / 1000 + "\n";
        JOptionPane.showMessageDialog(null, strNotification, "Ket Qua", JOptionPane.INFORMATION_MESSAGE);
    }
}
