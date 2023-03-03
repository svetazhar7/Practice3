package com.example.practice3;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    public FragmentOne()
    {
        super((R.layout.first));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toastMsgShow("OnCreate FragmentOne");
        Log.i("Fragment One","OnCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        toastMsgShow("onCreateView FragmentOne");
        Log.i("Fragment One","onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toastMsgShow("onViewCreated FragmentOne");
        Log.i("Fragment One","onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        toastMsgShow("onViewStateRestored FragmentOne");
        Log.i("Fragment One","onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        toastMsgShow("onStart FragmentOne");
        Log.i("Fragment One","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        toastMsgShow("onResume FragmentOne");
        Log.i("Fragment One","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        toastMsgShow("onPause FragmentOne");
        Log.i("Fragment One","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        toastMsgShow("onStop FragmentOne");
        Log.i("Fragment One","onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        toastMsgShow("onSaveInstanceState FragmentOne");
        Log.i("Fragment One","onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        toastMsgShow("onDestroyView FragmentOne");
        Log.i("Fragment One","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toastMsgShow("onDestroy FragmentOne");
        Log.i("Fragment One","onDestroy");
    }
    void toastMsgShow(String text)
    {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}