import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaTasks {

    public static void main(String[] args) {

        Function<Integer, Boolean> isLeapYear = year ->
                (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        System.out.println("2024 високосний: " + isLeapYear.apply(2024));
        System.out.println("2023 високосний: " + isLeapYear.apply(2023));


        BiFunction<LocalDate, LocalDate, Long> daysBetween =
                (date1, date2) -> ChronoUnit.DAYS.between(date1, date2);

        LocalDate d1 = LocalDate.of(2023, 1, 1);
        LocalDate d2 = LocalDate.of(2023, 1, 10);

        System.out.println("Днів між датами: " + daysBetween.apply(d1, d2));


        BiFunction<LocalDate, LocalDate, Long> fullSundaysBetween = (start, end) -> {
            long count = 0;
            LocalDate date = start;

            while (!date.isAfter(end)) {
                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    count++;
                }
                date = date.plusDays(1);
            }
            return count;
        };

        System.out.println("Неділь між датами: " +
                fullSundaysBetween.apply(d1, d2));


        Function<LocalDate, String> getDayOfWeek =
                date -> date.getDayOfWeek().toString();

        LocalDate exampleDate = LocalDate.of(1969, 7, 20);

        System.out.println("20 липня 1969: " +
                getDayOfWeek.apply(exampleDate));
    }
}