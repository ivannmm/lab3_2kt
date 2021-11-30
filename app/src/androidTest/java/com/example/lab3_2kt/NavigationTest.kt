package com.example.lab3_5kt

import android.content.pm.ActivityInfo
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lab3_2kt.ActivityFirst
import com.example.lab3_2kt.R
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @Test
    fun testAbout() {
        launchActivity<ActivityFirst>()
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest1() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest2() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest3() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity1))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest4() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity1))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest5() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))

        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.pressBack()
        Espresso.onView(withId(R.id.activity1))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest6() {
        val activity = launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))

        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))

        activity.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(3000)

        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))

        activity.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(3000)

        Espresso.onView(withId(R.id.activity3))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest7() {
        val activity = launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())

        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToThird))
            .check(matches(isDisplayed()))

        activity.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(3000)

        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToThird))
            .check(matches(isDisplayed()))

        activity.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(3000)

        Espresso.onView(withId(R.id.activity2))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToThird))
            .check(matches(isDisplayed()))
    }

    @Test
    fun myTest8() {
        val activity = launchActivity<ActivityFirst>()

        Espresso.onView(withId(R.id.activity1))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))

        activity.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(3000)

        Espresso.onView(withId(R.id.activity1))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))

        activity.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(3000)

        Espresso.onView(withId(R.id.activity1))
            .check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))
    }

    @get:Rule
    val activityScenario = ActivityScenarioRule(ActivityFirst::class.java)

    // Backstack test

    @Test
    fun myTest9() {
        launchActivity<ActivityFirst>()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun myTest10() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun myTest11() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun myTest12() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun myTest13() {
        launchActivity<ActivityFirst>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun myTest14() {
        launchActivity<ActivityFirst>()
        openAbout()
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun myTest15() {
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        Assert.assertTrue(activityScenario.scenario.state != Lifecycle.State.DESTROYED)
    }

    /**

    @Test
    fun myTest16() {
        try {
            Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
                .perform(
                    click()
                )
            assert(false)
        } catch (e: Exception) {
            assert(true)
        }
    }

    @Test
    fun myTest17() {
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Thread.sleep(3000)
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        myTest16()
    }

    @Test
    fun myTest18() {
        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())

        Espresso.onView(withId(R.id.activity2)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity1)).check(matches(isDisplayed()))

        myTest16()
    }

    @Test
    fun myTest19() {
        openAbout()
        Espresso.onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity1)).check(matches(isDisplayed()))
        myTest16()

        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity2)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity1)).check(matches(isDisplayed()))
        myTest16()


        Espresso.onView(withId(R.id.bnToSecond)).perform(click())
        Espresso.onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity3)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity2)).check(matches(isDisplayed()))
        Espresso.onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        Espresso.onView(withId(R.id.activity1)).check(matches(isDisplayed()))
        myTest16()
    }*/
}