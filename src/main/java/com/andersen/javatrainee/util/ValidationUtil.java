package com.andersen.javatrainee.util;

import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.util.exception.DuplicateFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationUtil {

    public static final Logger log = LoggerFactory.getLogger(ValidationUtil.class);

    private ValidationUtil() {
    }

    public static void checkDuplicateLoginId(User userFromRepo, String oldLogin, Integer oldId) {
        if (userFromRepo != null && !userFromRepo.getId().equals(oldId)) {
            log.debug("Duplicate found: login {}, id {}", oldLogin, oldId);
            throw new DuplicateFoundException(oldLogin);
        }
    }

//    public static void checkDuplicateMovieTitleId

}