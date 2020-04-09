package com.example.learnwordseasily;

//DAO data access object - объект доступа к данным

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();
}