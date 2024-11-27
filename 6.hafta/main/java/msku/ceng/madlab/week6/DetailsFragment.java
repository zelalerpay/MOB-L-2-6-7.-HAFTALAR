package msku.ceng.madlab.week6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    private Movie movie;

    public static DetailsFragment newInstance(Movie movie) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            movie = getArguments().getParcelable("movie");
        }

        TextView txtName = view.findViewById(R.id.txtMovieName);
        TextView txtYear = view.findViewById(R.id.txtYear);
        TextView txtDirector = view.findViewById(R.id.txtDirector);
        EditText txtDescription = view.findViewById(R.id.txtDescription);

        if (movie != null) {
            txtName.setText(movie.getName());
            txtYear.setText(String.valueOf(movie.getYear()));
            txtDirector.setText(movie.getDirector());
            txtDescription.setText(movie.getDescription());
            txtDescription.setEnabled(false); // Description alanını sadece okunur yap
        }
    }
}