package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    public static final String HOME_TEAM = "hometeam";
    public static final String AWAY_TEAM = "awayteam";
    public static final String DRAW_RESULT = "draw";
    public static final String RESULT = "result";
    public static final String IMAGE_KEY_HOME = "imagekeyhome";
    public static final String IMAGE_KEY_AWAY = "imagekeyaway";
    private TextView namehome,nameaway;
    private int homeScore = 0 ,awayScore = 0 ;
    private TextView homeScoretxt,awayScoretxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO Binding
        namehome = findViewById(R.id.txt_home);
        nameaway = findViewById(R.id.txt_away);

        homeScoretxt = (TextView) findViewById(R.id.score_home);
        awayScoretxt = (TextView) findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            //TODO : display value here
            namehome.setText(extras.getString(HOME_TEAM));
            nameaway.setText(extras.getString(AWAY_TEAM));
        }
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
    public void handleAddHomeScore(View view) {
        homeScore++;
        homeScoretxt.setText(Integer.toString(homeScore));
    }

    public void handleAddAwayScore(View view) {
        awayScore++;
        awayScoretxt.setText(Integer.toString(awayScore));
    }

    public void handleResult(View view) {
        String NameHome = namehome.getText().toString();
        String NameAway = nameaway.getText().toString();
        String Draw = " : HASIL NYA DRAW";
        Intent intent = new Intent(this,ResultActivity.class);
        if( awayScore > homeScore )
        {
            intent.putExtra(RESULT,NameAway);
            startActivity(intent);
        }
        else if( awayScore < homeScore )
        {
            intent.putExtra(RESULT,NameHome);
            startActivity(intent);
        }else
            {
                intent.putExtra(RESULT,Draw);
                startActivity(intent);
            }
    }
}
