package com.socra.bookmark.repository;

import com.socra.bookmark.entity.WiseSayingId;
import com.socra.bookmark.entity.WiseSaying;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class WiseSayingRepositoryImpl implements WiseSayingRepository {

    private Map<Long, WiseSaying> wiseSayingMap;

    public WiseSayingRepositoryImpl() {
        wiseSayingMap = new ConcurrentHashMap<>();
    }

    @Override
    public void save(WiseSaying wiseSaying) {
        wiseSayingMap.put(wiseSaying.getWiseSayingId(), wiseSaying);
    }

    @Override
    public Optional<WiseSaying> findById(Long id) {
        return Optional.ofNullable(wiseSayingMap.get(id));
    }

    @Override
    public List<WiseSaying> findAll() {
        return wiseSayingMap.values().stream()
                .sorted(Comparator.comparingLong(WiseSaying::getWiseSayingId))
                .collect(Collectors.toUnmodifiableList());
    }
}
