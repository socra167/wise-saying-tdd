package service;

import com.socra.bookmark.entity.Author;
import com.socra.bookmark.entity.WiseSayingId;
import com.socra.bookmark.entity.WiseSaying;
import com.socra.bookmark.WiseSayingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class WiseSayingServiceTest {

    WiseSayingService wiseSayingService;

    @BeforeEach
    void before_each() {
        wiseSayingService = new WiseSayingService();
    }

    @Test
    @DisplayName("명언을 등록하고 ID로 조회할 수 있다")
    void add_wisesaying() {
        WiseSaying wiseSaying = newWiseSaying(new Author("작자미상"), "현재를 사랑하라.");
        WiseSaying addedWiseSaying = wiseSayingService.addWiseSaying(wiseSaying);
        assertThat(wiseSayingService.findWiseSayingById(new WiseSayingId(1L)))
                .usingRecursiveComparison()
                .isEqualTo(addedWiseSaying);
    }

    @Test
    @DisplayName("존재하지 않는 ID로 명언을 조회할 수 없다")
    void read_invalid_wisesaying_id() {
        assertThatThrownBy(() -> {
            wiseSayingService.findWiseSayingById(new WiseSayingId(99999L));
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessage("존재하지 않는 ID의 명언을 조회했습니다");
    }

    @Test
    @DisplayName("명언을 등록할때 마다 생성되는 명언번호가 증가한다")
    void increment_id() {
        for (int i = 0; i < 20; i++) {
            wiseSayingService.addWiseSaying(newWiseSaying(new Author("작자미상"), "현재를 사랑하라."));
        }

        wiseSayingService.findWiseSayingById(new WiseSayingId(20L));
        assertThatThrownBy(() -> {
            wiseSayingService.findWiseSayingById(new WiseSayingId(21L));
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessage("존재하지 않는 ID의 명언을 조회했습니다");
    }

    WiseSaying newWiseSaying(Author author, String content) {
        return WiseSaying.builder().author(author).content(content).build();
    }
}
