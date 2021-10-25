package id.vidya.menumakansqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNamaMakanan;
    Button btnTambahMakanan;
//    Button btnResetAll;
    RecyclerView rvMenu;
    DBHandler dbHandler;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNamaMakanan = findViewById(R.id.edtNamaMakanan);
        btnTambahMakanan = findViewById(R.id.btnTambahMakanan);
//        btnResetAll = findViewById(R.id.btnResetAll);
        rvMenu = findViewById(R.id.rvMenu);

        dbHandler = new DBHandler(MainActivity.this);
        adapter =  new MainAdapter(MainActivity.this, dataList);
        linearLayoutManager =  new LinearLayoutManager(this);

        rvMenu.setLayoutManager(linearLayoutManager);

        rvMenu.setAdapter(adapter);
        btnTambahMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = edtNamaMakanan.getText().toString().trim();
                if(!sName.equals("")){
                    MainData data = new MainData();
                    data.setName(sName);
                    dbHandler.addMakanan(data);
                    edtNamaMakanan.setText("");
                    dataList.clear();
                    dataList.addAll(dbHandler.getAllData());
                    adapter.notifyDataSetChanged();
                }
            }
        });

//        btnResetAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                database.mainDao().reset(dataList);
//                dataList.clear();
//                dataList.addAll(database.mainDao().getAll());
//                adapter.notifyDataSetChanged();
//            }
//        });
    }
}