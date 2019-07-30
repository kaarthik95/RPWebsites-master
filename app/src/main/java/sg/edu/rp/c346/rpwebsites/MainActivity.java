package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spin1, spin2;
    Button btnGo;
    TextView tv1, tv2;
    ArrayList<String> alweblist;
    ArrayAdapter<String> aawebarray;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.button);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);

        alweblist = new ArrayList<>();
        aawebarray = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alweblist);

        spin2.setAdapter(aawebarray);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                alweblist.clear();

                if (position == 0) {
                    String[] cat = getResources().getStringArray(R.array.subcat1);
                    alweblist.addAll(Arrays.asList(cat));
                    aawebarray.notifyDataSetChanged();
                } else {
                    String[] subcat = getResources().getStringArray(R.array.subcat2);
                    alweblist.addAll(Arrays.asList(subcat));
                    aawebarray.notifyDataSetChanged();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (spin2.getSelectedItem().equals("Homepage"))
                {
                    url = "https://www.youtube.com/";
                }
                else if (spin2.getSelectedItem().equals("Student Life"))
                {
                    url = "https://www.rp.edu.sg/student-life";
                }
                else if (spin2.getSelectedItem().equals("DMSD"))
                {
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                }
                else if (spin2.getSelectedItem().equals("DIT"))
                {
                    url = "https://www.google.com/";
                }
                else
                {
                    url = "";
                }

                Intent intent = new Intent(MainActivity.this,WebBrowser.class);
                intent.putExtra("link",url);
                startActivity(intent);
            }
        });

    }
}
