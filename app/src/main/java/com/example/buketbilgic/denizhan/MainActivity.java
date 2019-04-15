package com.example.buketbilgic.denizhan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_tikla;
    ListView lv_listele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_tikla=(Button)findViewById(R.id.btn_tikla);
        lv_listele=(ListView)findViewById(R.id.lv_Listele);

        btn_tikla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DT VT=new DT(MainActivity.this);
                Date currentTime = Calendar.getInstance().getTime();
                VT.dataADD(currentTime.toString());
                List<String> kayitlar =VT.dataList();
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.activity_list_item,android.R.id.text1,kayitlar);
                lv_listele.setAdapter(adapter);
            }
        });


    }
}
