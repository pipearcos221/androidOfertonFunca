package unicauca.movil.oferton.fragments;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.oferton.DetailActivity;
import unicauca.movil.oferton.R;
import unicauca.movil.oferton.adapters.NovedadAdapter;
import unicauca.movil.oferton.databinding.FragmentMainBinding;
import unicauca.movil.oferton.util.Data;

public class MainFragment extends Fragment implements NovedadAdapter.OnNovedadListener {

    public static MainFragment instance(){
        return new MainFragment();
    }

    FragmentMainBinding binding;
    NovedadAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        adapter = new NovedadAdapter(getLayoutInflater(null), Data.getNovedades(), this);
        binding.recycler.setAdapter(adapter);
        //binding.recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    @Override
    public void onNovedadClick(int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}
