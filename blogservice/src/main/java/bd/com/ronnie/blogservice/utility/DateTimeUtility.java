package bd.com.ronnie.blogservice.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtility {

    private static final String dateTimePattern = "dd-MMM-yyyy hh:mm a";

    public static String fromInstant(Instant instant) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        return DateTimeFormatter.ofPattern(dateTimePattern).format(localDateTime);
    }

    private DateTimeUtility() {
    }

}
