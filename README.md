# Trying Couchbase Lite Android

This is the simplest code for CRUD using Couchbase Lite on Android.

Entire thing is written in [`PlaceholderFragment`](app/src/main/java/com/iraycd/testcouchdblite/MainActivity.java#L68) inside
[`MainActivity.java`](app/src/main/java/com/iraycd/testcouchdblite/MainActivity.java)


*Note:* This is really simple thing. Just for reference and getting started.

## Thing you may use from here:

### [`DatabaseWrapper.java`](app/src/main/java/com/iraycd/testcouchdblite/models/DatabaseWrapper.java)


# Extra Things which can implement and can be used.

### [`Keys.java`](app/src/main/java/com/iraycd/testcouchdblite/utils/Keys.java)

    package com.iraycd.testcouchdblite.utils;
    public class Keys {
      public static final String DB_NAME = "testdb";
      public static final String KEY_MAIL = "email";
      public static final String KEY_REG = "registered";
      public static final String KEY_SCORES = "scores";

    }


This is how I stored the keys.

### Things which I have used. Not necessarily but can be used

[`ErrorChecker.java`](app/src/main/java/com/iraycd/testcouchdblite/utils/ErrorChecker.java)


## How to run the application
1. Use Android Studio.
2. Run the application.
3. You will see the output.

![](img/screen_shot.png)

## Understand the code. Now :smiley:
