package com.sleekcreative.testinginadroid;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by irvincardenas on 9/15/15.
 */
public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity>{

    public static final String USER_EMAIL = "abc@nyu.edu";
    public static final String PASSWORD = "abc123";

    public LoginActivityTest(Class<LoginActivity> activityClass) {
        super(activityClass);
    }

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    /**
     * Assert that the email hint is displayed
     */
    public void testEmailHintIsDisplayed() {
        onView(withId(R.id.email)).check(matches(withHint(R.string.prompt_email)));
    }

    /**
     * Assert that the password hint text is displayed
     */
    public void testPasswordHintIsDisplayed() {
        onView(withId(R.id.password)).check(matches(withHint(R.string.prompt_password)));
    }

    public void testErrorMessageIsDisplayed() {

        // Assert that the error text view is not displayed
        onView(withId(R.id.error_text)).check(matches(not(isDisplayed())));

        // Click on the email sig"abc@nyu.edu"n in button
        onView(withId(R.id.email_sign_in_button)).perform(click());

        // Assert that the error text view is displayed
        onView(withId(R.id.error_text)).check(matches(isDisplayed()));
    }

    public void testUsernamePassedAsAnExtra(){
        // Find the login view and type the text "abc@nyu.edu"
        onView(withId(R.id.email)).perform(typeText(USER_EMAIL));

        // Find the password view and type the password "abc123"
        onView(withId(R.id.password)).perform(typeText(PASSWORD));

        // Find the email sign in button and click it
        onView(withId(R.id.email_sign_in_button)).perform(click());

        // Assert that email used to sign in is displayed
        // Notice that we are not specifying what view we want to check
        onView(withId(R.id.login_email_text)).check(matches(withText(USER_EMAIL)));
    }
}
