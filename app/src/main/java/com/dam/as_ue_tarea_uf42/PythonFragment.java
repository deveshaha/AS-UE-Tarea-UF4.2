package com.dam.as_ue_tarea_uf42;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PythonFragment extends Fragment {

    TextView tv;

    public PythonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python, container, false);
        tv = view .findViewById(R.id.tvPython);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, MainActivity.TAM);
        return view;
    }
}