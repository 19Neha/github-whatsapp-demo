package com.example.android.whatsappmdc;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewNewGroupAdapter extends  RecyclerView.Adapter<RecyclerViewNewGroupAdapter.PersonViewHolder>  {

    private Context context;
    private List<Person> personList;

    public RecyclerViewNewGroupAdapter(Context context, List<Person> people) {
        this.context = context;
        this.personList = people;
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @NonNull
    @Override
    public RecyclerViewNewGroupAdapter.PersonViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_grid_item, parent, false);
        return new RecyclerViewNewGroupAdapter.PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewNewGroupAdapter.PersonViewHolder holder, int position) {
        final Person person = personList.get(position);
        holder.textViewName.setText(person.getName());
        Log.i("name",person.getName() + " " + Integer.toString(position));
        Picasso.get().load(person.getImages()).into(holder.imageView);
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;


        public PersonViewHolder(View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.text_name);
            this.imageView = (ImageView) view.findViewById(R.id.image_ng);
        }
    }

    public List<Person> getPersonList()
    {
        return personList;
    }

}
