package com.example.jeong_woochang.kingofstudy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PediaActivity extends AppCompatActivity {

    static final String[] ListMenu={"LIST1","LIST2","LIST3","LIST4"};
    private ArrayAdapter subjectAdapter, gradeAdapter,searchAdapter;
    private Spinner subjectSpinner, gradeSpinner,searchSpinner;
    Button writeButton;

    private String Subject="";
    private String Grade="";
    private String Content="";
    private String Title="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedia);

        writeButton=(Button)findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PediaActivity.this,WriteActivity.class);
                startActivity(intent);
            }
        });

        subjectSpinner=(Spinner)findViewById(R.id.subjectSpinner);
        gradeSpinner=(Spinner)findViewById(R.id.gradeSpinner);
        searchSpinner=(Spinner)findViewById(R.id.searchSpinner);

        subjectAdapter=ArrayAdapter.createFromResource(this,R.array.subject,android.R.layout.simple_dropdown_item_1line);
        subjectSpinner.setAdapter(subjectAdapter);

        gradeAdapter=ArrayAdapter.createFromResource(this,R.array.grade,android.R.layout.simple_dropdown_item_1line);
        gradeSpinner.setAdapter(gradeAdapter);

        searchAdapter=ArrayAdapter.createFromResource(this,R.array.search,android.R.layout.simple_dropdown_item_1line);
        searchSpinner.setAdapter(searchAdapter);
        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.bulletinListView);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_box_black_24dp),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_assignment_ind_black_24dp),
                "Ind", "Assignment Ind Black 36dp") ;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;

                // TODO : use item data.

            }
        });
    }
}
