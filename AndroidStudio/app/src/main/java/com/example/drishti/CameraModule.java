package com.example.drishti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CameraModule extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private String url="http://10.0.2.2:3000";
    private String POST="POST";
    private String GET="GET";
    public static String responseData;
    public Button helpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_module);


        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
        helpBtn = (Button)findViewById(R.id.help);
        Button photoButton = (Button) this.findViewById(R.id.capture_btn);
        photoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                    }
                    else
                    {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST);
                    }
                }
            }
        });


        //Back Button
        Button camera_back_btn = findViewById(R.id.camera_module_back_btn);
        camera_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(CameraModule.this, ModeSelection2a.class);
                startActivity(goBack);
            }
        });



    } //on create ends here

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
            TextView line =(TextView)findViewById(R.id.line);
            {
                helpBtn.setOnClickListener(view -> {
//                    sendRequest(GET,"gettext","1","1&1");
                    responseData = "Saleh";
                    Intent nextP = new Intent(this, Results1a.class);
                    startActivity(nextP);
                });
            }
            line.setText(responseData);
        }
    }


    void sendRequest(String type,String method,String paramname,String param){

        /* if url is of our get request, it should not have parameters according to our implementation.
         * But our post request should have 'name' parameter. */
        String fullURL=url+"/"+method+(param==null?"":"/"+param);
        Request request;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS).build();

        /* If it is a post request, then we have to pass the parameters inside the request body*/
        if(type.equals(POST)){
            RequestBody formBody = new FormBody.Builder()
                    .add(paramname, param)
                    .build();

            request=new Request.Builder()
                    .url(fullURL)
                    .post(formBody)
                    .build();
        }else{
            /*If it's our get request, it doen't require parameters, hence just sending with the url*/
            request = new Request.Builder()
                    .url(fullURL)
                    .build();
        }
        /* this is how the callback get handled */
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // Read data on the worker thread
                responseData = response.body().string();
                Intent nextPage = new Intent(CameraModule.this, Results1a.class);
                startActivity(nextPage);
            }

        });
    }

}