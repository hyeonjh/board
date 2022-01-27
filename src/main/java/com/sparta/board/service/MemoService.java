package com.sparta.board.service;

import com.sparta.board.domain.Memo;
import com.sparta.board.domain.MemoRepository;
import com.sparta.board.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.soap.Detail;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;
    //꼭필요하다고 선언해야함 - requiredArgsConstructor

    @Transactional //db에 반영이 되도록 함
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
                () -> new NullPointerException("아이디가 없다")
        );
        memo.update(requestDto);
        return memo.getId();
    }





}