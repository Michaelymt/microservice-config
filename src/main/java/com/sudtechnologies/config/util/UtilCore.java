package com.sudtechnologies.config.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author SudTechnologies
 */
public class UtilCore {

    public static class UtilFecha {

        public static Date fechaActual() {
            ZoneId actualZone = ZoneId.systemDefault();
            ZonedDateTime actualZonedDatetime = LocalDateTime.now().atZone(actualZone);
            ZoneId limaZone = ZoneId.of("America/Lima");
            ZonedDateTime limaDatetime = actualZonedDatetime.withZoneSameInstant(limaZone);

            return Date.from(limaDatetime.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
        }

        public static boolean isBeforeOrEqualToday(Date date) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1);
            return c.getTime().before(date);
        }
    }

    public static class UtilPrices {
        public static BigDecimal format(int offset, BigDecimal value) {
            return value.setScale(offset, BigDecimal.ROUND_UP);
        }

        public static BigDecimal format(BigDecimal value) {
            return value.setScale(2, BigDecimal.ROUND_DOWN);
        }
    }

    public static class UtilSecurity {
        public static String generatePassword() {
            return UUID.randomUUID().toString().substring(0, 8);
        }
    }
}
