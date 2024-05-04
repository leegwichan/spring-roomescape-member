package roomescape.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import roomescape.dao.ThemeDao;
import roomescape.domain.Theme;
import roomescape.dto.ThemeCreateRequest;
import roomescape.dto.ThemeResponse;

@Service
public class ThemeService {
    private static final int POPULAR_THEME_START_DATE_BOUNDARY = 7;
    private static final int POPULAR_THEME_END_DATE_BOUNDARY = 1;
    private static final int COUNT_OF_POPULAR_THEME = 10;

    private final ThemeDao themeDao;

    public ThemeService(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    public List<ThemeResponse> readThemes() {
        return themeDao.readThemes()
                .stream()
                .map(ThemeResponse::from)
                .toList();
    }

    public List<ThemeResponse> readPopularThemes() {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusDays(POPULAR_THEME_START_DATE_BOUNDARY);
        LocalDate endDate = currentDate.minusDays(POPULAR_THEME_END_DATE_BOUNDARY);

        return themeDao.readThemesSortedByCountOfReservation(startDate, endDate, COUNT_OF_POPULAR_THEME)
                .stream()
                .map(ThemeResponse::from)
                .toList();
    }

    public ThemeResponse createTheme(ThemeCreateRequest dto) {
        if (themeDao.isExistThemeByName(dto.name())) {
            throw new IllegalArgumentException("해당 테마 이름은 이미 존재합니다.");
        }
        Theme createdTheme = themeDao.createTheme(dto.createTheme());
        return ThemeResponse.from(createdTheme);
    }

    public void deleteTheme(Long id) {
        themeDao.deleteTheme(id);
    }
}
