package com.example.asusmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static SeekBar seek_bar;
    private static TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //downloadImageFromPath();

        readSeekBar();
    }
    /*
    public void downloadImageFromPath() {
        InputStream in = null;
        Bitmap bmp = null;
        ImageView iv = (ImageView)findViewById(R.id.imageView);
        int responseCode = -1;
        try {
            URL url = new URL("http://theinspirationblog.net/wp-content/uploads/2012/11/PIKACHU-PIXEL1.jpg"); //"http://192.xx.xx.xx/mypath/img1.jpg
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.connect();
            responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                //download
                in = con.getInputStream();
                bmp = BitmapFactory.decodeStream(in);
                in.close();
                iv.setImageBitmap(bmp);
                setContentView(R.id.imageView);
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "NOT OK", Toast.LENGTH_SHORT).show();
        }
        catch(Exception ex){
            Log.e("Exception", ex.toString());
        }
    }
    */
    public void readSeekBar() {
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        text_view = (TextView)findViewById(R.id.textView3);
        text_view.setText("Current");
        ImageView img1 = (ImageView) findViewById(R.id.imageView);
        img1.setImageResource(R.drawable.xmw1);

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;

                ImageView img = (ImageView) findViewById(R.id.imageView);

                if (progress >= 0 && progress < 10 ) {
                    text_view.setText("In the past week");
                    img.setImageResource(R.drawable.xmw1);
                }
                if (progress >= 11 && progress < 20) {
                    text_view.setText("Two weeks ago");
                    img.setImageResource(R.drawable.xmw2);
                }
                if (progress >= 21 && progress < 30) {
                    text_view.setText("Three weeks ago");
                    img.setImageResource(R.drawable.xmw3);
                }
                if (progress >= 31 && progress < 40) {
                    text_view.setText("One month ago");
                    img.setImageResource(R.drawable.xmw4);
                }
                if (progress >= 41 && progress < 50) {
                    text_view.setText("Three months ago");
                    img.setImageResource(R.drawable.xmw5);
                }
                if (progress >= 51 && progress < 60) {
                    text_view.setText("Six months ago");
                    img.setImageResource(R.drawable.xmw6);
                }
                if (progress >= 61 && progress < 70) {
                    text_view.setText("Nine months ago");
                    img.setImageResource(R.drawable.xmw7);
                }
                if (progress >= 71 && progress < 80){
                    text_view.setText("One year ago");
                    img.setImageResource(R.drawable.xmw1);
                }
                if (progress >= 81 && progress < 100){
                    text_view.setText("Three years ago");
                    img.setImageResource(R.drawable.xmw2);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }
}
