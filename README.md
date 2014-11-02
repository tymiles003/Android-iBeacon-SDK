# Android-iBeacon-SDK

**Latio** cloud service provides a simple way to show your users content nearby iBeacon. With Android-iBeacon-SDK you can show content in your android app and outside it. Customize content in the cloud without rebuilding android app.

Install:
========

### 1. Create your own API-KEY at admin panel.


### 2. Add Android-iBeacon-SDK like a library to your Android Project


### 3. Add your API-KEY to your application in AndroidManifest.xml
```xml
<meta-data android:name="latio.ibeacon.sdk.api"
	android:value="YOUR_API_KEY"/>
```

**YOUR_API_KEY** change to your real **API-KEY**
> If you extend from Application and use it in your AndroidManifest.xml.
> You have to:
> 
- 1. Remove "android:name=".LatioApplication" from Android-iBeacon-SDK AndroidManifest.xml.
- 2. Extend your custom application from LatioApplication.

### 4. (*Optional*) Add permission to your AndroidManifest.xml:
```xml
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
```
If you added the permission, SDK may fix Android bug 67272.


#### Well done! It works!






Usage:
======
> After install, SDK is ready to work and process data through default logic.
If you want custom logic you have to implement next steps:


### Beacon events:
If you need to do some custom action with beacons. You could implement OnBeaconListener.
```java
OnBeaconListener mBeaconListener = new OnBeaconListener() {
    @Override
    public void beaconDetected(Beacon beacon, Proximity proximity) {
    }

    @Override
    public void beaconStayAtPoint(Beacon beacon, Proximity proximity) {
    }

    @Override
    public void beaconProximityChanged(Beacon beacon, boolean cameCloser, Proximity proximity) {
    }

    @Override
    public void beaconLost(Beacon beacon) {
    }
};
```

### 1. Create NearbyContentListener:
```java
NearbyContentListener myNearbyContentListener = new NearbyContentListener() {

    @Override
    public void contentAppeared(NearbyContent content, Proximity proximity) {
    }

    @Override
    public void contentUpdated(NearbyContent content, Proximity proximity) {
    }

    @Override
    public void contentDisappeared(NearbyContent content) {
    }
}
```


### 2. Сall to default logic by super method.
Example for beaconContentAppeared:
            
```java
@Override
public void contentAppeared(NearbyContent content) {
	super.beaconContentAppeared(content, Proximity proximity);

	// your code
}
```


### 3. Set your NearbyContentListener to NearbyContentManager:
NearbyContentManager.getInstance().setListener(myNearbyContentListener);


### 4. You can get custom json data from content.
Example:
```java
@Override
public void contentAppeared(NearbyContent content) {
        JSONObject data = content.getData();

        // your code
}
```


### 5. User data:
For Appointment and for another functional when you need to get user info, you can provide it.
```java
User.getInstance().provideId("USER_ID");
User.getInstance().provideName("USER_NAME");
User.getInstance().provideEmail("USER_EMAIL");
User.getInstance().provideAvatar("USER_AVATAR");
```


### 6. Custom Latio scanner notification:
```java
ScannerNotification.getInstance().setIconId(R.drawable.ic_mylogo);
ScannerNotification.getInstance().setTitleId(R.string.notification_title);
ScannerNotification.getInstance().setBodyId(R.string.notification_body);
ScannerNotification.getInstance().setActivity("com.myapp.MyActivity");
```

License
--
New BSD
