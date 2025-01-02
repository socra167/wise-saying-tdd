package com.socra.bookmark.repository;

import com.socra.bookmark.entity.WiseSayingId;
import com.socra.bookmark.entity.WiseSaying;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class WiseSayingRepositoryImpl implements WiseSayingRepository {

    private Map<WiseSayingId, WiseSaying> wiseSayingMap;

    public WiseSayingRepositoryImpl() {
        wiseSayingMap = new ConcurrentHashMap<>();
    }

    @Override
    public void save(WiseSaying wiseSaying) {
        wiseSayingMap.put(wiseSaying.getId(), wiseSaying);
    }

    @Override
    public Optional<WiseSaying> findById(WiseSayingId id) {
        return Optional.ofNullable(wiseSayingMap.get(id));
    }
}
