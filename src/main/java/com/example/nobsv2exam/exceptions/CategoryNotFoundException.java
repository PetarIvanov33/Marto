package com.example.nobsv2exam.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        log.info("Exception " + getClass() + " thrown");
    }
}
