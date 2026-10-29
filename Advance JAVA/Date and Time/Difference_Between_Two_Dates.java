import java.time.*;
class Difference_Between_Two_Dates{
    void main() {
        LocalDate d1 = LocalDate.of(2023,10,22);
        LocalDate d2 = LocalDate.of(2026,12,31);
        Period p = Period.between(d1, d2);
        System.out.println("No of Days: "+p.getDays());
        System.out.println("No of Months: "+p.getMonths());
        System.out.println("No of years: "+p.getYears());
    }
}