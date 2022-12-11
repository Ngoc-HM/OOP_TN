import java.util.Scanner;
public class vidu6_4 {

    // kiểm tra xem năm nhập vào có phải năm nhuận hay không
    public static int KiemtraNam (int nam){
        // nếu năm nhuận thì bằng 1, không nhuận thì bằng 0
            if(nam>400) 
                {   if(nam%100==0 && nam%400==0 && nam%4==0) 
                        return 1;
                }
            else if(nam%4==0) return 1;
    return 0;
    }
    // hàm check chuẩn mực nhập vào
    public static int chuyendoi(String t){
        if (t.equals("Jan.") || t.equals("Jan") || t.equals("January") || t.equals("1")) return 1;
        if (t.equals("Feb.") || t.equals("Feb") || t.equals("February") || t.equals("2")) return 2;
        if (t.equals("Mar.") || t.equals("Mar") || t.equals("March") || t.equals("3")) return 3;
        if (t.equals("Apr.") || t.equals("Apr") || t.equals("April") || t.equals("4")) return 4;
        if (t.equals("May")  || t.equals("May") || t.equals("5")) return 5;
        if (t.equals("Jun.") || t.equals("Jun") || t.equals("June") || t.equals("6")) return 6;
        if (t.equals("Jul.") || t.equals("Jul") || t.equals("July") || t.equals("7")) return 7;
        if (t.equals("Aug.") || t.equals("Aug") || t.equals("August") || t.equals("8")) return 8;
        if (t.equals("Sep.") || t.equals("Sep") || t.equals("September") || t.equals("9")) return 9;
        if (t.equals("Oct.") || t.equals("Oct") || t.equals("October") || t.equals("10")) return 10;
        if (t.equals("Nov.") || t.equals("Nov") || t.equals("November") || t.equals("11")) return 11;
        if (t.equals("Dec.") || t.equals("Dec") || t.equals("December") || t.equals("12")) return 12;
        return 0;
    }


    public static void main(String[] args) { 
    int nam; String thang;
    Scanner sc = new Scanner(System.in);
    // nhập vào tháng
    do
    {
        System.out.print("Nhap thang ");
        thang = sc.nextLine();
    }while(chuyendoi(thang)>12 || chuyendoi(thang)<1 );
    // nhập vào năm
    do{
        System.out.print("Nhap vao nam: (nam>0) ");
        nam = sc.nextInt();
    } while(nam<=0);
    // in ra tháng
    switch (chuyendoi(thang)) {
        case 1: 
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:System.out.println(thang + "/" + nam + " co 31 ngay ");  break;
        case 4:
        case 6:
        case 9:
        case 11:System.out.println(thang + "/" + nam + " co 30 ngay ");  break;
    }
    //kiểm tra giá trị
    if(chuyendoi(thang)==2)
      if(KiemtraNam(nam)==1) System.out.println(thang + "/" + nam + " co 29 ngay ");
       else System.out.println(thang + "/" + nam + " co 28 ngay ");
   }

}
