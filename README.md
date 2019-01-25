# Android-Individual-App--CMPE-277
 
# Project Problem Statement: 

Location Tracker is a most basic and easiest way of tracking family and friends via Android App. This App fetches the real time location of the user and shows the location on Map. It helps your loved ones to track you and take actions f there is any emergency. This incredible app can locate accurate positions instantly. This helps to know that family, friends and especially your kids are safe everywhere and at every point in time. This app will fetch your current location and address on a click of Button. 

# Screenshots

![untitled](https://user-images.githubusercontent.com/31361652/38788996-1c323d30-40ec-11e8-884d-094226595052.png)

![untitled2](https://user-images.githubusercontent.com/31361652/38788999-2141716a-40ec-11e8-98af-d8b0d7bee76a.png)


# Get a Google Maps API key

Go to https://developers.google.com/maps/documentation/ios-sdk/get-api-key and https://developers.google.com/maps/documentation/android-api/signup to get your keys for both iOS and Android.

Make sure that Google Maps Android API and Google Maps SDK for iOS are enabled for the current project. https://console.developers.google.com/apis/library/maps-android-backend.googleapis.com/ https://console.developers.google.com/apis/library/maps-ios-backend.googleapis.com

Without an API key the Google Maps map won't render anything.

### How it works?
![firebase](https://user-images.githubusercontent.com/31361652/38167172-bf4b498e-34e5-11e8-9028-4bcbdfb907b3.png)



- The first device get continous location update from gps, network etc. then
- Write and update the location data to a specific firebase firestore document
- Last, the second device read that firebase firestore document and show the marker in that location

# Features:

1.	Sign up form for new user to create an account. A new user record is created in Google Firebase. If an already existing user tries to sign up, he is prevented in doing the same.

2.	 Login Page to allow only authorized users to login. Performs validation for username and password match.
 
3.	Home Page where users can check current location and check current location in map.

4.	Map Activity shows current location on Google maps.

# Technology Used:

1.	Android Studio 2.3 java

2.	Firebase as database for tracking real time location
 
3.	Android SDK version- Android 4.4 (Kitkat)

4.	Android Plugin Version 3.0.1

5.	Android Gradle version 4.1

6.	Material Design for UI componets.


# Future Enhancements

1. Add more features for tracking Anomoly when the location is unusual.
