package com.example;

import com.example.config.SpringH2Config;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

@SpringApplicationConfiguration(classes = SpringDbunitTestApplication.class)
@Import(SpringH2Config.class)
@TestExecutionListeners(listeners = {DbUnitTestExecutionListener.class}, mergeMode = MERGE_WITH_DEFAULTS)
@EnableAutoConfiguration
@DbUnitConfiguration
@DatabaseTearDown(value = "/cleanup.xml", type = DatabaseOperation.DELETE_ALL)
public class AbstractTestBase extends AbstractJUnit4SpringContextTests {

    protected @PersistenceContext EntityManager em;

}
