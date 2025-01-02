package com.socra.bookmark;

import com.socra.bookmark.entity.WiseSayingId;
import com.socra.bookmark.entity.WiseSaying;
import com.socra.bookmark.repository.WiseSayingRepository;
import com.socra.bookmark.repository.WiseSayingRepositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository;
    Long idCounter;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepositoryImpl();
        idCounter = 1L;
    }

    public WiseSaying addWiseSaying(WiseSaying wiseSaying) {
        wiseSaying.setWiseSayingId(new WiseSayingId(idCounter++));
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }

    public WiseSaying findWiseSayingById(Long id) {
        return wiseSayingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 ID의 명언을 조회했습니다"));
    }

    public List<WiseSaying> findAllWiseSaying() {
        return wiseSayingRepository.findAll();
    }
}
