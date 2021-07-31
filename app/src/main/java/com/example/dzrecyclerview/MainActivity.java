package com.example.dzrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BookAdapter bookAdapter;
    Button btnOpenActivityTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenActivityTwo = findViewById(R.id.btn_open_activity_two);
        recyclerView =findViewById(R.id.recycler);
        List<BookModel> list = new ArrayList<>();
        list.add(new BookModel("hhhhh","gdsdgsdg"));
        bookAdapter = new BookAdapter(list);
        recyclerView.setAdapter(bookAdapter);

        btnOpenActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK){
            if (data !=null){
                BookModel bookModel = new BookModel(data.getStringExtra("title"), data.getStringExtra("description"));
                Toast.makeText(this,"" + data.getStringExtra("title")
                        + data.getStringExtra("description"), Toast.LENGTH_SHORT).show();
                bookAdapter.addTask(bookModel);
            }
        }
    }
}