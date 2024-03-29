package com.example.pandicazoovrt;

import com.example.pandicazoovrt.constants.PromoCodes;
import com.example.pandicazoovrt.models.Animal;
import com.example.pandicazoovrt.models.Notifications;
import com.example.pandicazoovrt.models.User;
import com.example.pandicazoovrt.tickets.Comment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class utils {

    public static void initAll(){
        clearStorage();
        initUser();
        initEvents();
        initAnimal();
        initNotifications();
    }


    public static String ALL_USERS = "USERS";
    public static String ALL_ANIMALS = "ANIMALS";
    public static String EVENTS = "EVENTS";
    public static String LOGGED_USER = "LOGGED_USER";

    public static String NOTIFICATIONS = "NOTIFICATIONS";

    public static String CURRENT_ANIMAL = "CURRENT_ANIMAL";


    public static void initUser(){
        List<User> userList = new ArrayList<>();

        int [] eventsSara = new int[]{1, 0, 1, 1, 0};
        userList.add(new User(
             "sara",
             "sara123",
             "sara@gmail.com",
             "Sara",
             "Lazic",
             "067/7159-923",
             "Voje Veljkovica 22",
                eventsSara
        ));

        int [] eventsMina = new int[]{1, 0, 1, 1, 0};
        userList.add(new User(
            "mina",
            "mina123",
            "mina@gmail.com",
            "Mina",
            "Lazic",
            "064/0914-217",
            "Vardarska 12",
                eventsMina
        ));

        List<User> listFromStorage = getAllUsers();
        if(listFromStorage.isEmpty()){
            utils.saveListOfObjectsToLocalStorage(ALL_USERS, userList);
        }
    }

    public static void initEvents(){
        int [] eventNumbers = new int[]{252, 181, 202 , 108, 281};

        int[] eventsFromStorage = getEvents();
        if(eventsFromStorage.length < 1){
            saveEvents(eventNumbers);
        }
    }

    public static void initAnimal(){
        List<Animal> animalList = new ArrayList<>();

        Comment[] emptyCommentsSection = {};
        Comment[] commentsPandas = {new Comment(
                    "sara",
                    new Date(2023, 4, 20),
                    "Volim pande",
                    emptyCommentsSection
                ),
                new Comment(
                    "mina",
                    new Date(2023, 4, 23),
                    "Da li su dzinovske pande jos uvek ugrozena vrsta?",
                    emptyCommentsSection
                ),
        };

        animalList.add(new Animal(
                "Džinovska panda",
                "Ailuropoda melanoleuca",
                "Kina",
                "2000",
                "20 godina",
                 R.drawable.giant_panda,
                commentsPandas
        ));


        Comment[] commentsRedPanda = {new Comment(
                "sara",
                new Date(2023, 4, 28),
                "Volim pande",
                emptyCommentsSection
        ),
                new Comment(
                        "mina",
                        new Date(2023, 4, 28),
                        "prelepa je",
                        emptyCommentsSection
                ),
        };

        animalList.add(new Animal(
                "Crvena panda",
                "Ailurus fulgens",
                 "Nepal, Kina",
                 "2500",
                 "8-15 godina",
                R.drawable.new_red_panda,
                commentsRedPanda
        ));


        Comment[] replyRabbit = {new Comment(
                 "Zoo vrt Pandica",
                new Date(2023, 4, 26),
                 "Poštovana, za sada ne postoji ali svidja nam se zamisao i u budućem periodu će najverovatnije biti ostvarena",
                 emptyCommentsSection)
        };

        Comment[] commentsRabbit = {new Comment(
                "sara",
                new Date(2023, 4, 24),
                "Obožavam kuniće, prelepi su",
                emptyCommentsSection),
                new Comment(
                    "mina",
                        new Date(2023, 4, 26),
                     "Postoji li deo gde mogu da se maze zivotinje poput domacih kunica?",
                    replyRabbit)
        };

        animalList.add(new Animal(
                "Patuljasti zec",
                "Oryctolagus cuniculus domesticus",
                "Južna Evropa",
                "ne postoji adekvatna procena",
                "6-12 godina",
                 R.drawable.rabbit,
                commentsRabbit
        ));

        animalList.add(new Animal(
                "Afrički slon",
                "Loxodonta africana",
                "Afrika",
                "oko 40 hiljada",
                "oko 70 godina",
                R.drawable.elephant,
                emptyCommentsSection
        ));

        animalList.add(new Animal(
                "Kraljevski pingvin",
                "Aptenodytes patagonicus",
                "ostrva sub-Antarktika",
                "2,23 miliona parova",
                "15-25 godina",
                R.drawable.penguin,
                emptyCommentsSection
        ));


        animalList.add(new Animal(
                "Nilski konj",
                "Hippopotamus amphibius",
                "Severna Afrika i Evropa",
                "oko 120 hiljada",
                "40-50 godina",
                R.drawable.hippo,
                emptyCommentsSection
        ));

        animalList.add(new Animal(
                 "Tomasov langur",
                 "Presbytis thomasi",
                 "Severna Sumatra, Indonezija",
                 "550 do 700",
                 "do 20 godina",
                R.drawable.langur,
                emptyCommentsSection
        ));

        animalList.add(new Animal(
                "Ružičasti ﬂamingo",
                "Phoenicopterus",
                "Afrika, južna Azija, južna Evropa",
                "između 1.5 i 2.5 miliona",
                "20-30 godina, u zatočeništvu do 50",
                R.drawable.flamingo,
                emptyCommentsSection
        ));

        animalList.add(new Animal(
                "Žirafa",
                "Giraffa camelopardalis",
                "Od Čada do Južne Afrike",
                "110 do 150 hiljada jedinki",
                "220-25 godina, u zatočeništvu do 28",
                R.drawable.giraffe,
                emptyCommentsSection
        ));

        animalList.add(new Animal(
                "Staklena žaba",
                "Centrolenidae",
                "Južna Amerika",
                "nema informacija",
                "do 14 godina",
                R.drawable.frog,
                emptyCommentsSection
        ));


        List<Animal> listFromStorage = getAllAnimals();
        if(listFromStorage.isEmpty()){
            utils.saveListOfObjectsToLocalStorage(ALL_ANIMALS, animalList);
        }
    }


    public static void initNotifications() {
        List<Notifications> notificationsList = new ArrayList<>();

        notificationsList.add(new Notifications(
                "sara",
                true,
                "Vaš zahtev za kupovinu 3 karte za odrasle je odobren, uživajte u poseti!",
                new Date(2020, 10, 8, 15, 23)
        ));


        notificationsList.add(new Notifications(
                "sara",
                true,
                "Nažalost, Vaš zahtev za kupovinu 2 karte za odrasle je odbijen, molimo pokušajte ponovo kasnije!",
                new Date(2022, 6, 10, 8, 48)
        ));

        notificationsList.add(new Notifications(
                "mina",
                true,
                "Vaš zahtev za kupovinu 3 karte za odrasle je odobren, uživajte u poseti!",
                new Date(2022, 10, 10, 12, 20)
        ));

        notificationsList.add(new Notifications(
                "sara",
                false,
                "Zahtev za kupovinu 4 karte za odrasle je odobren, uživajte u poseti!",
                new Date(2023, 10, 5, 22, 48)
        ));

        List<Notifications> notificationsFromStorage = getAllNotifications();
        if(notificationsFromStorage.isEmpty()){
            utils.saveListOfObjectsToLocalStorage(NOTIFICATIONS, notificationsList);
        }
    }


    public static User getLoggedInUser(){
        return utils.getOneObjectFromLocalStorage(LOGGED_USER, new TypeToken<User>(){}.getType());
    }

    public static void logout(){
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(LOGGED_USER);
        editor.commit();
    }

    public static Animal getCurrentAnimal(){
        return utils.getOneObjectFromLocalStorage(CURRENT_ANIMAL, new TypeToken<Animal>(){}.getType());
    }

    public static List<User> getAllUsers(){
        return utils.getListOfObjectsFromLocalStorage(ALL_USERS, new TypeToken<List<User>>(){}.getType());
    }

    public static List<Animal> getAllAnimals(){
        return utils.getListOfObjectsFromLocalStorage(ALL_ANIMALS, new TypeToken<List<Animal>>(){}.getType());
    }

    public static List<Notifications> getAllNotifications(){
        return utils.getListOfObjectsFromLocalStorage(NOTIFICATIONS, new TypeToken<List<Notifications>>(){}.getType());
    }

    public static List<Notifications> getNotificationsForLoggedUser(){
        User logged = getLoggedInUser();
        List<Notifications> allNotifications = getAllNotifications();

        List<Notifications> filteredList = allNotifications.stream()
                .filter(notification -> notification.getUsername().equals(logged.getUsername()))
                .collect(Collectors.toList());

        Collections.sort(filteredList, new Comparator<Notifications>() {
            @Override
            public int compare(Notifications n1, Notifications n2) {
                return n2.getDate().compareTo(n1.getDate());
            }
        });

        return filteredList;
    }

    public static int[] getEvents(){
        return getIntArrayFromLocalStorage(EVENTS);
    }

    public static void saveEvents(int[] events){
        saveIntArrayToLocalStorage(EVENTS, events);
    }

    public static <T> List<T> getListOfObjectsFromLocalStorage(String key, Type type) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        String json = sharedPreferences.getString(key, "");

        if (json.equals("")) return  new ArrayList<>();

        Gson gson = new Gson();
        List<T> objects = gson.fromJson(json, type);
        return objects;
    }

    public static <T> void saveListOfObjectsToLocalStorage(String key, List<T> objects) {
        Gson gson = new Gson();
        String json = gson.toJson(objects);

        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }

    public static <T> T getOneObjectFromLocalStorage(String key, Type type) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        String json = sharedPreferences.getString(key, "");

        if (json.equals("")) return null;

        Gson gson = new Gson();
        T object = gson.fromJson(json, type);
        return object;
    }

    public static <T> void saveOneObjectToLocalStorage(String key, T object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);

        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }

    public static int[] getIntArrayFromLocalStorage(String key) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        String json = sharedPreferences.getString(key, "");

        if (json.isEmpty()) {
            return new int[0]; // Return an empty array if the key is not found
        }

        // Convert the JSON string back to int[]
        Gson gson = new Gson();
        int[] array = gson.fromJson(json, int[].class);

        return array;
    }

    public static void saveIntArrayToLocalStorage(String key, int[] array) {
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();

        // Convert the array to a JSON string
        Gson gson = new Gson();
        String json = gson.toJson(array);

        // Save the JSON string to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, json);
        editor.apply();
    }



    public static int[] discount(int zoo, int aq, int feed, int full, String promo_code) {
        int overallCount = zoo + aq + feed + full;

        if (!promo_code.equals(PromoCodes.third_free) || overallCount < 3) {
            return new int[]{ zoo, aq, feed, full };
        }

        int toDiscount = (int) Math.floor(overallCount / 3);

        if (zoo > toDiscount) {
            zoo = zoo - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - zoo;
            zoo = 0;
        }

        if (aq > toDiscount) {
            aq = aq - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - aq;
            aq = 0;
        }

        if (feed > toDiscount) {
            feed = feed - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - feed;
            feed = 0;
        }

        if (full > toDiscount) {
            full = full - toDiscount;
            toDiscount = 0;
        } else {
            toDiscount = toDiscount - full;
            full = 0;
        }

        return new int[]{ zoo, aq, feed, full };
    }

    public static boolean validNumberOfTickets(int zoo, int aq, int feed, int full) {
        return (
                zoo >= 0 &&
                aq >= 0 &&
                feed >= 0 &&
                full >= 0
        );
    }

    private static void clearStorage(){
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static void changeUsernameEveryWhere(String old, String newUsername){
        // comments and replies
        List<Animal> animals = utils.getAllAnimals();
        animals.forEach(animal -> {
            Comment[] comments = animal.getComments();
            for(int i=0; i<comments.length; i++){
                if(comments[i].getAuthor().equals(old)) comments[i].setAuthor(newUsername);
            }
            animal.setComments(comments);
        });
        utils.saveListOfObjectsToLocalStorage(utils.ALL_ANIMALS, animals);

        // notifications
        List<Notifications> notifications = utils.getAllNotifications();
        notifications.forEach(notification -> {
            if(notification.getUsername().equals(old)) notification.setUsername(newUsername);
        });
        utils.saveListOfObjectsToLocalStorage(utils.NOTIFICATIONS, notifications);
    }
}


