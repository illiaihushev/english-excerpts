package com.example.englishexcerpts;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.englishexcerpts.databinding.BooksViewBinding;
import com.example.englishexcerpts.databinding.NewBookViewBinding;
import com.example.englishexcerpts.model.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_APPEND;

public class NewBookFragment extends Fragment {

    Book book = new Book();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NewBookViewBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.new_book_view, container, false);
        View view = binding.getRoot();
        binding.setNewBook(book);
        return view;
    }

    @Override
    public void onPause() {
        System.out.println(book.getAuthor());
        super.onPause();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button saveButton = getView().findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBook();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    private void saveBook() {
//        File file = new File(getContext().getFilesDir(), "books.txt");
        FileOutputStream fos = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            fos = new FileOutputStream(new File(getContext().getFilesDir() + "/books.txt"), true);
            outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(book.toString() + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    if (outputStreamWriter != null) {
                        outputStreamWriter.close();
                    }
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
