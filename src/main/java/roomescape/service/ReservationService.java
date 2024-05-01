package roomescape.service;

import org.springframework.stereotype.Service;
import roomescape.dao.ReservationDao;
import roomescape.dao.ThemeDao;
import roomescape.dao.TimeDao;
import roomescape.domain.Reservation;
import roomescape.domain.ReservationTime;
import roomescape.domain.Theme;
import roomescape.dto.ReservationCreateRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationDao reservationDao;
    private final TimeDao timeDao;
    private final ThemeDao themeDao;

    public ReservationService(ReservationDao reservationDao, TimeDao timeDao, ThemeDao themeDao) {
        this.reservationDao = reservationDao;
        this.timeDao = timeDao;
        this.themeDao = themeDao;
    }

    public List<Reservation> readReservations() {
        return reservationDao.readReservations();
    }

    public Reservation createReservation(ReservationCreateRequest dto) {
        ReservationTime time = timeDao.readTimeById(dto.timeId())
                .orElseThrow(() -> new IllegalArgumentException("해당 예약 시간이 존재하지 않습니다."));
        Theme theme = themeDao.readThemeById(dto.themeId())
                .orElseThrow(() -> new IllegalArgumentException("해당 테마가 존재하지 않습니다."));
        Reservation reservation = dto.createReservation(time, theme);

        validate(reservation);
        return reservationDao.createReservation(reservation);
    }

    private void validate(Reservation reservation) {
        if (reservation.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("예약은 현재 시간 이후여야 합니다.");
        }
        if (reservationDao.isExistReservationByTimeIdAndDate(reservation.getTime().getId(), reservation.getDate())) {
            throw new IllegalArgumentException("해당 시간대 예약은 이미 존재합니다.");
        }
    }

    public void deleteReservation(Long id) {
        reservationDao.deleteReservation(id);
    }

}
