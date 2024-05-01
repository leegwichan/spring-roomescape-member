package roomescape.domain;

import java.util.Objects;

public class Theme {
    private final Long id;
    private final String name;
    private final String description;
    private final String thumbnail;

    public Theme(Long id, String name, String description, String thumbnail) {
        final String errorMessage = "인자 중 null 값이 존재합니다.";
        this.id = Objects.requireNonNull(id, errorMessage);
        this.name = Objects.requireNonNull(name, errorMessage);
        this.description = Objects.requireNonNull(description, errorMessage);
        this.thumbnail = Objects.requireNonNull(thumbnail, errorMessage);
    }

    public Theme(String name, String description, String thumbnail) {
        final String errorMessage = "인자 중 null 값이 존재합니다.";
        this.id = null;
        this.name = Objects.requireNonNull(name, errorMessage);
        this.description = Objects.requireNonNull(description, errorMessage);
        this.thumbnail = Objects.requireNonNull(thumbnail, errorMessage);
    }

    public Theme changeId(Long id) {
        return new Theme(id, this.name, this.description, this.thumbnail);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}