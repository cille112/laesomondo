package com.example.cille_000.laesomondo.mainscreen;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cille_000.laesomondo.R;

import java.util.ArrayList;
import java.util.List;


public class BookListAdapter extends ArrayAdapter<String> {

    private Activity context;
    private String[] itemname;
    private String textRead;
    private List<Integer[]> bookList;


    public BookListAdapter(Activity context, String[] itemname, String textRead) {
        super(context, R.layout.listelement, itemname);
        this.context = context;
        this.itemname = itemname;
        this.textRead = textRead;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        bookList = new ArrayList<>();

        if(rowView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.listelement, null, true);
        }

        RecyclerView recyclerView = (RecyclerView) rowView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);



        if(itemname[position].equals("Anbefalet")){
            Integer[] bookImages =  {
                    R.drawable.text1cover, R.drawable.text2cover,R.drawable.text3cover,R.drawable.text4cover,R.drawable.text5cover
            };
            bookList.add(bookImages);
            bookListVerticalAdapter adapter = new bookListVerticalAdapter(context, bookList, bookList.indexOf(bookImages), itemname[position], textRead);
            recyclerView.setAdapter(adapter);
        }
        else if (itemname[position].equals("Adventure")){
            Integer[] adImages =  {
                    R.drawable.adventure01, R.drawable.adventure02, R.drawable.text3adventure, R.drawable.adventure04, R.drawable.text5adventure
            };
            bookList.add(adImages);
            bookListVerticalAdapter adapterAdventure = new bookListVerticalAdapter(context, bookList, bookList.indexOf(adImages), itemname[position], textRead);
            recyclerView.setAdapter(adapterAdventure);
        }
        else if (itemname[position].equals("Krimi")){
            Integer[] krimImages =  {
                    R.drawable.text1krimi, R.drawable.text2krimi, R.drawable.text3krimi, R.drawable.krimi04, R.drawable.text5krimi
            };
            bookList.add(krimImages);
            bookListVerticalAdapter adapterKrimi = new bookListVerticalAdapter(context, bookList, bookList.indexOf(krimImages), itemname[position], textRead);
            recyclerView.setAdapter(adapterKrimi);
        }
        else if (itemname[position].equals("Gyser")){
            Integer[] gysImages =  {
                    R.drawable.text1gyser, R.drawable.gyser02, R.drawable.gyser03
            };
            bookList.add(gysImages);
            bookListVerticalAdapter adapterGys = new bookListVerticalAdapter(context, bookList, bookList.indexOf(gysImages), itemname[position], textRead);
            recyclerView.setAdapter(adapterGys);
        }
        else if (itemname[position].equals("Roman")){
            Integer[] gysImages =  {
                    R.drawable.text1roman, R.drawable.text2roman
            };
            bookList.add(gysImages);
            bookListVerticalAdapter adapterGys = new bookListVerticalAdapter(context, bookList, bookList.indexOf(gysImages), itemname[position], textRead);
            recyclerView.setAdapter(adapterGys);
        }

        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        textView.setText(itemname[position]);

        return rowView;
    }


}