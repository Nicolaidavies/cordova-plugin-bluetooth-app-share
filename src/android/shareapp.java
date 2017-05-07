package io.nicolai.shareapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CallbackContext; //
import org.apache.cordova.CordovaInterface; // 
import org.apache.cordova.CordovaPlugin; // 
import org.apache.cordova.CordovaWebView; //
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class shareapp extends CordovaPlugin {
  BluetoothAdapter mBluetoothAdapter;
  String TAG = "BT TRANSFER";
  Integer REQUEST_ENABLE_BT = 0;
  
  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView); 
  }

  @Override
  public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if ("share".equals(action)) {
        
        sendAPK(args.getString(0));

        callbackContext.success();

        return true;
    } 
    return false;
  }

  private void sendAPK (String fileName) {
        try {
            ApplicationInfo app = getApplicationContext().getApplicationInfo();
            String filePath = app.sourceDir;

            File apk = new File(filePath);
            
            File outputFile = new File(getExternalFilesDir(null), fileName + ".apk");

            copy(apk, outputFile);


            Intent intent = new Intent(Intent.ACTION_SEND);
            // MIME of .apk is "application/vnd.android.package-archive".
            // but Bluetooth does not accept this. Let's use "*/*" instead.
            intent.setType("*/*");
            // Only use Bluetooth to send .apk
            intent.setPackage("com.android.bluetooth");
            // Append file and send Intent
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(outputFile));
            startActivity(Intent.createChooser(intent, "Share app"));
        } catch (IOException e) {
            Log.d(TAG, e.toString());
        }
    }

    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
