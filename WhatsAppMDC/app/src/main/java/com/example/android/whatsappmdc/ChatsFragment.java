package com.example.android.whatsappmdc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.view.View.VISIBLE;
import static android.widget.GridLayout.HORIZONTAL;

public class ChatsFragment extends Fragment {

    private RecyclerView recyclerView;

    AppUtility appUtility;
    RecyclerViewAdapter recycleViewAdapter;
    View rootView;

    private List<Person> mperson = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        appUtility = AppUtility.getAppUtility(getActivity().getApplicationContext());

        recycleViewAdapter = new RecyclerViewAdapter(getActivity().getApplicationContext(), appUtility.getPeople());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(recycleViewAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

//        recycleViewAdapter.setOnClickListener(new RecyclerViewAdapter.onClickListener() {
//            @Override
//            public void onclick(int position) {
//
//                mperson = recycleViewAdapter.getPersonList();
//                Intent intent = new Intent(getActivity().getApplicationContext(), ChatInboxActivity.class);
//                ImageView imageView = rootView.findViewById(R.id.image_dp);
//                TextView textView = rootView.findViewById(R.id.name);
//                String msg = textView.getText().toString();
//                intent.putExtra("title", msg);
//                intent.putExtra("image", mperson.get(position).getImages());
//                startActivity(intent);
//            }
//        });

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


//    @Override
//    public void onclick(int position) {
//        Intent intent = new Intent(getActivity().getApplicationContext(), ChatInboxActivity.class);
//       // startActivity(intent);
//
//    }
}

