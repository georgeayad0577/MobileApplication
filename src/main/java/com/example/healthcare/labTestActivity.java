package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.HashMap;

public class labTestActivity extends AppCompatActivity {
    private String[][] packages =
    {
        {"package 1 : Full Body Checkup", "", "", "", "999"},
        {"package 2 : Blood Glucose Fasting", "", "", "", "299"},
        {"package 3 : COVID-19 Antibody -IgG", "", "", "", "899"},
        {"package 4 : Thyroid Check", "", "", "", "499"},
        {"package 5 : Immunity Check", "", "", "", "699"}
    };
    private String[] package_details= {
    "blood Glucose Fasting\n" +
             "Complete Hemogram\n" +
             "HbA1c\n" +
             "Iron Studies\n"+
             "Kidney Function Test\n" +
             "LDH Lactate Dehydrogenase\n" +
             "Lipid Profile \n" +
             "Liver Function Test",
    "blood Glucose Fasting",
    "COVID-19 Antibody - IgG",
    "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
    "Complete Hemogram\n" +
            "CRP (C Reactive Protein) Quantitative, Serum\n" +
            "Iron Studies\n" +
            "Kidney Function Test\n" +
            "Vitamin D Total-25 hydroxy\n" +
            "Liver Function Test\n" +
            "lipid Profile"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBMDAddToCart);
        btnBack = findViewById(R.id.buttonBMDBack);
        listView = findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(labTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "total Cost:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e,});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i,long l) {
                Intent it = new Intent(labTestActivity.this, labTestDetailsActivity.class);
                it.putExtra("text1",packages[1][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });


        btnGoToCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(labTestActivity.this,CartLabActivity.class));
            }
        });
    }
}//2:50:29