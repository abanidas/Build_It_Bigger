package com.abani.exercise.android.joketeller.utils;

import java.util.Random;

public class JokeUtil {

    public static String getRandomJokes(){

        Random random = new Random();
        int num = random.nextInt(6) + 1;
        switch (num){
            case 1:return "\nQ. Name me five different animals, Johnny" +
                    "\n A. The dog, the dog’s brother, the dog’s sister, the dog’s cousin and the dog’s aunt.";
            case 2:return "\nQ. What is black – white – black – white – black – white?" +
                    "\n A. A penguin rolling down a mountain!";
            case 3:return "\nQ. Why do dolphins swim in salt water?" +
                    "\n A. Because pepper water would make them sneeze.";
            case 4:return "\nQ. Why did the shark keep swimming in circles?" +
                    "\n A. It had a nosebleed.";
            case 5:return "\nQ. What happens when a cop gets into bed?" +
                    "\n A. He becomes an undercover cop.";
            default:return "\nQ. Can a kangaroo jump higher than a house?" +
                    "\n A. Of course, a house does not jump at all.";
        }
    }
}
