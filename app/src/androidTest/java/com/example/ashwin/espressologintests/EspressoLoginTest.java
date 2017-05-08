package com.example.ashwin.espressologintests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by ashwin on 8/5/17.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoLoginTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void login_success() {
        // Click on button
        onView(withId(R.id.goToLoginPageButton)).perform(click());

        // Type correct username
        onView(withId(R.id.usernameEditText)).perform(typeText("admin"),
                closeSoftKeyboard());

        // Type correct password
        onView(withId(R.id.passwordEditText)).perform(typeText("password"),
                closeSoftKeyboard());

        // Click login button
        onView(withId(R.id.loginButton)).perform(click());

        // Check toast message
        onView(withText("Login Success")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

        // Check if on home page
        onView(withId(R.id.welcomeUserTextView)).check(matches(withText("Welcome admin")));
    }

    @Test
    public void login_fail_wrong_username() {
        // Click on button
        onView(withId(R.id.goToLoginPageButton)).perform(click());

        // Type wrong username
        onView(withId(R.id.usernameEditText)).perform(typeText("user"),
                closeSoftKeyboard());

        // Type correct password
        onView(withId(R.id.passwordEditText)).perform(typeText("password"),
                closeSoftKeyboard());

        // Click login button
        onView(withId(R.id.loginButton)).perform(click());

        // Check toast message
        onView(withText("Login Failed")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void login_fail_wrong_password() {
        // Click on button
        onView(withId(R.id.goToLoginPageButton)).perform(click());

        // Type correct username
        onView(withId(R.id.usernameEditText)).perform(typeText("admin"),
                closeSoftKeyboard());

        // Type wrong password
        onView(withId(R.id.passwordEditText)).perform(typeText("admin"),
                closeSoftKeyboard());

        // Click login button
        onView(withId(R.id.loginButton)).perform(click());

        // Check toast message
        onView(withText("Login Failed")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void login_fail_wrong_username_password() {
        // Click on button
        onView(withId(R.id.goToLoginPageButton)).perform(click());

        // Type wrong username
        onView(withId(R.id.usernameEditText)).perform(typeText("user"),
                closeSoftKeyboard());

        // Type wrong password
        onView(withId(R.id.passwordEditText)).perform(typeText("admin"),
                closeSoftKeyboard());

        // Click login button
        onView(withId(R.id.loginButton)).perform(click());

        // Check toast message
        onView(withText("Login Failed")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}

