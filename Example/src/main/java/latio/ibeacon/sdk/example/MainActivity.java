package latio.ibeacon.sdk.example;

import android.app.Activity;
import android.os.Bundle;

import latio.ibeacon.sdk.beacon.BeaconManager;
import latio.ibeacon.sdk.beacon.OnBeaconListener;
import latio.ibeacon.sdk.beacon.data.Beacon;
import latio.ibeacon.sdk.content.NearbyContentListener;
import latio.ibeacon.sdk.content.NearbyContentManager;
import latio.ibeacon.sdk.content.data.NearbyContent;
import latio.ibeacon.sdk.content.data.Proximity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BeaconManager.getInstance().setListener(mBeaconListener);
        NearbyContentManager.getInstance().setListener(mNearbyContentListener);
    }

    private final OnBeaconListener mBeaconListener = new OnBeaconListener() {
        @Override
        public void beaconDetected(Beacon beacon, Proximity proximity) {
            // TODO: implement
        }

        @Override
        public void beaconStayAtPoint(Beacon beacon, Proximity proximity) {
            // TODO: implement
        }

        @Override
        public void beaconProximityChanged(Beacon beacon, boolean cameCloser, Proximity proximity) {
            // TODO: implement
        }

        @Override
        public void beaconLost(Beacon beacon) {
            // TODO: implement
        }
    };

    private final NearbyContentListener mNearbyContentListener = new NearbyContentListener() {
        @Override
        public void contentAppeared(NearbyContent nearbyContent, Proximity proximity) {
            super.contentAppeared(nearbyContent, proximity);
            // TODO: implement
        }

        @Override
        public void contentProximityChanged(NearbyContent nearbyContent, Proximity proximity) {
            super.contentProximityChanged(nearbyContent, proximity);
            // TODO: implement
        }

        @Override
        public void contentDisappeared(NearbyContent nearbyContent) {
            super.contentDisappeared(nearbyContent);
            // TODO: implement
        }
    };
}
