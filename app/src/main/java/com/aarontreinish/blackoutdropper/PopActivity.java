package com.aarontreinish.blackoutdropper;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class PopActivity extends Activity {


    Button btn_close;
    public static TextView textView;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        int randomLocation = (int) (Math.random() * dropLocations.length);
        System.out.println(dropLocations[randomLocation]);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(dropLocations[randomLocation]);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Call of Ops Duty.otf");
        textView.setTypeface(typeface);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.3));


        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }

    final String[] dropLocations = {"Construction Site", "Nuketown Island", "Array", "Cargo Docks", "Estates", "Hydro Dam", "Train Station", "Firing Range", "Rivertown", "Fracking Tower", "Factory", "Asylum", "Turbine"};



}
