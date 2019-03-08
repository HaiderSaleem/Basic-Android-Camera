package com.example.mhaidersaleem.camera;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class flash extends AppCompatActivity {

    Button button;

    Boolean light=true;

    CameraDevice cameraDevice;

    private CameraManager cameraManager;

    private CameraCharacteristics cameraCharacteristics;

    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button=(Button)findViewById(R.id.flash);
        cameraManager = (CameraManager)
                getSystemService(getApplicationContext().CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(light){
                    try {

                        cameraManager.setTorchMode(cameraId,true);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                    light=false;}
                else {

                    try {

                        cameraManager.setTorchMode(cameraId,false);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }


                    light=true;
                }


            }
        });
    }
}
