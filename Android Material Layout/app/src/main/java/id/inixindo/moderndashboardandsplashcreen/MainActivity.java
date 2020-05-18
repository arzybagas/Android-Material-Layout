package id.inixindo.moderndashboardandsplashcreen;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView greetImg;
    TextView greetText;
    CardView cvMobil, cvMotor, cvMakan, cvAntar, cvPulsa, cvTiket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetImg = findViewById(R.id.greeting_img);
        greetText = findViewById(R.id.greeting_text);

        cvMakan = findViewById(R.id.cv_makan);
        cvMobil = findViewById(R.id.cv_mobil);
        cvMotor = findViewById(R.id.cv_motor);
        cvTiket = findViewById(R.id.cv_tiket);
        cvPulsa = findViewById(R.id.cv_pulsa);
        cvAntar = findViewById(R.id.cv_antar);

        cvMakan.setOnClickListener(this);
        cvMobil.setOnClickListener(this);
        cvMotor.setOnClickListener(this);
        cvTiket.setOnClickListener(this);
        cvPulsa.setOnClickListener(this);
        cvAntar.setOnClickListener(this);

        greeting();
    }
    void greeting() {
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            greetText.setText("Selamat Pagi\nInixindo");
            greetImg.setImageResource(R.drawable.img_default_half_morning);
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            greetText.setText("Selamat Siang\nInixindo");
            greetImg.setImageResource(R.drawable.img_default_half_afternoon);
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            greetText.setText("Selamat Sore\nInixindo");
            greetImg.setImageResource(R.drawable.img_default_half_without_sun);
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            greetText.setText("Selamat Malam\nInixindo");
            greetText.setTextColor(Color.WHITE);
            greetImg.setImageResource(R.drawable.img_default_half_night);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_mobil:
                showSnackBar(v,"Kuy Mobil");
                break;
            case R.id.cv_motor:
                showSnackBar(v,"Kuy Motor");
                break;
            case R.id.cv_makan:
                showSnackBar(v,"Kuy Makan");
                break;
            case R.id.cv_antar:
                showSnackBar(v,"Kuy Antar Barang");
                break;
            case R.id.cv_tiket:
                showSnackBar(v,"Kuy Ticket Bioskop");
                break;
            case R.id.cv_pulsa:
                showSnackBar(v,"Kuy Pulsa");
                break;
        }
    }

    void showSnackBar(View v, final String text){
        Snackbar snackbar = Snackbar.make(v,"Klik PESAN! untuk memesan", Snackbar.LENGTH_LONG);
        snackbar.setAction("PESAN!", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Berhasil Memesan "+text, Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
