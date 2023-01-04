package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.exceptions.LimitExceedException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.Random;

import javax.naming.LimitExceededException;
public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private static final int LUCKY_PROBABILITY = 8; 
    public static final int LUCKY_MIN_NUMBER_OF_ITEMS = 3;
    public static final float LUCKY_MIN_TOTAL_COST = 100.00f;
    private static final float LUCKY_LEVEL_1 = 300.00f;
    private static final float LUCKY_LEVEL_2 = 1000.00f;
    private static final float LUCKY_LEVEL_3 = 5000.00f;
    private static final float LUCKY_MIN_VALUE = 1.00f;
    private static final float LUCKY_MAX_VALUE_1 = 30.00f;
    private static final float LUCKY_MAX_VALUE_2 = 100.00f;
    private static final float LUCKY_MAX_VALUE_3 = 500.00f;
    private static final float LUCKY_MAX_VALUE_4 = 1000.00f;
    private static int nbOrders = 0;
    private float thresholdsTotal = 300f;
    private float thresholdsSale = 100f;
    private int thresholdsItems = 3;
    private int thresholdsNumOfOrders = 5;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private MyDate dateOrdered;
    private int id;
    
    public Order(int id) throws LimitExceededException {
        if (nbOrders < MAX_LIMITED_ORDERS) {
            this.id = id;
            this.dateOrdered = new MyDate();
            this.itemsOrdered = new ArrayList<Media>();
            nbOrders++;
            if (nbOrders == MAX_LIMITED_ORDERS) {
                System.out.println("\nThe Number of orders reached max! Please purchase your orders!\n");
            }
        } else {
            throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
        }
    }
    
    public Order() throws LimitExceedException {
        if (nbOrders < MAX_LIMITED_ORDERS) {
            dateOrdered = new MyDate();
            nbOrders++;
        } else {
            throw new LimitExceedException("ERROR: The number of orders has reached its limit!");
        }
    }
    public void setThresholds(float thresholdsTotal, int thresholdsItems) {
        this.thresholdsTotal = thresholdsTotal;
        this.thresholdsItems = thresholdsItems;
    }
    public float getThresholdsTotal() {
        return thresholdsTotal;
    }

    public void setThresholdsTotal(float thresholdsTotal) {
        this.thresholdsTotal = thresholdsTotal;
    }

    public float getThresholdsSale() {
        return thresholdsSale;
    }

    public void setThresholdsSale(float thresholdsSale) {
        this.thresholdsSale = thresholdsSale;
    }

    public int getThresholdsNumOfOrders() {
        return thresholdsNumOfOrders;
    }

    public void setThresholdsNumOfOrders(int thresholdsNumOfOrders) {
        this.thresholdsNumOfOrders = thresholdsNumOfOrders;
    }
    
    public MyDate getDateOrdered() {
        return dateOrdered;
    }
    
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public boolean addMedia(Media media) throws LimitExceededException {
    	 if (this.itemsOrdered.size() < MAX_NUMBERS_ORDERED)  {
             this.itemsOrdered.add(media);
             int currentOrderSize = this.itemsOrdered.size();
             
             System.out.println("Item \"" + media.getTitle() + "\" has been added to Order! " +
                                "The number of items in order now is " + currentOrderSize + ".");
             if (currentOrderSize == MAX_NUMBERS_ORDERED) {
                 System.out.println("The Order is full! Lets purchase your Order!");
             }
             
             return true;
         } else {
             throw new LimitExceededException("ERROR: The number of items in the order has reached its limit!");
         }
    }
    
    public Media removeMedia(Media media) throws IllegalStateException, IllegalArgumentException {
        if (this.itemsOrdered.size() != 0 && this.itemsOrdered.contains(media)) {
            System.out.println("input id : " + media.getId());
            System.out.println("size : " + this.itemsOrdered.size());
            System.out.println(this.itemsOrdered.contains(media));
            
            // reset id of the item(s) behind the removed item
            int removeMediaId = this.itemsOrdered.indexOf(media);
            for (int i = removeMediaId + 1; i < this.itemsOrdered.size(); i++) {
                this.itemsOrdered.get(i).setId(i - 1);
            }
            
            Media removedMedia = this.itemsOrdered.get(removeMediaId);
            
            this.itemsOrdered.remove(media);

            System.out.println("Item \"" + media.getTitle() + "\" has been removed from Order! " +
                    "The number of items in order now is " + this.itemsOrdered.size() + ".");
            
            return removedMedia;
        } else if (this.itemsOrdered.size() == 0) {
            throw new IllegalStateException("ERROR: the order is empty!");
        } else {
            throw new IllegalArgumentException("ERROR: item not found!");
        }
    }
    public Media removeMedia(int mediaId) throws IllegalStateException, IllegalArgumentException {
        Media removedMedia = null;
        
        try {
            removedMedia = removeMedia(this.itemsOrdered.get(mediaId));
        } catch (IllegalStateException | IllegalArgumentException e) {
            throw e;
        }
        
        return removedMedia;
    }

    public Media searchById(int id){
        Media media =  this.itemsOrdered.stream().filter(o->o.getId()==id).findFirst().orElse(null);
        return media;
    }

    public float totalCost() {
        float cost = 0;
        for (Media o : itemsOrdered) {
            cost += o.getCost();
        }
        return cost;
    }
    
    public int getNumItem(){
        return itemsOrdered.size();
    }
    public void display(){
        this.itemsOrdered.forEach(o -> System.out.println(o.toString()));
    }

    // getALuckyItem()
    public float getALuckyItem() {
        if (this.itemsOrdered.size() < thresholdsItems) {
            return 0.00f;
        }       
        // the condition can be adjusted but must be greater than the default condition
        if (thresholdsTotal < LUCKY_MIN_TOTAL_COST) {
        	thresholdsTotal = LUCKY_MIN_TOTAL_COST;
        }       
        if (this.totalCost() < thresholdsTotal) { 
            return 0.00f;
        }   
        int luckyRatio = getRandomNumber(1, 10);
        
        if (luckyRatio < LUCKY_PROBABILITY) {
            return 0.00f;
        }
        
        // get the max value of lucky item
        float maxLuckyValue = 0.00f;
        if (this.totalCost() < LUCKY_LEVEL_1) {         // total cost = 100.00 ~ 299.99 $
            maxLuckyValue = LUCKY_MAX_VALUE_1;
        } else if (this.totalCost() < LUCKY_LEVEL_2) {  // total cost = 300.00 ~ 999.99 $
            maxLuckyValue = LUCKY_MAX_VALUE_2;
        } else if (this.totalCost() < LUCKY_LEVEL_3) {  // total cost = 1000.00 ~ 4999.99 $
            maxLuckyValue = LUCKY_MAX_VALUE_3;
        } else {                                        // total cost >= 5000.00 $
            maxLuckyValue = LUCKY_MAX_VALUE_4;
        }
        
        // random the lucky item value
        Random rand = new Random();
        float randomValue = LUCKY_MIN_VALUE + rand.nextFloat() * (maxLuckyValue - LUCKY_MIN_VALUE);
        float luckyItemValue = round2DecimalPoints(randomValue);
        
        // inform the user
        System.out.println("Congratulation! You won a lucky item that costs " + luckyItemValue + "$ !");
        
        return luckyItemValue;
    }
    float round2DecimalPoints(float floatNumber) {
        return Math.round(floatNumber * 100.0f) / 100.0f;
    }
    
    private int getRandomNumber(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}

