package service;

import com.socra.bookmark.entity.Author;
import com.socra.bookmark.entity.WiseSaying;
import com.socra.bookmark.WiseSayingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        WiseSaying addedWiseSaying = addNewWiseSaying(wiseSayingService, new Author("작자미상"), "현재를 사랑하라.");
        assertThat(wiseSayingService.findWiseSayingById(1L))
                .usingRecursiveComparison()
                .isEqualTo(addedWiseSaying);
    }

    @Test
    @DisplayName("존재하지 않는 ID로 명언을 조회할 수 없다")
    void read_invalid_wisesaying_id() {
        assertThatThrownBy(() -> {
            wiseSayingService.findWiseSayingById(99999L);
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessage("존재하지 않는 ID의 명언을 조회했습니다");
    }

    @Test
    @DisplayName("명언을 등록할때 마다 생성되는 명언번호가 증가한다")
    void increment_id() {
        for (int i = 0; i < 20; i++) {
            addNewWiseSaying(wiseSayingService, new Author("작자미상"), "현재를 사랑하라.");
        }

        wiseSayingService.findWiseSayingById(20L);
        assertThatThrownBy(() -> {
            wiseSayingService.findWiseSayingById(21L);
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessage("존재하지 않는 ID의 명언을 조회했습니다");
    }

    @Test
    @DisplayName("등록된 명언들을 모두 조회할 수 있다")
    void find_all_wisesaying() {
        List<WiseSaying> wiseSayingList = List.of(
                addNewWiseSaying(wiseSayingService, new Author("Albert Einstein"), "Life is like riding a bicycle. To keep your balance, you must keep moving"),
                addNewWiseSaying(wiseSayingService, new Author("Oscar Wilde"), "Be yourself; everyone else is already taken."),
                addNewWiseSaying(wiseSayingService, new Author("Nelson Mandela"), "It always seems impossible until it’s done."),
                addNewWiseSaying(wiseSayingService, new Author("Mahatma Gandhi"), "Be the change that you wish to see in the world."),
                addNewWiseSaying(wiseSayingService, new Author("Walt Disney"), "The way to get started is to quit talking and begin doing.")
        );

        assertThat(wiseSayingService.findAllWiseSaying())
                .usingRecursiveComparison()
                .isEqualTo(wiseSayingList);
    }

    WiseSaying addNewWiseSaying(WiseSayingService wiseSayingService, Author author, String content) {
        WiseSaying wiseSaying = WiseSaying.builder().author(author).content(content).build();
        wiseSayingService.addWiseSaying(wiseSaying);
        return wiseSaying;
    }
}
