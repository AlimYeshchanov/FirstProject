package com.example.learnwordseasily;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesOneAdapter extends RecyclerView.Adapter<NotesOneAdapter.NotesOneViewHolder> {

    private List<Note> notes;

    public NotesOneAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesOneViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_note_item, viewGroup, false);
        return new NotesOneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesOneViewHolder notesOneViewHolder, int i) {
        Note note = notes.get(i);
        notesOneViewHolder.textViewWordEng.setText(note.getWord());
        notesOneViewHolder.textViewWordMeaning.setText(note.getMeaning());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesOneViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewWordEng;
        private TextView textViewWordMeaning;
        public EditText editTextWrittenWord;

        public NotesOneViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewWordEng = itemView.findViewById(R.id.textViewWordEng);
            textViewWordMeaning = itemView.findViewById(R.id.textViewWordMeaning);
            editTextWrittenWord = itemView.findViewById(R.id.editTextWrittenWord);
        }
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }


}
