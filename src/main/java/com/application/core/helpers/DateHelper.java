package com.application.core.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {
    public static String getTodayDateInProperFormat(String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }
}
