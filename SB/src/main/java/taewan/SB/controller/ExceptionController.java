package taewan.SB.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    public void handleNoSuchElementException(NoSuchElementException e) {
        throw new NoSuchElementException("삭제된 게시물");
    }

    @ExceptionHandler(RuntimeException.class)
    public void RuntimeException(RuntimeException e) {
        throw new RuntimeException("예외 발생");
    }
}
