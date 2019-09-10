package com.example.android.whatsappmdc;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

    private Context context;
    private List<Person> personList;

    public RecyclerViewAdapter(Context context, List<Person> people) {
        this.context = context;
        this.personList = people;
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_row_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder holder, int position) {
        final Person person = personList.get(position);
       //` Log.i("pos",Integer.toString(position));
        holder.textViewName.setText(person.getName());
        Log.i("name",person.getName() + " " + Integer.toString(position));
        holder.message.setText(person.getMessage());
        Picasso.get().load(person.getImages()).into(holder.imageView);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String name = personList.get(position).getName();
                int image = personList.get(position).getImages();

                Intent intent = new Intent(context, ChatInboxActivity.class);
                intent.putExtra("title",name);
                intent.putExtra("dp",image);
                context.startActivity(intent);
            }
        });

        holder.setItemLongClickListener(new ItemLongClickListener() {
            @Override
            public boolean onItemLongClickListener(View view, int position) {

                view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.animator));
                Toast.makeText(context, "select" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    public interface ItemClickListener{
        void onItemClickListener(View v, int position);
    }

    public interface ItemLongClickListener {
        public boolean onItemLongClickListener(View view, int position);
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public TextView message;
        public ImageView imageView;
        ItemClickListener itemClickListener;
        ItemLongClickListener itemLongClickListener;

        public PersonViewHolder(View view) {
            super(view);
            this.textViewName = (TextView) view.findViewById(R.id.name);
            this.message = (TextView) view.findViewById(R.id.message);
            this.imageView = (ImageView) view.findViewById(R.id.image_dp);
            view.setOnClickListener(this);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemLongClickListener.onItemLongClickListener(view,getLayoutPosition());
                    return true;
                }
            });
        }

        @Override
        public void onClick(View view) {
this.itemClickListener.onItemClickListener(view,getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic)
        {
            this.itemClickListener  = ic;
        }

        public void setItemLongClickListener(ItemLongClickListener ilc){

            this.itemLongClickListener = ilc;
        }
    }

    public List<Person> getPersonList()
    {
        return personList;
    }

}

