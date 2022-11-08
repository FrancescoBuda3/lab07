package it.unibo.nestedenum;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    static enum Month{
        JANUARY("January", 31),
        FEBRUARY("February", 28),
        MARCH("March", 31),
        APRIL("April", 30),
        MAY("May", 31),
        JUNE("June", 30),
        JULY("July", 31),
        AUGUST("August", 31),
        SEPTEMBER("September", 30),
        OCTOBER("October", 31),
        NOVEMBER("November", 30),
        DECEMBER("December", 31),
        FEBRUARY_L("February", 29);

        private final String actualName;
        private final int days;

        private Month(final String actualName, final int days){
            this.actualName = actualName;
            this.days = days;
        }

        public String getActualName(){
            return this.actualName;
        }

        public int getDays(){
            return this.days;
        }

        public static Month fromString(String s) throws IOException{
            s.toUpperCase();
            List<String> splitted = new LinkedList<>();
            List<Month> Matches = new LinkedList<>();

            if (s.contains(" ")) {
                for (String i : s.split(" ")) {
                    splitted.add(i);
                }
            }

            if ("JANUARY".contains(s)) {
                Matches.add(JANUARY);
            }
            else if ("FEBRUARY".contains(s)) {
                Matches.add(FEBRUARY);
            }
            else if ("MARCH".contains(s)) {
                Matches.add(MARCH);
            }
            else if ("APRIL".contains(s)) {
                Matches.add(APRIL);
            }
            else if ("MAY".contains(s)) {
                Matches.add(MAY);
            }
            else if ("JUNE".contains(s)) {
                Matches.add(JUNE);
            }
            else if ("JULY".contains(s)) {
                Matches.add(JULY);
            }
            else if ("AUGUST".contains(s)) {
                Matches.add(AUGUST);
            }
            else if ("SEPTEMBER".contains(s)) {
                Matches.add(SEPTEMBER);
            }
            else if ("OCTOBER".contains(s)) {
                Matches.add(OCTOBER);
            }
            else if ("NOVEMBER".contains(s)) {
                Matches.add(NOVEMBER);
            }
            else if ("DECEMBER".contains(s)) {
                Matches.add(DECEMBER);
            }
            else if (splitted.size() > 1) {
                if ("FEBRUARY".contains(splitted.get(0)) && "LEAP".contains(splitted.get(1))){
                    Matches.add(FEBRUARY_L);
                } 
            } 

            if (Matches.size() == 0){
                throw new IOException("no matches");
            } 
            else if (Matches.size() > 1) {
                throw new IOException("too much matches");
            }
            else {
                return Matches.get(0);
            }
        }
        
        
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
