package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.menu.*;

import javax.naming.LimitExceededException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AimsMenuGui extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JButton createBtn;
    JButton addBtn;
    JButton deleteBtn;
    JButton displayBtn;
    JButton thresholdsBtn;
    JButton luckyBtn;
    JButton exitBtn;
    JLabel orderIdBtn;
    JLabel dateLb;
    JComboBox<Integer> orderIdList = new JComboBox<Integer>();
    int orderId = 0;
    int minItem = Order.LUCKY_MIN_NUMBER_OF_ITEMS;
    float minTotalCost = Order.LUCKY_MIN_TOTAL_COST;
    int numOrder = 0;
    int luckyTimes = 0;
    private List<Order> orders = new ArrayList<Order>();
    public AimsMenuGui(JFrame jFrame) {
    	 setVisible(true);
    	// create Button
    	createBtn = new JButton("Tạo đơn hàng mới");
        addBtn = new JButton("Thêm mặt hàng");
        deleteBtn = new JButton("Xóa mặt hàng");
        displayBtn = new JButton("Hiển thị các mặt hàng");
        thresholdsBtn = new JButton("Cài đặt ngưỡng");
        luckyBtn = new JButton("Lucky nàooooo");
        exitBtn = new JButton("Thoát");
       
        // set for Menu Frame 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500)) / 2;
        int y = (int) ((dimension.getHeight() - 800)) / 2;
        setLocation(x, y);
        setVisible(true);
        setTitle("Aims System");
        
        // set for Date label and Field
        JLabel dateField = new JLabel();
        dateLb = new JLabel("Ngày:");
        dateLb.setSize(50,25);
        dateLb.setLocation(20,10);
        add(dateLb);
        dateLb.setVisible(true);
        dateField.setSize(200, 30);
        dateField.setLocation(180,10);
        add(dateField);
        
        // set for Order ID box 
        orderIdBtn = new JLabel("HĐ số:");
        orderIdBtn.setSize(100,20);
        orderIdBtn.setLocation(20,55);
        add(orderIdBtn);
        
        orderIdList.setSize(60,30);
        orderIdList.setLocation(80,35);
        add(orderIdList);
        orderIdList.addActionListener (new ActionListener() {
            // change order displayed when changing order id
            @Override
            public void actionPerformed(ActionEvent e) {
                if (orderIdList.getSelectedIndex() != -1) {
                    orderId = orderIdList.getSelectedIndex();
                }
            }
        });
        
        // set for Create Button
        createBtn.setSize(300, 60);
        createBtn.setLocation(100, 70);
        createBtn.setFocusPainted(false);
        createBtn.addActionListener(e -> {
        	if (orderIdList.getItemCount() == Order.MAX_LIMITED_ORDERS) {
        		  JOptionPane.showMessageDialog(null,"Giỏ hàng đã đầy!\n" +
                             "Không thể tạo đơn hàng mới.","\n Warning: ", JOptionPane.WARNING_MESSAGE);
            } 
        	if (numOrder < Order.MAX_LIMITED_ORDERS) {
                try {
                	numOrder++;
                	createOrder();
                	dateField.setText(orders.get(orderId).getDateOrdered().toString());
                	dateField.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Tạo đơn hàng mới thành công với ID: " + Integer.toString(numOrder));
                } catch (LimitExceededException e1) {
                    e1.printStackTrace();
                }                    
     		   orderIdList.addItem(numOrder);
            }
        	
        });
        add(createBtn);

        //set for Thresholds Button  
        thresholdsBtn.setSize(300, 60);
        thresholdsBtn.setLocation(100, 150);
        thresholdsBtn.setFocusPainted(false);
        thresholdsBtn.addActionListener(e -> new AddThresholdsDialog(orders.get(orderId)));
        add(thresholdsBtn);

        
        // set for Add item Button
        addBtn.setSize(300, 60);
        addBtn.setLocation(100, 230);
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(e -> {
            if (orders.get(orderId) != null) {
                // Create Frame Dialog
                new MenuAddMedia(orders.get(orderId));
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng tạo đơn hàng trước!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(addBtn);

        // set for Delete item Button
        deleteBtn.setSize(300, 60);
        deleteBtn.setLocation(100, 310);
        deleteBtn.setFocusPainted(false);
        deleteBtn.addActionListener(e -> {
            if (orders.get(orderId) != null) {
                String strID = JOptionPane.showInputDialog(null,
                        "Vui lòng nhập ID của mục bạn muốn xóa: ",
                        "Xóa ID",
                        JOptionPane.INFORMATION_MESSAGE);
                int id = Integer.parseInt(strID);
                if (orders.get(orderId).removeMedia(id) != null) {
                    JOptionPane.showMessageDialog(null, "Xóa mục có ID " + strID + " Thành Công !");
                } else {
                    JOptionPane.showMessageDialog(null, "Không tồn tại mục có ID" + strID, "\n Warning: ", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng tạo đơn hàng trước!", "\n Warning: ", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(deleteBtn);

        // set for Display item Button
        displayBtn.setSize(300, 60);
        displayBtn.setLocation(100, 390);
        displayBtn.setFocusPainted(false);
        displayBtn.addActionListener(e -> {
            if (orders.get(orderId) != null) {
                // Create frame of dialog
                JDialog displayDialog = new JDialog();
                displayDialog.setSize(600, 400);
                displayDialog.setLayout(null);
                displayDialog.setResizable(false);

                Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();
                int x1 = (int) ((dimension1.getWidth() - 600)) / 2;
                int y1 = (int) ((dimension1.getHeight() - 400)) / 2;
                displayDialog.setLocation(x1, y1);

                displayDialog.setVisible(false);
                displayDialog.setModal(true);
                displayDialog.setTitle("các mặt hàng đã đặt");

                String[] column_names = {"ID", "Type", "Title", "Category", "Cost($)"};
                List<Media> items;
                items = orders.get(orderId).getItemsOrdered();
                Collections.sort(items);
                DefaultTableModel model = new DefaultTableModel(null, column_names);
                JTable table = new JTable(model);
                float cost = 0;
                Media temp = null;
                for (Media media : items) {
                    String typeString;
                    if (media instanceof Book)
                        typeString = "Book";
                    else if (media instanceof DigitalVideoDisc) {
                        typeString = "DVD";
                    } else {
                        typeString = "CD";
                    }
                    if (media == temp) {
                        cost = media.getCost();
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), 0.0});
                    } else {
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), media.getCost()});
                    }
                }

                model.addRow(new Object[]{"", "", "", "tổng: ", orders.get(orderId).totalCost() - cost});
                table.setSize(500, 300);
                table.setLocation(50, 30);
                displayDialog.setLayout(new BorderLayout());
                displayDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
                displayDialog.add(table, BorderLayout.CENTER);
                TableColumn column;
                for (int i = 0; i < 5; i++) {
                    column = table.getColumnModel().getColumn(i);
                    if (i == 0) {
                        column.setPreferredWidth(50);
                    }
                    if (i == 1) {
                        column.setPreferredWidth(50);
                    }
                    if (i == 2) {
                        column.setPreferredWidth(200);
                    }
                    if (i == 3) {
                        column.setPreferredWidth(150);
                    }
                    if (i == 4) {
                        column.setPreferredWidth(50);
                    }

                }
                displayDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "hãy tạo đơn hàng trước!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(displayBtn);
        
        //set for Lucky Button  
        luckyBtn.setSize(300, 60);
        luckyBtn.setLocation(100, 470);
        luckyBtn.setFocusPainted(false);
        add(luckyBtn);
       
        luckyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            	if (orders.get(orderId) != null) {
            		if (luckyTimes == 1) {
            			JOptionPane.showMessageDialog(null,"bạn đã chơi Lucky rồi, hẹn bạn lần sau"
                               );
                        return;
            		}
            	     if (orders.get(orderId).totalCost() < Order.LUCKY_MIN_TOTAL_COST) {
                     	JOptionPane.showMessageDialog(null,"tổng tiền đặt hàng phải có ít nhất " + Order.LUCKY_MIN_TOTAL_COST +
                                 "$ to get a vật phẩm may mắn!");
                         return;
                     }
                     
                     if (orders.get(orderId).getItemsOrdered().size() < Order.LUCKY_MIN_NUMBER_OF_ITEMS) {
                     	JOptionPane.showMessageDialog(null,"đơn đặt hàng phải có ít nhất " + Order.LUCKY_MIN_NUMBER_OF_ITEMS +
                                 " vật phẩm để được tham gia Lucky!");
                         return;
                     }
                     
                     // set the Lucky Item frame
                     JFrame luckyFrame = new JFrame();
                     luckyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     
                     JTextArea textLucky = new JTextArea();
                     textLucky.setEditable(false);
                     textLucky.setAlignmentX(CENTER_ALIGNMENT);
                     textLucky.setAlignmentY(CENTER_ALIGNMENT);
                     float luckyItemValue = orders.get(orderId).getALuckyItem();
                     if (luckyItemValue == 0.00f) {
                         luckyFrame.setTitle("lần sau nha!");
                         textLucky.setText(" Chúc may mắn lần sau!");
                     } else {
                         luckyFrame.setTitle("Chúc mừng!");
                         textLucky.setText(" bạn đã giành được vật phẩm may mắn với giá " + luckyItemValue + "$ !");
                     }
                     luckyTimes = 1;
                     luckyFrame.getContentPane().add(textLucky);
                     luckyFrame.setBounds(680, 400, 300, 200);
                     luckyFrame.setVisible(true);
         
                 } else {
                	 JOptionPane.showMessageDialog(null, "Vui lòng tạo đơn hàng trước!", "\n Warning: ", JOptionPane.WARNING_MESSAGE);
                 }
            	}
           
        });

        // set for exit Button
        exitBtn.setSize(300, 60);
        exitBtn.setLocation(100, 550);
        exitBtn.setFocusPainted(false);
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);

       
    }

    public void createOrder() throws LimitExceededException {
        int newOrderId = orders.size();
        
        try {
            orders.add(new Order(newOrderId));
        } catch (LimitExceededException e) {
            throw e;
        }
    }
    public static void main(String[] args) {
        new AimsMenuGui(new JFrame());
    }
}