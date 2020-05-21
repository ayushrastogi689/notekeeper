package com.example.notekeeper;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.notekeeper.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NoteListActivityTest {

    @Rule
    public ActivityTestRule<NoteListActivity> mActivityTestRule = new ActivityTestRule<>(NoteListActivity.class);

    @Test
    public void noteListActivityTest() {
        ViewInteraction floatingActionButton = onView(
allOf(withId(R.id.fab),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        floatingActionButton.perform(click());
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.text_note_title),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
1),
isDisplayed()));
        appCompatEditText.perform(click());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.text_note_title),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
1),
isDisplayed()));
        appCompatEditText2.perform(replaceText("T"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.text_note_title), withText("T"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
1),
isDisplayed()));
        appCompatEditText3.perform(click());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.text_note_title), withText("T"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
1),
isDisplayed()));
        appCompatEditText4.perform(click());
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.text_note_title), withText("T"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
1),
isDisplayed()));
        appCompatEditText5.perform(replaceText("Tit"));
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.text_note_title), withText("Tit"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
1),
isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.text_note_text),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
2),
isDisplayed()));
        appCompatEditText7.perform(click());
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.text_note_text),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
1),
2),
isDisplayed()));
        appCompatEditText8.perform(replaceText("Body"), closeSoftKeyboard());
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
