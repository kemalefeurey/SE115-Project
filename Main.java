// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    static int[][][] data= new int[MONTHS][DAYS][COMMS];

    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {
    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========
// data[12 month][28 day][5 com]
// gold=0/oil=1/silver=2/wheat=3/copper=4
    public static String mostProfitableCommodityInMonth(int month) {
        if(month<MONTHS && 0<=month){
            int[] sumCom=new int[5];

            for (int i = 0; i <DAYS; i++) {
                sumCom[0] += data[month][i][0];
                sumCom[1] += data[month][i][1];
                sumCom[2] += data[month][i][2];
                sumCom[3] += data[month][i][3];
                sumCom[4] += data[month][i][4];
            }
            int maxCom=0;
            int k=-1;
            for(int i=0;i<COMMS;i++){
                if(maxCom<sumCom[i]){
                    maxCom=sumCom[i];
                    k=i;
                }
            }
            return "Most Profitable Commodity In Month is: "+commodities[k];
        }else{
            return "INVALID_MONTH";
        }
    }

    public static int totalProfitOnDay(int month, int day) {
        if((month<MONTHS && 0<=month) && (day<DAYS && 0<=day)){
            int sumDay=0;
            for(int i=0;i<COMMS;i++){
                sumDay+=data[month][day][i];
            }
            return sumDay;
        } else {
            return -99999;
        }
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        int sumRange=0;
        if((from<DAYS && from>=0) && (to<DAYS && to>=0)){
            if(from<=to){
                int c=-1;
                for(int i=0;i<commodities.length;i++){
                    if(commodities[i].equals(commodity)){
                        c=i;
                    }
                }
                if (c==-1){
                    return -99999;
                }else{
                    for(int i=0;i<MONTHS;i++){
                        for(int j=from;j<(to+1);j++){
                            sumRange+=data[i][j][c];
                        }
                    }
                    return sumRange;
                }
            }else{
                return -99999;
            }
        }else{
            return -99999;
        }
    }

    public static int bestDayOfMonth(int month) {
        return 1234;
    }

    public static String bestMonthForCommodity(String comm) {
        return "DUMMY";
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        return 1234;
    }

    public static int biggestDailySwing(int month) {
        return 1234;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        return "DUMMY is better by 1234";
    }

    public static String bestWeekOfMonth(int month) {
        return "DUMMY";
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}