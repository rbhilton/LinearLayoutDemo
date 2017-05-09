package edu.weber.rhilton.cs3270.linearlayoutdemo;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFragAto1, btnFragAto2;
    String containerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragAto1 = (Button) findViewById(R.id.btnFragAto1);
        btnFragAto2 = (Button) findViewById(R.id.btnFragAto2);

        btnFragAto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                containerName = "Container One";
                FragmentManager fm = getSupportFragmentManager();
                FragmentA fa = (FragmentA) fm.findFragmentByTag("FA");
                if (fa != null) fm.beginTransaction().remove(fa).commit();
                fm.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container1,new FragmentA(),"FA")
                    .commit();
            }
        });

        btnFragAto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                containerName = "Container Two";
                FragmentManager fm = getSupportFragmentManager();
                FragmentA fa = (FragmentA) fm.findFragmentByTag("FA");
                if (fa != null) fm.beginTransaction().remove(fa).commit();
                fm.beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container2,new FragmentA(),"FA")
                        .commit();

                fa = (FragmentA) fm.findFragmentByTag("FA");
                Log.d("test","MainActivity fragmentFindFA: " + fa.toString());
                fa.setContainerName(containerName);
            }

        });

    }

    public String getContainerName() {
        return containerName;
    }
}
