
import java.time.*;
import java.time.temporal.*;
class Find_age_in_terms_of_days{
    public static void main(String[] args) {
        LocalDate dob = LocalDate.of(1975,9,1);
        LocalDate t = LocalDate.now();
        long days = ChronoUnit.DAYS.between(dob,t);
        System.out.println("Age: "+days+" Days.");
        long months = ChronoUnit.MONTHS.between(dob, t);
        System.out.println("Age: "+months+" Months.");
    }
}