package com.example.android.whatsappmdc;

public class Person {
    private String Name;
    private String msg;
    private int images;

 //   private GENDER Gender;
    private String Nationality;

    public Person(String name, String msg, int img)
    {
        this.Name = name;
        this.msg = msg;
        this.images = img;

       // this.Gender = gender;
        //this.Nationality = nationality;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;

    }

    public String getMessage()
    {
        return msg;
    }

    public void setLastname(String msg)
    {
        this.msg = msg;

    }

    public int getImages()
    {
        return images;
    }

    public void setImages(int img)
    {
        this.images = img;
    }

 /*   enum GENDER {MALE,FEMALE};

    public GENDER getGender()
    {
        return Gender;
    }

    public void setGender(GENDER gen)
    {
        this.Gender = gen;

    }

    public String getNationality()
    {
        return Nationality;
    }

    public void setNationality(String nationality)
    {
        this.Nationality = nationality;

    } */
}
