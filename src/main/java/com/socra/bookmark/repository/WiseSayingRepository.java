package com.socra.bookmark.repository;

import com.socra.bookmark.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {

    void save(WiseSaying wiseSaying);

    Optional<WiseSaying> findById(Long id);

    List<WiseSaying> findAll();
}
