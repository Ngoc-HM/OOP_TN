package hust.soict.hedspi.aims.utils;
import java.time.LocalDate;

public class MyDate {

    private int day;
    private int month;
    private int year;
    
    // constructor
    public MyDate() {
        LocalDate today = LocalDate.now();
        
        this.day = today.getDayOfMonth();
        this.month = today.getMonthValue();
        this.year = today.getYear();
    }
    
    public MyDate(int day, int month, int year) {
        checkDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public MyDate(String date) {
        int[] intDate = extractIntDateFromString(date.trim());

        this.day = intDate[0];
        this.month = intDate[1];
        this.year = intDate[2];
    }
    
    public MyDate(String inputDay, String inputMonth, String inputYear) {
        int day = getDayValue(inputDay.trim());
        int month = getMonthValue(inputMonth.trim());
        int year = getYearValue(inputYear.trim());
        checkDate(day, month, year);
        
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    // getter & setter
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        checkDate(day, this.month, this.year);
        this.day = day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int month) {
        checkDate(this.day, month, this.year);
        this.month = month;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        checkDate(this.day, this.month, year);
        this.year = year;
    }
    
    // check validity of day, month, year
    private void checkDate(int day, int month, int year) {
        // check valid year
        if (year < 1) {
            throw new ArithmeticException("Invalid year");
        }
        
        // check valid day > 1
        if (day < 1) {
            throw new ArithmeticException("Invalid day");
        }
        
        // check valid day & month
        switch(month) {
        case 1: case 3: case 5: case 7:
        case 8: case 10: case 12:
            if (day > 31) {
                throw new ArithmeticException("Invalid day");
            }
            break;
        case 4: case 6: case 9: case 11:
            if (day > 30) {
                throw new ArithmeticException("Invalid day");
            }
            break;
        case 2:
            if (day > 29 && isLeapYear(year) == true) {
                throw new ArithmeticException("Invalid day");
            } else if (day > 28 && isLeapYear(year) == false) {
                throw new ArithmeticException("Invalid day");
            }
            break;
        default:
            throw new ArithmeticException("Invalid month");
        }
    }
    
    // convert day from string to int
    public int getDayValue(String inputDay) {
        // null or empty str -> error
        if (inputDay == null || inputDay.equals("")) {
            throw new ArithmeticException("Invalid day string");
        }
        
        int day = 0;
        String[] tokens = inputDay.split("-"); // eg: "twenty-third" -> "twenty" & "third"
        String extraPart = ""; // eg: "thirteenth" -> "thir" & "teen", "thir" will be the extra part
        boolean isPartOfToken = false;
        int tailTokenLength = 0;
        
        if (tokens.length != 1 && tokens.length != 2) {
            throw new ArithmeticException("Invalid day string");
        } else if (tokens.length == 1) {
            // case 1st ~ 12th, 20th, 30th: no need for extra step
            // case 13th ~ 19th
            tailTokenLength = tokens[0].length();
            if (tailTokenLength > 6) {
                if (tokens[0].substring(tailTokenLength - 6).equals("teenth")) {
                    isPartOfToken = true;
                    // eg: "thirteenth" = 10 + 3
                    // 1. extraPart: "thir" -> "third"
                    extraPart += tokens[0].substring(0, tailTokenLength - 6); // eg: extraPart = "thir"
                    if (extraPart.equals("thir")) {
                        extraPart += "d"; // "thir" -> "third"
                    } else if (extraPart.equals("nine")) {
                        extraPart = "ninth"; // CANNOT extraPart += "th" to make "ninth" -> new String
                        // should have used class StringBuffer instead of String
                    } else {
                        extraPart += "th"; // eg: "fourteenth" -> "four" -> "fourth"
                    }
                    // 2. tokens[0]: "teenth" -> "tenth"
                    tokens[0] = "tenth"; 
                }
            }
        } else if (tokens.length == 2) {
            // case 21st ~ 29th, 31st
            isPartOfToken = true;
        }
        
        if (!extraPart.equals("")) {
            day += getIntFromDayToken(extraPart, isPartOfToken);
        }
        
        for (int i = 0; i < tokens.length; i++) {
            day += getIntFromDayToken(tokens[i], isPartOfToken);
            // System.out.println(tokens[i] + " " + extraPart);//
            // eg: "twenty-third"
            // "twenty" -> 20
            // "third" -> 3
            // day = 23
        }
        
        return day;
    }
    
    private int getIntFromDayToken(String token, boolean isPartOfToken) {
        switch(token) {
        case "first":   return 1;
        case "second":  return 2;
        case "third":   return 3;
        case "fourth":  return 4;
        case "fifth":   return 5;
        case "sixth":   return 6;
        case "seventh": return 7;
        case "eighth":  return 8;
        case "ninth":   return 9;
        case "tenth":   return 10;
        case "eleventh":return 11;
        case "twelfth": return 12;
        case "twenty":
            if (!isPartOfToken) {
                break;
            } // else -> return 20
        case "twentieth": return 20;
        case "thirty":
            if (!isPartOfToken) {
                break;
            } // else -> return 30
        case "thirtieth": return 30;
        default:
            throw new ArithmeticException("Invalid day string");
        }
        
        // string "twenty" but not as a part of a token -> error
        throw new ArithmeticException("Invalid day string");
    }
    
    // convert month from string to int
    public int getMonthValue(String month) {
        switch(month) {
        case "January": case "Jan.": case "Jan": case "1":   return 1;
        case "February": case "Feb.": case "Feb": case "2":  return 2;
        case "March": case "Mar.": case "Mar": case "3":     return 3;
        case "April": case "Apr.": case "Apr": case "4":     return 4;
        case "May": case "May.": case "5":                   return 5;
        case "June": case "Jun.": case "Jun": case "6":      return 6;
        case "July": case "Jul.": case "Jul": case "7":      return 7;
        case "August": case "Aug.": case "Aug": case "8":    return 8;
        case "September": case "Sep.": case "Sep": case "9": return 9;
        case "October": case "Oct.": case "Oct": case "10":  return 10;
        case "November": case "Nov.": case "Nov": case "11": return 11;
        case "December": case "Dec.": case "Dec": case "12": return 12;
        default:
            throw new ArithmeticException("Invalid month");
        }
    }
    
    // convert year from string to int: lv1 -> lv2 -> lv3 -> lv4
    public int getYearValue(String inputYear) {
        // null or empty string -> error
        if (inputYear == null || inputYear.equals("")) {
            throw new ArithmeticException("Invalid year string");
        }
        
        int yearPart1 = 0;
        int yearPart2 = 0;
        String[] tokens = inputYear.split(" "); // tokenLv1
        int tokensLength = tokens.length;
        
        if (tokensLength < 1 || tokensLength > 3) {
            throw new ArithmeticException("Invalid year string");
        }
        
        yearPart1 = getIntFromYearTokLv1(tokens[0]);
        if (tokensLength > 1) {
            yearPart1 *= 100;
            if (!tokens[1].equals("hundred")) {
                yearPart2 = getIntFromYearTokLv1(tokens[1]);
            } else if (tokensLength == 3) {
                yearPart2 = getIntFromYearTokLv1(tokens[2]);
                if (yearPart2 > 9) {
                    // eg: 2019 -> "twenty hundred ten" -> error
                    throw new ArithmeticException("Invalid year string");
                }
            }
        }
        
        int year = yearPart1 + yearPart2;
        
        return year;
    }
    
    private int getIntFromYearTokLv1(String tokenLv1) {
        String tokenLv2 = tokenLv1;
        String extraPart = "";
        int tokenLength = 0;
        
        // case 13 ~ 19
        tokenLength = tokenLv1.length();
        if (tokenLength > 4) {
            if (tokenLv2.substring(tokenLength - 4).equals("teen")) {
                extraPart += tokenLv2.substring(0, tokenLength - 4);
                // eg: "fifteen" = 10 + 5
                // 1. extraPart: "fif" -> "five"
                if (extraPart.equals("thir")) {
                    extraPart = "three";
                } else if (extraPart.equals("fif")) {
                    extraPart = "five";
                } else if (extraPart.equals("eigh")) {
                    extraPart += "t";
                }
                // 2. "teen" -> "ten"
                tokenLv2 = "ten"; 
                return getIntFromYearTokLv2(tokenLv2, extraPart);
            }
        }
        
        // case 21 ~ 29, 31 ~ 39, ...
        if (tokenLv2.indexOf('-') != -1) {
            String[] tokensLv2 = tokenLv2.split("-");
            return getIntFromYearTokLv2(tokensLv2[0], tokensLv2[1]);
        }
        
        // case 1 ~ 12, 20, 30,..., 90: no need extra step
        return getIntFromYearTokLv2(tokenLv2, "");
    }
    
    private int getIntFromYearTokLv2(String tokenLv2, String extraPart) {
        String tokenLv3 = tokenLv2;
        
        int intYearToken = 0;
        intYearToken += getIntFromYearTokLv3(tokenLv3);
        intYearToken += getIntFromYearTokLv3(extraPart);
        
        return intYearToken;
    }
    
    private int getIntFromYearTokLv3(String tokenLv3) {
        switch(tokenLv3) {
        case "":       return 0;
        case "one":    return 1;
        case "two":    return 2;
        case "three":  return 3;
        case "four":   return 4;
        case "five":   return 5;
        case "six":    return 6;
        case "seven":  return 7;
        case "eight":  return 8;
        case "nine":   return 9;
        case "ten":    return 10;
        case "eleven": return 11;
        case "twelve": return 12;
        case "twenty": return 20;
        case "thirty": return 30;
        case "forty":  return 40;
        case "fifty":  return 50;
        case "sixty":  return 60;
        case "seventy":return 70;
        case "eighty": return 80;
        case "ninety": return 90;
        default:
            throw new ArithmeticException("Invalid number string");
        }
    }
    
    // convert month from int to string
    public String getMonthName(int month, int mode) {
        String outputMonth;
        switch(month) {
        case 1: outputMonth = "Jan"; break;
        case 2: outputMonth = "Feb"; break;
        case 3: outputMonth = "Mar"; break;
        case 4: outputMonth = "Apr"; break;
        case 5: outputMonth = "May"; break;
        case 6: outputMonth = "Jun"; break;
        case 7: outputMonth = "Jul"; break;
        case 8: outputMonth = "Aug"; break;
        case 9: outputMonth = "Sep"; break;
        case 10: outputMonth = "Oct"; break;
        case 11: outputMonth = "Nov"; break;
        case 12: outputMonth = "Dec"; break;
        default:
            throw new ArithmeticException("Invalid month");
        }
        
        if (mode == 0) {
            // if mode == 0 -> return the abbreviation of the month
            return outputMonth;
        } else if (mode == 1) {
            // if mode == 1 -> return the abbreviation with the '.'
            outputMonth += ".";
            return outputMonth;
        } else if (mode == 2) {
            switch(month) {
            case 1: outputMonth += /*Jan*/"uary"; break;
            case 2: outputMonth += /*Feb*/"ruary"; break;
            case 3: outputMonth += /*Mar*/"ch"; break;
            case 4: outputMonth += /*Apr*/"il"; break;
            // case 5: outputMonth = "May"; break;
            case 6: outputMonth += /*Jun*/"e"; break;
            case 7: outputMonth += /*Jul*/"y"; break;
            case 8: outputMonth += /*Aug*/"ust"; break;
            case 9: outputMonth += /*Sep*/"tember"; break;
            case 10: outputMonth += /*Oct*/"ober"; break;
            case 11: outputMonth += /*Nov*/"ember"; break;
            case 12: outputMonth += /*Dec*/"ember"; break;
            default:
            }
            return outputMonth;
        } else {
            throw new ArithmeticException("Invalid mode for month string");
        }
    }
    
    // others
    public int[] extractIntDateFromString(String date) {
        int[] intDate = new int[3];
        String[] tokens;
        
        // get token
        if (date.indexOf('/') == -1) {
            tokens = date.split(" ");
        } else {
            tokens = date.split("/");
        }
        
        // set day, eg: "14th" or "14"
        int endOfNumber = 0;
        for(endOfNumber = 0; endOfNumber < tokens[0].length(); endOfNumber++) {
            if (tokens[0].charAt(endOfNumber) < '0' || tokens[0].charAt(endOfNumber) > '9') {
                break;
            }
        }
        intDate[0] = Integer.parseInt(tokens[0].substring(0, endOfNumber));
        
        // set month, eg: "Mar" or "Mar." or "March" or "3"
        intDate[1] = getMonthValue(tokens[1]);
        
        // set year, eg: "2021"
        intDate[2] = Integer.parseInt(tokens[2]);
        
        // check validity
        checkDate(intDate[0], intDate[1], intDate[2]);
        
        return intDate;
    }

    public boolean isLeapYear() {
        if ((this.year % 400) == 0) {
            return true;
        } else if ((this.year % 100) != 0 && (this.year % 4) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isLeapYear(int year) {
        if ((year % 400) == 0) {
            return true;
        } else if ((year % 100) != 0 && (year % 4) == 0) {
            return true;
        } else {
            return false;
        }    
    }
    
    public void print() {
        // get month string
        String month = this.getMonthName(this.month, 2);
        
        // get day string
        String day = "";
        day += this.day;
        switch(this.day) {
        case 1: case 21: case 31:
            day += "st"; break;
        case 2: case 22:
            day += "nd"; break;
        case 3:
            day += "rd"; break;
        default:
            day += "th";
        }
        
        // get year string
        String year = "";
        year += this.year;
        
        System.out.printf("%s %s %s\n", month, day, year);
    }
    
    public void print(int mode, boolean TwoCharNumber, boolean useMonthName, int monthNameMode, char separator) {
        // get day string
        String day = "";
        if (this.day < 10 && TwoCharNumber) {
            day += "0";
        }
        day += this.day;
        
        // get month string
        String month = "";
        if (useMonthName) {
            month = this.getMonthName(this.month, monthNameMode);
        } else {
            if (this.month < 10 && TwoCharNumber) {
                month += "0";
            }
            month += this.month;
        }
        
        // get year string
        String year = "";
        year += this.year;
        
        if (mode == 2) { // yyyy/mm/dd
            System.out.printf("%s%c%s%c%s\n", year, separator, month, separator, day);
        } else if (mode == 1) { // mm/dd/yyyy
            System.out.printf("%s%c%s%c%s\n", month, separator, day, separator, year);
        } else if (mode == 0) { // dd/mm/yyyy
            System.out.printf("%s%c%s%c%s\n", day, separator, month, separator, year);
        } else {
            throw new ArithmeticException("Invalid mode for MyDate.print()");
        }
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        // append month
        sb.append(this.getMonthName(this.month, 2) + " ");
        
        // append day
        sb.append(this.day);
        switch(this.day) {
        case 1: case 21: case 31:
            sb.append("st ");
            break;
        case 2: case 22:
            sb.append("nd ");
            break;
        case 3:
            sb.append("rd ");
            break;
        default:
            sb.append("th ");
        }
        
        // append year
        sb.append(this.year);
        
        return sb.toString();
    }
    
}