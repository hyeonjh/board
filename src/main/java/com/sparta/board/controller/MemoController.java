package com.sparta.board.controller;

import com.sparta.board.domain.Memo;
import com.sparta.board.domain.MemoRepository;
import com.sparta.board.domain.MemoRequestDto;
import com.sparta.board.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


//new 어쩌고 신경쓸필요 없다.
@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;
    //업데이트를 위해서 서비스 필요함
    //나머지는 리포짓터리가 필요함함
//     필수적이므로 final.
//  메모 생성\
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
//      Memo memo = memoRepository.save(requestDto);  같은뜻;
//        return memo;
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);

    }
//  메모 읽기
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }



    @GetMapping("/abc/{id}")
    public Memo getDetail(@PathVariable Long id) {
        return memoRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
                () -> new NullPointerException("아이디가 없다")
        );
    }


    //  메모 업데이트
    @PutMapping ("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }
//  메모삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        //경로에 있는 변수 {id}를 받아옴
        memoRepository.deleteById(id);
        return id;
    }
//    @GetMapping("/detail/{id}")
//    public Memo getDetail(@PathVariable Long id) {
//
//        return memoRepository.findById(id);    }


//    @GetMapping("/abc/{id}")
//    public ModelAndView getDetail2(@PathVariable Long id){
//        System.out.println("asdadasddddddddddddddddd");
//        ModelAndView view =new ModelAndView();
//
//        Memo memo = memoRepository.findById(id).orElseThrow(
////                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//                () -> new NullPointerException("아이디가 없다")
//        );
//
//        view.addObject("memo",memo);
//        view.setViewName("abc");
//        System.out.println("asdadasddddddddddddddddd");
//        return view;
//    }



    }

