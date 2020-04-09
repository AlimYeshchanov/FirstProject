package com.example.learnwordseasily;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.StringJoiner;

//POJO PLAIN OLD JAVA OBJECT



@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String word;
    private String meaning;

    public Note(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }

    @Ignore
    public Note(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {return id; }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
