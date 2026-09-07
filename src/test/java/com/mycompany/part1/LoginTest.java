package com.mycompany.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private login login;

    @BeforeEach
    void setUp() {
        login = new login();
    }

    @Test
    void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("jay_2"));
        assertEquals("Username successfully captured.",
                     login.getUsernameCaptureMessage("jay_2"));
    }

    @Test
    void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("jason!!!!!"));
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                     login.getUsernameCaptureMessage("jason!!!!!"));
    }

    @Test
    void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Tr@ck9X!"));
        assertEquals("Password successfully captured.",
                     login.getPasswordCaptureMessage("Tr@ck9X!"));
    }

    @Test
    void testPasswordDoesNotMeetComplexity() {
        assertFalse(login.checkPasswordComplexity("simple"));
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                     login.getPasswordCaptureMessage("simple"));
    }

    @Test
    void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27821234567"));
        assertEquals("Cell number successfully captured.",
                     login.getCellPhoneCaptureMessage("+27821234567"));
    }

    @Test
    void testCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("0821234567"));
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.",
                     login.getCellPhoneCaptureMessage("0821234567"));
    }

    @Test
    void testLoginSuccessful() {
        login.registerUser("jay_2", "Tr@ck9X!", "+27821234567", "Jason", "Nkosi");
        assertTrue(login.loginUser("jay_2", "Tr@ck9X!"));
        assertEquals("Welcome Jason Nkosi, it is great to see you again.",
                     login.returnLoginStatus("jay_2", "Tr@ck9X!"));
    }

    @Test
    void testLoginFailed() {
        login.registerUser("jay_2", "Tr@ck9X!", "+27821234567", "Jason", "Nkosi");
        assertFalse(login.loginUser("wrong", "wrong"));
        assertEquals("Username or password incorrect, please try again.",
                     login.returnLoginStatus("wrong", "wrong"));
    }
}