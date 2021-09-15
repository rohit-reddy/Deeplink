# Deeplink

Testing Your Deep Links

You’ll use the Android Debug Bridge, or ADB, shell commands to test the deep link flow. That is, you’ll check if the link navigates to the correct section of your app.

Open your terminal and paste in the following command:

adb shell am start -W -a android.intent.action.VIEW -d "https://www.rohitreddy.com/test?code=abcde"

This command starts the ADB shell with the VIEW action and specifies the deep link URL.

Handling Deep Links When the User Doesn’t Have Your App Installed.

Added support for Firebase Dynamic Deeplinks.
