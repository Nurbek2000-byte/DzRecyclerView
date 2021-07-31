package com.example.dzrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    EditText etTitle,etDescription;
    Button btnSaveText;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main2);
        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_desciption);
        btnSaveText = findViewById(R.id.btn_save_text);
        btnSaveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                if (!title.isEmpty() && !description.isEmpty()){
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    intent.putExtra("title",title);
                    intent.putExtra("description",description);
                    setResult(RESULT_OK, intent);
                    Log.e("TAG","onClick" + title + description );
                    finish();
                }else {
                    etTitle.setError("Введите Title");
                    etDescription.setError("Введите Desc");
                }
            }
        });
    }
}
