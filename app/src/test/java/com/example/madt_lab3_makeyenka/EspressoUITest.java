package com.example.madt_lab3_makeyenka;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void expectedResult() {
        String res = "14.0";
    }

    @Test
    public void buttonCheck () {
        onView(withId(R.id.n4)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.n1)).perform(click());
        onView(withId(R.id.n0)).perform(click());
        onView(withId(R.id.tempScreen)).check(matches(withText(res)));

    }
}
