package com.sparta.board.domain;


import lombok.Getter;

@Getter
//정보를 가지고  다님 . username과 content
public class MemoRequestDto {
    private String title;
    private String username;
    private String contents;
    private String nickname;
}
