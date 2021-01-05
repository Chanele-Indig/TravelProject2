package com.ruthiandchana.travelproject2.UI;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ruthiandchana.travelproject2.Entities.Travel;
import com.ruthiandchana.travelproject2.R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SecondFragment extends Fragment {
    TextView textView;
    MainViewModel mViewModel;
    private static final String TAG = "Firebase";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment2, container, false);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        mViewModel.getAllTravels().observe(getViewLifecycleOwner(), new Observer<List<Travel>>() {
            @Override
            public void onChanged(List<Travel> travels) {
                for (Travel tmp : travels) {
                    Log.e(TAG, tmp.getClientName() + ":  ");
                    //https://www.callicoder.com/java-hashmap/
                    //HashMap is a hash table based implementation of Java’s Map interface
                    Iterator it = tmp.getCompany().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        System.out.println("HashMap:  " + pair.getKey() + " = " + pair.getValue());
                    }
                }
            }});
           return view;
    }
}
