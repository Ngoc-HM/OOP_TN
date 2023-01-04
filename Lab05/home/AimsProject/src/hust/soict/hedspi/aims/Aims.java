package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.exceptions.LimitExceedException;
import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.Track;

import java.util.Scanner;

import javax.naming.LimitExceededException;

public class Aims {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int case1 = 0;
        Order anOrder = null;
        while (true){
            showMenu();
            String line = sc.nextLine();
            switch (line){
                case "1":
                    try {
                        anOrder = new Order();
                        System.out.println("tạo mới thành công");
                        case1 = 1;
                        break;
                    } catch (LimitExceedException e) {
                        e.printStackTrace();
                    }
                case "2":
                    if(case1 == 0) {
                        System.err.println("Vui lòng tạo đơn hàng mới trước khi thêm bất cứ thứ gì! ");
                        break;
                    }
                    showMenuMedia();
                    String type = sc.nextLine();
                    switch (type){
                        case "1":
                            addBookToOrder(anOrder,sc);
                            break;
                        case "2":
                            addDvdToOrder(anOrder,sc);
                            break;
                        case "3":
                            addCdToOrder(anOrder,sc);
                            break;
                        case "0":
                            System.out.println("Thoát khỏi menu!");
                            break;
                        default:
                            System.out.println("Lỗi cú pháp, thoát khỏi menu");
                            break;
                    }
                    break;
                case "3":
                    if(case1 == 0) {
                        System.err.println("Danh sách trống!");
                        break;
                    }
                    System.out.println("nhập ID muốn xóa ");
                    int id = Integer.parseInt(sc.nextLine());
                    if(anOrder.searchById(id) == null)
                        System.out.println("không tìm thấy ID!");
                    else {
                        anOrder.removeMedia(id);
                        System.out.println("xóa!");
                    }
                    break;
                case "4":
                    if(case1 == 0) {
                        System.err.println("Danh sách trống!");
                        break;
                    }
                    System.out.println("các mặt hàng danh sách đã đặt");
                    anOrder.display();
                    break;
                case "0":
                    sc.close();
                    System.out.println("thoát!");
                    return;
                default:
                    System.err.println("Lỗi cú pháp, Vui lòng nhập lại");
                    break;
            }
        }
    }
    public static void showMenu(){
        System.out.println("Ứng dụng quản lí đơn hàng");
        System.out.println("_____________________");
        System.out.println("1. Tạo đơn hàng mới");
        System.out.println("2. Thêm đồ vào đơn hàng");
        System.out.println("3. Xóa mặt hàng theo ID");
        System.out.println("4. Hiển thị danh sách");
        System.out.println("0. thoát");
        System.out.println("_____________________");
        System.out.println("hãy chọn các số sau: 0-1-2-3-4 \n");

    }
    public static void showMenuMedia() {
        System.out.println("\tChọn mặt hàng ");
        System.out.println("\t_____________________");
        System.out.println("\t1. Book");
        System.out.println("\t2. DVD");
        System.out.println("\t3. CD");
        System.out.println("\t0. thoát");
        System.out.println("\t_____________________");
        System.out.println("\thãy chọn 1 trong số: 0-1-2-3 \n");
    }
    private static void addDvdToOrder(Order anOrder, Scanner sc) {
        int id;
        do {
            System.out.printf("\t\tNhập ID: ");
            id = Integer.parseInt(sc.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tID này đã tồn tại, nhập ID khác");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tNhập Tiêu đề: ");
        String title = sc.nextLine();
        System.out.printf("\t\tNhập Thể loại: ");
        String category = sc.nextLine();
        System.out.printf("\t\tNhập Tác giả: ");
        String director = sc.nextLine();
        System.out.printf("\t\tNhập Giá : ");
        float cost = sc.nextFloat();
        System.out.printf("\t\tNhập Chiều dài: ");
        int length = sc.nextInt();
        sc.nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category,cost, director, length);
        String choice;
        do{
            System.out.printf("\t\t\tBạn muốn nghe thử không (yes|no): ");
            choice = sc.nextLine();
            if(choice.equals("yes")){
                try {
                    dvd.play();
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
            }
            else if(choice.equals("no")){}
            else
                System.err.println("Lỗi cú pháp");
        }while(!choice.equals("no"));
        try {
            anOrder.addMedia(dvd);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
    }
    private static void addCdToOrder(Order anOrder,Scanner sc) {
        int id;
        do {
            System.out.printf("\t\tNhập ID: ");
            id = Integer.parseInt(sc.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tID này đã tồn tại, nhập ID khác");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tNhập Tiêu đề: ");
        String title = sc.nextLine();
        System.out.printf("\t\tNhập Thể loại: ");
        String category = sc.nextLine();
        System.out.printf("\t\tNhập Thể loại: ");
        String artist = sc.nextLine();
        System.out.printf("\t\tNhập giá : ");
        float cost = sc.nextFloat();
        sc.nextLine();
        System.out.printf("\t\tNhập số danh sách theo dõi : ");
        int count = sc.nextInt();
        while(count <= 0) {
            System.err.println("\t\tSố lượng tác giả phải có >= 0. vui lòng nhập lại");
            System.out.printf("\t\tNhập số danh sách theo dõi  ");
            count = sc.nextInt();
        }
        sc.nextLine();
        CompactDisc cd = new CompactDisc(id, title, category,cost ,artist);
        Track track = null;
        String titleTrack;
        int lengthTrack;
        for(int i = 0; i < count; i++) {
            System.out.println("***\t\t\tTheo dõi " + (i+1));
            System.out.printf("\t\t\tNhập tên bản nhạc: ");
            titleTrack = sc.nextLine();
            System.out.printf("\t\t\tNhập Độ dài của bản nhạc: ");
            lengthTrack = sc.nextInt();
            track = new Track(titleTrack, lengthTrack);
            cd.addTrack(track);
            sc.nextLine();
        }
        String choice;
        do {
            System.out.printf("\t\t\tbạn có muốn play ? (yes|no): ");
            choice = sc.nextLine();
            switch (choice) {
                case "yes":
                    System.out.println("===============================");
                    try {
                        cd.play();
                    } catch (PlayerException e) {
                        e.printStackTrace();
                    }
                    System.out.println("===============================");
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Lỗi cú pháp!");
            }
        } while (choice.equals("no"));
        try {
            anOrder.addMedia(cd);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
    }
    private static void addBookToOrder(Order anOrder,Scanner sc) {
        int id;
        do {
            System.out.printf("\t\tNhập ID: ");
            id = Integer.parseInt(sc.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tID này đã tồn tại, nhập ID khác");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tNhập Tiêu đề: ");
        String title = sc.nextLine();
        System.out.printf("\t\tNhập Thể loại: ");
        String category = sc.nextLine();
        System.out.printf("\t\tNhập giá : ");
        float cost = Float.parseFloat(sc.nextLine());
        Book book = new Book(id, title, category, cost);
        int numOfAuthors = 0;
        do {
            System.out.printf("\t\tNhập số tác giả ");
            numOfAuthors = Integer.parseInt(sc.nextLine());
            if(numOfAuthors <= 0)
                System.err.println("\t\tsố lượng tác giả phải >= 0 vui lòng nhập lại");
        }while (numOfAuthors <=0);
        for(int i = 0 ; i< numOfAuthors ; i++) {
            System.out.printf("\t\tNhập tên của tác giả ");
            String author = sc.nextLine();
            book.addAuthor(author);
        }
        try {
            anOrder.addMedia(book);
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
      
      
        
    }
	  
}

