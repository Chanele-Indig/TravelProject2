package com.ruthiandchana.travelproject2.UI;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ruthiandchana.travelproject2.Adapter.CustomListAdapter;
import com.ruthiandchana.travelproject2.Entities.Travel;
import com.ruthiandchana.travelproject2.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint("ValidFragment")
public class FirstFragment extends Fragment {
    TextView textView;
    final String LOG_TAG="Firebase";
    MainViewModel mViewModel;
    Context context;
    ListView itemsListView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
        Log.d(LOG_TAG, "FirstFragment: onAttach() called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "FirstFragment: onCreate() called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "FirstFragment: onCreateView() called");
        View view= inflater.inflate(R.layout.fragment2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "FirstFragment: onViewCreated() called");
        itemsListView  = (ListView)view.findViewById(R.id.list_view_items);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        mViewModel.getAllTravels().observe(getViewLifecycleOwner(), new Observer<List<Travel>>() {
            @Override
            public void onChanged(List<Travel> travels) {
                ArrayList<Travel> tmp = new ArrayList<Travel>(travels);

                //create adapter object
                CustomListAdapter adapter = new CustomListAdapter(context, tmp);

                //set custom adapter as adapter to our list view
                itemsListView.setAdapter(adapter);
            }});
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "FirstFragment: onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "FirstFragment: onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "FirstFragment: onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "FirstFragment: onStop() called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "FirstFragment: onDestroyView() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "FirstFragment: onDestroy() called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "FirstFragment: onDetach() called");
    }
}
