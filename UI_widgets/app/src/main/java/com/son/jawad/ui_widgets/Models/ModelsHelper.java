package com.son.jawad.ui_widgets.Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

/**
 * Created by Adhamkh on 2017-08-28.
 */

public class ModelsHelper {

    public static List<RecyclerViewModel> getrecyclerViewModelList() {
        List<RecyclerViewModel> recyclerViewModelList = new Vector<>();
        recyclerViewModelList.add(new RecyclerViewModel("Product1", "https://source.unsplash.com/random", "This is new Collection", 1.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product2", "https://source.unsplash.com/random", "This is new Collection", 2.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product3", "https://source.unsplash.com/random", "This is new Collection", 2.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product4", "https://source.unsplash.com/random", "This is new Collection", 3.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product5", "https://source.unsplash.com/random", "This is new Collection", 2.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product6", "https://source.unsplash.com/random", "This is new Collection", 2.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product7", "https://source.unsplash.com/random", "This is new Collection", 3.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product8", "https://source.unsplash.com/random", "This is new Collection", 4.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product9", "https://source.unsplash.com/random", "This is new Collection", 1.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product10", "https://source.unsplash.com/random", "This is new Collection", 3.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product11", "https://source.unsplash.com/random", "This is new Collection", 4.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product12", "https://source.unsplash.com/random", "This is new Collection", 5.0f));

        recyclerViewModelList.add(new RecyclerViewModel("Product13", "https://source.unsplash.com/random", "This is new Collection", 1.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product14", "https://source.unsplash.com/random", "This is new Collection", 2.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product15", "https://source.unsplash.com/random", "This is new Collection", 2.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product16", "https://source.unsplash.com/random", "This is new Collection", 3.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product17", "https://source.unsplash.com/random", "This is new Collection", 2.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product18", "https://source.unsplash.com/random", "This is new Collection", 2.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product19", "https://source.unsplash.com/random", "This is new Collection", 3.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product20", "https://source.unsplash.com/random", "This is new Collection", 4.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product21", "https://source.unsplash.com/random", "This is new Collection", 1.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product22", "https://source.unsplash.com/random", "This is new Collection", 3.5f));
        recyclerViewModelList.add(new RecyclerViewModel("Product23", "https://source.unsplash.com/random", "This is new Collection", 4.0f));
        recyclerViewModelList.add(new RecyclerViewModel("Product24", "https://source.unsplash.com/random", "This is new Collection", 5.0f));

        return recyclerViewModelList;
    }

    public static List<ViewpagerModel> getViewpagerModelList() {
        List<ViewpagerModel> viewpagerModels = new Vector<>();
        viewpagerModels.add(new ViewpagerModel("https://source.unsplash.com/random", "Not alone but the best 1"));
        viewpagerModels.add(new ViewpagerModel("https://source.unsplash.com/random", "Not alone but the best 2"));
        viewpagerModels.add(new ViewpagerModel("https://source.unsplash.com/random", "Not alone but the best 3"));
        viewpagerModels.add(new ViewpagerModel("https://source.unsplash.com/random", "Not alone but the best 4"));
        viewpagerModels.add(new ViewpagerModel("https://source.unsplash.com/random", "Not alone but the best 5"));
        return viewpagerModels;
    }


    private static List<Actor> getOriginalActorList() {
        final List<Actor> actors = new ArrayList<>();

        actors.add(new Actor(1, "Jack Nicholson", 10, 1937));
        actors.add(new Actor(2, "Marlon Brando", 9, 1924));
        actors.add(new Actor(3, "Robert De Niro", 8, 1943));
        actors.add(new Actor(4, "Al Pacino", 7, 1940));
        actors.add(new Actor(5, "Daniel Day-Lewis", 6, 1957));
        actors.add(new Actor(6, "Dustin Hoffman", 5, 1937));
        actors.add(new Actor(7, "Tom Hanks", 4, 1956));
        actors.add(new Actor(8, "Anthony Hopkins", 3, 1937));
        actors.add(new Actor(9, "Paul Newman", 2, 1925));
        actors.add(new Actor(10, "Denzel Washington", 1, 1954));

        return actors;
    }

    public static List<Actor> getActorListSortedByRating() {
        final List<Actor> actorList = getOriginalActorList();

        Collections.sort(actorList, new Comparator<Actor>() {
            @Override
            public int compare(Actor a1, Actor a2) {
                // Descending order
                return a2.getRating() - a1.getRating();
            }
        });

        return actorList;
    }

    public static List<Actor> getActorListSortedByName() {
        final List<Actor> actorList = getOriginalActorList();

        Collections.sort(actorList, new Comparator<Actor>() {
            @Override
            public int compare(Actor a1, Actor a2) {
                return a1.getName().compareTo(a2.getName());
            }
        });

        return actorList;
    }

    public static List<Actor> getActorListSortedByYearOfBirth() {
        final List<Actor> actorList = getOriginalActorList();

        Collections.sort(actorList, new Comparator<Actor>() {
            @Override
            public int compare(Actor a1, Actor a2) {
                return a1.getYearOfBirth() - a2.getYearOfBirth();
            }
        });

        return actorList;
    }


}
