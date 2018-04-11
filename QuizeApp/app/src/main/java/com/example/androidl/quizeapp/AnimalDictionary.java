package com.example.androidl.quizeapp;

public interface AnimalDictionary {

     Animal camel=new Animal("camel",R.drawable.camel,false,true,false,true);
     Animal chicken=new Animal("chicken",R.drawable.chicken,false,true,false,true);
     Animal cock=new Animal("cock",R.drawable.cock,false,true,false,true);
     Animal cow=new Animal("cow",R.drawable.cow,false,true,false,true);
     Animal dog=new Animal("dog",R.drawable.dog,false,true,true,true);
     Animal donkey=new Animal("donkey",R.drawable.donkey,false,true,false,true);
     Animal duck=new Animal("duck",R.drawable.duck,false,true,false,true);
     Animal elephant=new Animal("elephant",R.drawable.elephant,false,false,false,true);
     Animal giraffe=new Animal("giraffe",R.drawable.giraffe,false,false,false,true);
     Animal goat=new Animal("goat",R.drawable.goat,false,true,false,true);
     Animal lion=new Animal("lion",R.drawable.lion,true,false,true,false);
     Animal monkey=new Animal("monkey",R.drawable.monkey,false,false,false,true);
     Animal sparrow=new Animal("sparrow",R.drawable.sparrow,false,true,false,true);
     Animal tiger=new Animal("tiger",R.drawable.tiger,true,false,true,false);
     Animal zebra=new Animal("zebra",R.drawable.zebra,false,false,false,true);

    Animal[] animalList={camel,chicken,cock,cow ,dog, donkey,duck
            ,elephant ,giraffe ,goat ,lion ,monkey ,sparrow ,tiger ,zebra};


}