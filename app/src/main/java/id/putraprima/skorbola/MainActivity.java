package id.putraprima.skorbola;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int GALERY_REQUEST_CODE = 1;

    //TODO : Creating Key for Bundle
    public static final String HOME_TEAM = "hometeam";
    public static final String AWAY_TEAM = "awayteam";
    public static final String IMAGE_KEY_HOME = "imagekeyhome";
    public static final String IMAGE_KEY_AWAY = "imagekeyaway";

    //TODO : Creating Varibale
    private ImageView flaghome,flagaway;
    private EditText namehome,nameaway;
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO binding
        flaghome = findViewById(R.id.home_logo);
        flagaway = findViewById(R.id.away_logo);

        namehome = findViewById(R.id.home_team);
        nameaway = findViewById(R.id.away_team);

        //Fitur Main Activity
        //1. Validasi Input Home Team
        //2. Validasi Input Away Team
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity
    }
    public void HomeLogo(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALERY_REQUEST_CODE);
    }

    public void AwayLogo(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALERY_REQUEST_CODE);
    }

    public void HandleMatchActivity(View view) {
        String NameHome = namehome.getText().toString();
        String NameAway = nameaway.getText().toString();
        Intent intent = new Intent(this,MatchActivity.class);
        if (!NameAway.equals("") && !NameHome.equals(""))
        {
            intent.putExtra(HOME_TEAM,NameHome);
            intent.putExtra(AWAY_TEAM,NameAway);
            startActivity(intent);
        }else
            {
                Toast.makeText(this,"Harus melengkapi Data Team yang bertanding", Toast.LENGTH_SHORT).show();
            }

    }
}
