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


public class FragmentTwo extends Fragment {

        public FragmentTwo()
        {
            super(R.layout.second);
        }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toastMsgShow("OnCreate FragmentTwo");
        Log.i("Fragment Two","OnCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        toastMsgShow("onCreateView FragmentTwo");
        Log.i("Fragment Two","onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toastMsgShow("onViewCreated FragmentTwo");
        Log.i("Fragment Two","onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        toastMsgShow("onViewStateRestored FragmentTwo");
        Log.i("Fragment Two","onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        toastMsgShow("onStart FragmentTwo");
        Log.i("Fragment Two","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        toastMsgShow("onResume FragmentTwo");
        Log.i("Fragment Two","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        toastMsgShow("onPause FragmentTwo");
        Log.i("Fragment Two","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        toastMsgShow("onStop FragmentTwo");
        Log.i("Fragment Two","onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        toastMsgShow("onSaveInstanceState FragmentTwo");
        Log.i("Fragment Two","onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        toastMsgShow("onDestroyView FragmentTwo");
        Log.i("Fragment Two","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toastMsgShow("onDestroy FragmentTwo");
        Log.i("Fragment Two","onDestroy");
    }
    void toastMsgShow(String text)
    {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
    }

