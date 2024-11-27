package msku.ceng.madlab.week7;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MovieFragment extends Fragment {
    private List<Movie> movies = new ArrayList<>();
    private OnMovieSelected listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        movies.add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994,
                Arrays.asList("Tim Robbins", "Morgan Freeman", "Bob Gunton"),
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption."));

        movies.add(new Movie("The Godfather", "Francis Ford Coppola", 1972,
                Arrays.asList("Marlon Brando", "Al Pacino", "James Caan"),
                "The aging patriarch of an organized crime dynasty transfers control of his empire."));
    }

    public interface OnMovieSelected {
        void onMovieSelected(Movie movie);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMovieSelected) {
            listener = (OnMovieSelected) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnMovieSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
