package com.socra.bookmark.entity;

import java.util.Objects;

public class WiseSayingId {

    private final Long id;

    public WiseSayingId(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("ID는 양의 정수여야 합니다");
        }
        this.id = value;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WiseSayingId id1 = (WiseSayingId) o;
        return id.equals(id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
