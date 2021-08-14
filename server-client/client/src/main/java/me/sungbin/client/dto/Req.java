package me.sungbin.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {

    private Header header;

    private T resBody;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header {
        private String responseCode;

    }
}
