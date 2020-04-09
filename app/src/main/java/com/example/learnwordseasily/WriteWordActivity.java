package com.example.learnwordseasily;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public class WriteWordActivity extends AppCompatActivity {


    public TextView textViewWordEng;
    public TextView textViewWordMeaning;
    public EditText editTextWrittenWord;

    private RecyclerView recyclerViewNotesOne;
    private final ArrayList<Note> notes = new ArrayList<>();
    private NotesOneAdapter adapter;
    private MainViewModel viewModel;

//    @Override
//    public void onClick(View v) {
//        textViewWordEng.setText("");
//        editTextWrittenWord.getText().clear();
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_word_item);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        recyclerViewNotesOne = findViewById(R.id.recyclerViewNotesOne);
        adapter = new NotesOneAdapter(notes);
        recyclerViewNotesOne.setLayoutManager(new LinearLayoutManager(this));
        getData();
        recyclerViewNotesOne.setAdapter(adapter);
        LinearSnapHelper linearSnapHelper = new SnapHelperOneByOne();
        linearSnapHelper.attachToRecyclerView(recyclerViewNotesOne);



        textViewWordEng = (TextView) findViewById(R.id.textViewWordEng);
        textViewWordMeaning = (TextView) findViewById(R.id.textViewWordMeaning);
        editTextWrittenWord = (EditText) findViewById(R.id.editTextWrittenWord);

        String tvString = textViewWordEng.getText().toString();
        String etString = editTextWrittenWord.getText().toString();
        if (etString.equals(tvString)){

        }

//        textViewWordEng.setOnClickListener(this);
//        editTextWrittenWord.setOnClickListener(this);




    }


    private void getData() {
        LiveData<List<Note>> notesFromDB = viewModel.getNotes();
        notesFromDB.observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notesFromLiveData) {
                adapter.setNotes(notesFromLiveData);
            }
        });
    }

}









