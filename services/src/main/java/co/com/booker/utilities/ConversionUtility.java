package co.com.booker.utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static co.com.booker.utilities.Constants.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConversionUtility {

    public static String getCurrentDate(String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    public static String getFutureOrPastDate(String format, int days) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    public static String upperCaseFirst(String value) {
        char[] arr = value.toLowerCase().toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

    public static String formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_WITH_SLASH);
        LocalDate localDate = LocalDate.parse(date, formatter);
        DateTimeFormatter formatter1 =
                DateTimeFormatter.ofPattern(FORMAT_DATE_WITH_SPACES, new Locale(SPANISH_LANGUAGE));
        return localDate.format(formatter1);
    }
}