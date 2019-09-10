package com.example.android.whatsappmdc;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AppUtility {

    private String [] names;
    private String[] msg;
    private int[] images = {R.drawable.images,
                            R.drawable.untitled,
                            R.drawable.untitled1,
                            R.drawable.untitled2,
                            R.drawable.untitled3,
                            R.drawable.untitled4,
                            R.drawable.untitled5,
                            R.drawable.untitled6,
                            R.drawable.imgg,
                            R.drawable.img0};


    private Context context;
    private List<Person> people;

    private static AppUtility appUtility;

    private AppUtility(Context context){

        this.context=context;

        names=context.getResources().getStringArray(R.array.first_name);
        msg = context.getResources().getStringArray(R.array.messages);

        people=new ArrayList<Person>();

        for(int i=0;i<names.length;i++){
            Person person=new Person(names[i],msg[i],images[i]);
            people.add(person);
        }
    }


    public static AppUtility getAppUtility(Context context){
        if(appUtility==null){
            appUtility=new AppUtility(context);
        }
        return appUtility;
    }

    public List<Person> getPeople(){
        return this.people;

    }

    public String[] getNames() {

        return names;

    }
    public String[] message() {

        return msg;
    }

}