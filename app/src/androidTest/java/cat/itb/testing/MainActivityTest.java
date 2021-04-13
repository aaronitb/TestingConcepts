package cat.itb.testing;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    String USER_TO_BE_TYPED = "aaronitb";
    String PASS_TO_BE_TYPED = "123456";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void elements_on_activityMain_are_displayed() {
        onView(withId(R.id.titulo)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void elements_on_activityMain_have_the_correct_text() {
        onView(withId(R.id.titulo)).check(matches(withText("Main Activity Title")));
        onView(withId(R.id.button)).check(matches(withText("NEXT")));
    }

    @Test
    public void nexButton_is_clickable_and_changes_text_to_back_when_clicked() {
        onView(withId(R.id.button)).check(matches(isClickable()))
                .perform(click())
                .check(matches(withText("BACK")));
    }

    @Test
    public void login_form_behaviour() {
        onView(withId(R.id.editTextUsername)).perform(typeText(USER_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.button))
                .perform(click())
                .perform(replaceText("Logged"));
    }


    @Test
    public void activity_change(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
    }

    @Test
    public void activity_change_with_android_back_button(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.secondActivity)).perform(pressBack());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
    }


    @Test
    public void large_test_of_application(){
        onView(withId(R.id.editTextUsername)).perform(typeText(USER_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.titulo2)).check(matches(withText(R.string.username)));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextUsername)).perform(typeText("")).perform(closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("")).perform(closeSoftKeyboard());
    }

}
