Android-iBeacon-SDK
===================

Install:

Create your own API-KEY at admin panel
Download Latio-iBeacon-Android-SDK
Add Latio-iBeacon-SDK like a library to your Android Project
(В ПЕНЬ) Set LatioApplication to your AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application android:name=”latio.ibeacon.sdk.LatioApplication”>

    </application>
</manifest>

If you have your custom application, you have to extends from LatioApplication, than set your application in AndroidManifest.xml

Add your API-KEY to your AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application>

        <meta-data android:name="latio.ibeacon.sdk.api"
                   android:value="YOUR_API_KEY"/>
    </application>
</manifest>
YOUR_API_KEY change to your real API-KEY

(Optional) Add permission to your AndroidManifest.xml:
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>

    <application>

        <meta-data android:name="latio.ibeacon.sdk.api"
                   android:value="YOUR_API_KEY"/>
    </application>
</manifest>

you add this permission SDK may fix some Android Bluetooth bugs.




Usage:

After install, SDK is ready to work and process data through default logic.
If you want custom logic you have to implement next steps:

Create NearbyContentListener:
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

You can call to default logic by super method. 
            Example for beaconContentAppeared:
	@Override
    	public void contentAppeared(NearbyContent content) {
	    super.beaconContentAppeared(content, Proximity proximity);

	    // your code
   	}

Set your NearbyContentListener to NearbyContentManager like this:
NearbyContentManager.getInstance().setListener(myNearbyContentListener);

You can get custom json data from content. 
Example:
@Override
public void contentAppeared(NearbyContent content) {
        JSONObject data = content.getData();

        // your code
}

For Appointment functional you have to provide userId:
User.getInstance().provideUserId("USER_ID");
If you wanna custom Latio scanner notification you can do it:
ScannerNotification.getInstance().setIconId(R.drawable.ic_mylogo);
ScannerNotification.getInstance().setTitleId(R.string.notification_title);
ScannerNotification.getInstance().setBodyId(R.string.notification_body);
ScannerNotification.getInstance().setActivity("com.myapp.MyActivity");

