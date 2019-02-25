package com.andersen.javatrainee.repository;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig(locations = {"classpath:spring/db.xml", "classpath:spring/security.xml"})
@Transactional
public class AbstractRepositoryTest {

}
