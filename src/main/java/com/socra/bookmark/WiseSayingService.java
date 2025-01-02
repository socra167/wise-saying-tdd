package com.socra.bookmark;

import com.socra.bookmark.entity.WiseSayingId;
import com.socra.bookmark.entity.WiseSaying;
import com.socra.bookmark.repository.WiseSayingRepository;
import com.socra.bookmark.repository.WiseSayingRepositoryImpl;

import java.util.NoSuchElementException;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepositoryImpl();
    }

    public void addWiseSaying(WiseSaying wiseSaying) {
        wiseSayingRepository.save(wiseSaying);
    }

    public WiseSaying findWiseSayingById(WiseSayingId id) {
        return wiseSayingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 ID의 명언을 조회했습니다"));
    }
}
