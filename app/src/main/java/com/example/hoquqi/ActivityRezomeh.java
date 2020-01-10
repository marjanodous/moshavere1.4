package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoquqi.dataBase.Database;

import java.io.ByteArrayInputStream;

public class ActivityRezomeh extends AppCompatActivity {

    public byte[] IMG;
    TextView txtname, txtpass, txtmail, txtphone, txtsabegheh, txtmadrak, txtrotbeh, txtadress, txtrezomeh;
    ImageView imageView, imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezume);

        imageView = findViewById(R.id.img_rezume);
        txtname = findViewById(R.id.name_moshaver_zezume);
        txtrotbeh = findViewById(R.id.paye_hoquqi_moshaver_list);
        txtmadrak = findViewById(R.id.madrak_hoquqi_moshaver);
        txtsabegheh = findViewById(R.id.txt_sabeqe_rezume);
        txtrezomeh = findViewById(R.id.txt_rezume_rezume);
        txtadress = findViewById(R.id.txt_address_rezume);
        txtphone = findViewById(R.id.txt_phone_rezume);
        txtmail = findViewById(R.id.txt_email_rezume);
        imgBack = findViewById(R.id.img_back);


        Bundle bundle = getIntent().getExtras();
        IMG = bundle.getByteArray("pic");
        ByteArrayInputStream imageStream = new ByteArrayInputStream(IMG);
        Bitmap recource = BitmapFactory.decodeStream(imageStream);
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getApplication().getResources(),
        Bitmap.createScaledBitmap(recource, 50, 50, false));
        drawable.setCircular(true);
        imageView.setImageDrawable(drawable);
//        int id = bundle.getInt("id");
//        Moshaver moshaver = new Moshaver();
//        moshaver = Database.getDataPic(id, getApplicationContext());
//        IMG = moshaver.getmImage();
//        ByteArrayInputStream imageStream = new ByteArrayInputStream(IMG);
//        Bitmap recource = BitmapFactory.decodeStream(imageStream);
//        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getApplication().getResources(),
//        Bitmap.createScaledBitmap(recource,50,50,false));
//        drawable.setCircular(true);
//        imageView.setImageDrawable(drawable);

        txtname.setText(bundle.getString("name"));
        txtrotbeh.setText(bundle.getString("rotbeh"));
        txtmadrak.setText(bundle.getString("madrak"));
        txtsabegheh.setText(bundle.getString("sabegheh"));
        txtrezomeh.setText(bundle.getString("rezomeh"));
        txtadress.setText(bundle.getString("adrres"));
        txtphone.setText(bundle.getString("phone"));
        txtmail.setText(bundle.getString("email"));


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
