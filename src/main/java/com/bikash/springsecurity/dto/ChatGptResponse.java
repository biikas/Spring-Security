package com.bikash.springsecurity.dto;

import lombok.*;

import java.util.List;

/**
 * @author Bikash Shah
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponse {

    private List<Choice> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {

        private int index;
        private Message message;

    }
}
