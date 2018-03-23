package dd.fanxinhua.com.xiongmaotv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TopBar topbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topbar=findViewById(R.id.topbar);
        topbar.setOnTopBarListener(new TopBar.TopBarListener() {
            @Override
            public void leftOnClick() {
                Toast.makeText(MainActivity.this,"点击左侧",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightOnClick() {
                Toast.makeText(MainActivity.this,"点击右侧",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
