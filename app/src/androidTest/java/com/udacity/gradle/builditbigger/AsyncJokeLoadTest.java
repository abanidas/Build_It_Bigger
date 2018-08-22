package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.udacity.gradle.builditbigger.tests.AsyncDataLoadCallback;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class AsyncJokeLoadTest {

    private static final String TEST_JOKE = "\nQ. Can a kangaroo jump higher than a house?" +
            "\n A. Of course, a house does not jump at all.";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTaskDataLoad(){
        MainActivity testDataLoad = mActivityTestRule.getActivity();
        testDataLoad.setDataLoadCallback(new AsyncDataLoadCallback() {
            @Override
            public void onDataLoad(String joke) {
                assertEquals(TEST_JOKE, joke);
            }
        });

        onView(withId(R.id.btn_tell_joke)).perform(click());

    }
}
