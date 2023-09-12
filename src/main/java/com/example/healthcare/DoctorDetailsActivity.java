package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Arwa Saad", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "600"},
                    {"Doctor Name : George Ayad", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "900"},
                    {"Doctor Name : Sherif Aly", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "300"},
                    {"Doctor Name : Shaima Ragab", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "500"},
                    {"Doctor Name : blabsyo", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "800"},
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam patil", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "600"},
                    {"Doctor Name : Swati Pawar", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "900"},
                    {"Doctor Name : Neeraja kale", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "300"},
                    {"Doctor Name : Mayrui Deshmukh", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "500"},
                    {"Doctor Name : Minakshi Panda", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "800"},
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Seema Patil", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "600"},
                    {"Doctor Name : Pnkaj Parab", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "900"},
                    {"Doctor Name : Monish jain", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "300"},
                    {"Doctor Name : Vishal Deshmukh", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "500"},
                    {"Doctor Name : Shrikant Panda", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "800"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Amlo Gawade", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "600"},
                    {"Doctor Name : Prasead Pawar", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "900"},
                    {"Doctor Name : Nilesh Kale", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "300"},
                    {"Doctor Name : Deepak deshpande", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "500"},
                    {"Doctor Name : ashok Singh", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "800"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Nilesh Borate", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "600"},
                    {"Doctor Name : Pawkaj Pawar", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "900"},
                    {"Doctor Name : Swapnil Lele", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "300"},
                    {"Doctor Name : Deepak Kumar", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "500"},
                    {"Doctor Name : Ankul panda", "Hospital Address : $$", "Exp : 5yrs", "Mobile no:01000000000", "800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewBMDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}
