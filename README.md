# PracticeTest-Coding-Challenge

A sample project for Cucumber and/or Selenium tests.

# Assumptions
- In the current Amazon AU filter options were missing: Screen size: 26 in and above and Resolution: 4k UHD
  Hence have used Up to 32 in, 4K and 1080p as screensize and resolution
- Have used basic cucumber version of html report, There is still a scope to use custom report - Allure or Extent Reports
- Need to work on wait/syncronisation in one of the places, have used Thread.sleep() 

# Instructions

Clone the repo:

Git:
```
$ git clone git@github.com:arjunbharadwajOS/webpracticetest.git
```

Or download a ZIP of master [manually](https://github.com/arjunbharadwajOS/webpracticetest/archive/refs/heads/feature/ArjunBharadwaj-PracticeTest.zip) and expand the contents on your system

# Feature Branch: feature/ArjunBharadwaj-PracticeTest

## Prerequisites

In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system.

(TODO after testing on Windows)

## Verify installation

## Use Maven

Open a command window and run:

    mvn test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `RunCukesTest`
class tells JUnit to kick off Cucumber.

This runs Cucumber features using Cucumber's Command Line Interface (CLI) runner. Note that the `RunCukesTest` junit class is not used at all.
If you remove it (and the `cucumber-junit` jar dependency), it will run just the same.

## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.options="..." test

Let's look at some things you can do with `cucumber.options`. Try this:

    -Dcucumber.options="--help"

That should list all the available options.
