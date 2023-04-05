package com.github.fabriciolfj.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateFormatedUtil {

    public static LocalDateTime toDateIso() {
        var sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        var date = new Date();

        var dateFormat = sdf.format(date);
        return LocalDateTime.parse(dateFormat);
    }
}
