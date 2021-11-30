package com.example.lab3_5kt

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText

private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText("about")).perform(click())
}

fun openAbout() = openAboutViaOptions()