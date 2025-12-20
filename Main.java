// Main.java — Students version
import java.io.*;
import java.util.*;
import java.lang.Math;

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
        if(month<MONTHS && month>=0){
            int[] sumDay=new int[DAYS];
            for (int i = 0; i <DAYS; i++) {
                for (int j = 0; j < COMMS; j++) {
                    sumDay[i]+=data[month][i][j];
                }
            }
            int bestDay=0;
            int maxDay=0;
            for (int i = 0; i < sumDay.length; i++) {
                if (maxDay<sumDay[i]) {
                    maxDay=sumDay[i];
                    bestDay=i;
                }
            }
            return bestDay;
        }else{
            return -1;
        }
    }

    public static String bestMonthForCommodity(String comm) {
        int c=-1;
        for(int i=0;i<commodities.length;i++){
            if(commodities[i].equals(comm)){
                c=i;
            }
        }
        if (c==-1){
            return "INVALID_COMMODITY";
        }else{
            int[] sumMonth=new int[MONTHS];
            int bestMonth=7;
            int max=sumMonth[7];
            // Why specifically 7?   My Birthday: ??/08/2007,months[7]=August
            for (int i = 0; i < MONTHS; i++) {
                for (int j = 0; j <DAYS ; j++) {
                    sumMonth[i]+=data[i][j][c];
                }
            }
            for (int i = 0; i < sumMonth.length; i++) {
                if(sumMonth[i]>max){
                    max=sumMonth[i];
                    bestMonth=i;
                }
            }
            return months[bestMonth];
        }
    }

    public static int consecutiveLossDays(String comm) {
        int c=-1;
        for(int i=0;i<commodities.length;i++){
            if(commodities[i].equals(comm)){
                c=i;
            }
        }
        if (c==-1){
            return -1;
        }else{
            int streak=0;
            int maxStreak=0;
            for (int i = 0; i < MONTHS; i++) {
                for (int j = 0; j < DAYS; j++) {
                    if(data[i][j][c]<0){
                        streak++;
                        if(maxStreak<streak){
                            maxStreak=streak;
                        }
                    }else{
                        streak=0;
                    }
                }
            }
            return maxStreak;
        }
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        int c=-1;
        int above=0;
        for(int i=0;i<commodities.length;i++){
            if(commodities[i].equals(comm)){
                c=i;
            }
        }
        if (c==-1){
            return -1;
        }else{
            for(int i=0;i<MONTHS;i++){
                for (int j=0;j<DAYS;j++) {
                    if(data[i][j][c]>threshold){
                        above++;
                    }
                }
            }
            return above;
        }
    }

    public static int biggestDailySwing(int month) {
        if(month<MONTHS && 0<=month){
            int maxSwing=0;
            int[] sumProfit=new int[DAYS];
            for (int i = 0; i <DAYS; i++) {
                for (int j = 0; j < COMMS; j++) {
                    sumProfit[i]+=data[month][i][j];
                }
            }
            for(int j=0;(j<DAYS-1);j++){
                if(Math.abs(sumProfit[j]-sumProfit[j+1])>maxSwing){
                    maxSwing=Math.abs(sumProfit[j]-sumProfit[j+1]);
                }
            }
            return maxSwing;
        }else{
            return -99999;
        }
    }

    public static String compareTwoCommodities(String c1, String c2) {
        int c1int=-1;
        int c2int=-1;
        for(int i=0;i<commodities.length;i++){
            if(commodities[i].equals(c1)){
                c1int=i;
            }
        }
        for(int i=0;i<commodities.length;i++){
            if(commodities[i].equals(c2)){
                c2int=i;
            }
        }
        if(c1int==-1 || c2int==-1){
            return "INVALID_COMMODITY";
        }else{
            int c1SumYear=0;
            int c2SumYear=0;
            for (int i = 0; i <MONTHS; i++) {
                for (int j=0;j<DAYS;j++){
                    c1SumYear+=data[i][j][c1int];
                    c2SumYear+=data[i][j][c2int];
                }
            }
            if(c1SumYear<c2SumYear){
                return c2+" is better by "+(c2SumYear-c1SumYear);
            }else if(c1SumYear>c2SumYear){
                return c1+" is better by "+(c1SumYear-c2SumYear);
            }else{
                return"Equal";
            }
        }
    }

    public static String bestWeekOfMonth(int month) {
        if(month<MONTHS && 0<=month){
            int[] sumDay=new int[DAYS];
            for (int i = 0; i <DAYS; i++) {
                for (int j = 0; j < COMMS; j++) {
                    sumDay[i]+=data[month][i][j];
                }
            }
            int[] sumWeek=new int[4];
            for(int i=0;i<DAYS;i++){
                if(i>=0 && i<=6){
                    sumWeek[0]+=sumDay[i];
                } else if (i>=7 && i<=13) {
                    sumWeek[1]+=sumDay[i];
                } else if (i>=14 && i<=20) {
                    sumWeek[2]+=sumDay[i];
                }else{
                    sumWeek[3]+=sumDay[i];
                }
            }
            int bestWeek=sumWeek[0];
            int bestWeekNumber=0;
            for (int i=0;i<sumWeek.length;i++) {
                if(sumWeek[i]>bestWeek){
                    bestWeekNumber=i;
                    bestWeek=sumWeek[i];
                }
            }
            return "Week "+(bestWeekNumber+1);
        }else{
            return  "INVALID_MONTH";
        }
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}