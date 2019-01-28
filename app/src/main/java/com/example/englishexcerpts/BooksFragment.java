package com.example.englishexcerpts;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.englishexcerpts.databinding.BooksViewBinding;
import com.example.englishexcerpts.model.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BooksFragment extends Fragment {
//    private FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
    private List<Book> books = new ArrayList<>();
    private NewBookFragment newBookFragment = new NewBookFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BooksViewBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.books_view, container, false);
        View view = binding.getRoot();
        binding.setBook(new Book());


        //here data must be an instance of the class MarsDataProvider


//        return inflater.inflate(R.layout.books_view,container,false);


        return view;
    }

    public void readBooksInfo() {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    getActivity().openFileInput("books.txt")));
            String str = "";

            int lineNumber = 0;
            String title= "";
            while ((str = br.readLine()) != null) {
                if (lineNumber % 2 == 0) {
                    title = str;
                } else if (lineNumber % 2 == 1) {
                    books.add(new Book(title, str));
                }
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button newBookButton = getView().findViewById(R.id.btn_new_book);
        newBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_holder, newBookFragment).commit();
            }
        });
    }
}
