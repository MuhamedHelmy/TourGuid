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

public class MuseumFragment extends Fragment {

    ArrayList<ResourcesDetails> resourcesDetails;
    ListView listView;
    CustomAdapter customAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_museum_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        resourcesDetails = setData();
        customAdapter = new CustomAdapter(getContext(), resourcesDetails);
        listView = view.findViewById(R.id.museum_list);
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


        arrayList.add(new ResourcesDetails(getResources().getString(R.string.Gamal).toString(), getResources().getString(R.string.Gamal_abd_el_Nasermusume), R.drawable.gmal));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.ElQipty).toString(), getResources().getString(R.string.El_Mathaf_el_Qepty), R.drawable.el_qepty));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.ElMATHAF_elfan).toString(), getResources().getString(R.string.ElMATHAF_elfan_Elmasry), R.drawable.fan_eslamy));
        arrayList.add(new ResourcesDetails(getResources().getString(R.string.Elmasry).toString(), getResources().getString(R.string.ELMathaf_elmasry), R.drawable.masry));

        return arrayList;
    }

}
