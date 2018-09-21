package com.example.mohamed_abdelsamad.tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Mohamed_Araby on 3/23/2018.
 */

public class ParksFragment extends Fragment {

    ArrayList<ResourcesDetails> resourcesDetails;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_police_station_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resourcesDetails = setData();
        customAdapter = new CustomAdapter(getContext(), resourcesDetails);
        listView = view.findViewById(R.id.police_list);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("data", resourcesDetails.get(i));
                startActivity(intent);
            }
        });

    }


    private ArrayList<ResourcesDetails> setData() {
        ArrayList<ResourcesDetails> arrayList = new ArrayList<>();


        arrayList.add(new ResourcesDetails(getResources().getString(R.string.azhar).toString(),
                getResources().getString(R.string.elAzhar),
                R.drawable.el_azhar));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.dawliaa).toString(),
                getResources().getString(R.string.elDawlia),
                R.drawable.el_dawlia));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.horiia).toString(),
                getResources().getString(R.string.elhoria),
                R.drawable.el_horia));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.osra).toString(),
                getResources().getString(R.string.Elosra),
                R.drawable.el_osra));

        return arrayList;
    }
}
