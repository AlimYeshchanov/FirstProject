package com.example.learnwordseasily;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextWord;
    private EditText editTextMeaning;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        editTextWord = findViewById(R.id.editTextWord);
        editTextMeaning = findViewById(R.id.editTextMeaning);
    }

    public void onClickSaveNote(View view) {
        String word = editTextWord.getText().toString().trim();
        String meaning = editTextMeaning.getText().toString().trim();
        if (isFilled(word, meaning)) {
           Note note = new Note(word, meaning);
           viewModel.insertNote(note);
           Intent intent = new Intent(this, ListOfWordsActivity.class);
           startActivity(intent);
        }else{
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isFilled(String word, String meaning){
        return !word.isEmpty() && !meaning.isEmpty();
    }
}
