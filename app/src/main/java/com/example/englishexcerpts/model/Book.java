package com.example.englishexcerpts.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.englishexcerpts.BR;

public class Book extends BaseObservable {
    private String title;
    private String author;

    public Book(){
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
//        notifyPropertyChanged(BR.book);
//        notifyPropertyChanged(BR.newBook);
    }

    @Bindable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
//        notifyPropertyChanged(BR.book);
//        notifyPropertyChanged(BR.newBook);

    }


    @Override
    public String toString() {
        return title + "\n" + author;
    }
}
