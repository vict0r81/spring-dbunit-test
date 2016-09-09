package com.example.service;

import com.example.AbstractTestBase;
import com.example.domain.User;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
//import org.dbunit.dataset.DataSetException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class UserServiceImplIT extends AbstractTestBase {

    public @Rule ExpectedException expectedException = ExpectedException.none();
    private @Autowired UserService userService;

    @Test
    @DatabaseSetup(value = "/init.xml")
    @ExpectedDatabase(value = "/expected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void when_createNewUser__with_correct_name_surname__expect_JdbcSQLException() throws Exception {
        // This Exception has gone
        //        expectedException.expect(DataSetException.class); // Column "admin" not found
        try {
            userService.createUser("John", "Doe");
        } catch (Exception e) {
            fail("No exception should be here");
        }
    }

    @Test
    @DatabaseSetup(value = "/init.xml")
    public void when_create_newUser__with_correct_name_surname__expect_success() throws Exception {
        User user = userService.createUser("John", "Doe");
        assertNotNull(user);
        assertEquals("123456", user.getPassword());
        assertNotNull(user.getPerson());
        assertEquals("John", user.getPerson().getName());
        assertEquals("Doe", user.getPerson().getSurname());
    }
}