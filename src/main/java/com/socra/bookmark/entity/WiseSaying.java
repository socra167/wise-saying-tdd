package com.socra.bookmark.entity;

public class WiseSaying {

    private WiseSayingId wiseSayingId;
    private Author author;
    private String content;

    private WiseSaying(Builder builder) {
        this.wiseSayingId = builder.getId();
        this.author = builder.getAuthor();
        this.content = builder.getContent();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private WiseSayingId id;
        private Author author;
        private String content;

        public Builder wiseSayingId(WiseSayingId id) {
            this.id = id;
            return this;
        }

        public Builder author(Author author) {
            this.author = author;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public WiseSaying build() {
            return new WiseSaying(this);
        }

        private WiseSayingId getId() {
            return id;
        }

        private Author getAuthor() {
            return author;
        }

        private String getContent() {
            return content;
        }
    }

    public Long getWiseSayingId() {
        return wiseSayingId.getId();
    }

    public WiseSaying setWiseSayingId(WiseSayingId wiseSayingId) {
        this.wiseSayingId = wiseSayingId;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public WiseSaying setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public WiseSaying setContent(String content) {
        this.content = content;
        return this;
    }
}
