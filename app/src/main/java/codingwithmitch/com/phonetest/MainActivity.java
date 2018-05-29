package codingwithmitch.com.phonetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    //vars
    private int mDisplayHeight, mDisplayWidth;
    private float mAspectRatio;
    private String mDeviceInfo, mDisplayProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDisplayProperties();
        getDeviceInfo();
        printReport();
    }

    private void getDisplayProperties(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        mDisplayHeight = height;
        mDisplayWidth = width;
        mAspectRatio = (float)mDisplayHeight / (float)mDisplayWidth;

        mDisplayProperties = "";
        mDisplayProperties += "\n Display Width: " + mDisplayWidth;
        mDisplayProperties += "\n Display Height: " + mDisplayHeight;
        mDisplayProperties += "\n Aspect Ratio: " + mAspectRatio;
    }

    private void getDeviceInfo(){
        mDeviceInfo = "";
        mDeviceInfo += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        mDeviceInfo += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        mDeviceInfo += "\n Device: " + android.os.Build.DEVICE;
        mDeviceInfo += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
    }

    private void printReport(){
        Log.d("", "----------- Device Information ----------- \n" + mDeviceInfo);
        Log.d("", "----------- Display Properties ----------- \n" + mDisplayProperties);
    }
}















