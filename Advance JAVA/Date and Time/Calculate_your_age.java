
import java.time.*;
class Calculate_your_age{
    void main() {
        LocalDate d = LocalDate.now();
        LocalDate dob = LocalDate.of(2003,9,10);
        Period p = Period.between(dob, d);
        System.out.println("No of Days: "+p.getDays());
        System.out.println("No of Months: "+p.getMonths());
        System.out.println("No of years: "+p.getYears());
    }
}