package roomescape.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import roomescape.reservation.domain.Reservation;
import roomescape.time.domain.ReservationTime;
import roomescape.theme.domain.Theme;

public record ReservationCreateRequest(String name,
                                       @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                       Long timeId,
                                       Long themeId) {
    public Reservation createReservation(ReservationTime time, Theme theme) {
        return new Reservation(name, date, time, theme);
    }
}