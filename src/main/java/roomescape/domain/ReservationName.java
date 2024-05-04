package roomescape.domain;

import java.util.Objects;

public record ReservationName(String value) {
    public ReservationName {
        Objects.requireNonNull(value, "인자 중 null 값이 존재합니다.");
        if (value.isEmpty()) {
            throw new IllegalArgumentException("예약자 이름은 한글자 이상이어야 합니다.");
        }
    }
}