package msku.ceng.madlab.week6;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import msku.ceng.madlab.week6.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieFragment extends Fragment {
    private List<Movie> movies = new ArrayList<>();
    private OnMovieSelected listener;

    public interface OnMovieSelected {
        void movieSelected(Movie movie);
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Örnek film verileri ekleniyor
        movies.add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994,
                Arrays.asList("Tim Robbins", "Morgan Freeman", "Bob Gunton"),
                "İki mahkum, yıllar boyunca bağ kurarak sonunda kendilerini bulurlar."));
        // Diğer örnek filmler buraya eklenebilir
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}