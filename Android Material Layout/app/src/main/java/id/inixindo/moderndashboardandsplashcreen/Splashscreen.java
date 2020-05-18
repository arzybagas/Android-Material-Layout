package id.inixindo.moderndashboardandsplashcreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {
    ImageView imgInix, imgLogo;
    TextView textSlogan;
    Animation topAnim, bottomAnim, clockAnim;
    private int duration = 2000; //satuan millisecond
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //set full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgInix = findViewById(R.id.iv_inix);
        textSlogan = findViewById(R.id.tv_slogan);
        imgLogo = findViewById(R.id.iv_logo);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        clockAnim = AnimationUtils.loadAnimation(this, R.anim.clock_anim);


        imgInix.setAnimation(topAnim);
        textSlogan.setAnimation(bottomAnim);
        imgLogo.setAnimation(clockAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },duration);

    }
}

