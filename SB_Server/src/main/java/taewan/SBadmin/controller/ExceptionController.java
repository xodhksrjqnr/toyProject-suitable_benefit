package taewan.SBadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    public Optional<Objects> handleNoSuchElementException(NoSuchElementException e) {
        return Optional.empty();
    }
}
