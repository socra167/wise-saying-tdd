package com.socra.bookmark.repository;

import com.socra.bookmark.entity.WiseSayingId;
import com.socra.bookmark.entity.WiseSaying;

import java.util.Optional;

public interface WiseSayingRepository {

    void save(WiseSaying wiseSaying);
    Optional<WiseSaying> findById(WiseSayingId id);
}
