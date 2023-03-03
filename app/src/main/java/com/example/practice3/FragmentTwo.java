package com.example.practice3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import com.example.practice3.databinding.FirstBinding;
import com.example.practice3.databinding.SecondBinding;

public class FragmentTwo extends Fragment {

    MainActivity mainActivity;
    FragmentManager fragmentManager;
    SecondBinding binding;
    boolean isSettingFromBundle = false;

    public FragmentTwo()
    {
        super(R.layout.second);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toastMsgShow("OnCreate FragmentTwo");
        Log.i("Fragment Two","OnCreate");
        fragmentManager = getParentFragmentManager();
        fragmentManager.setFragmentResultListener("secondfragment",this, new FragmentResultListener()
        {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                isSettingFromBundle = true;
                binding.ratingBar.setRating(result.getFloat("review text"));
                isSettingFromBundle = false;

            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toastMsgShow("onViewCreated FragmentTwo");
        Log.i("Fragment Two","onViewCreated");
            binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (!isSettingFromBundle) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("rating result", binding.ratingBar.getRating());
                    fragmentManager.setFragmentResult("firstfragment", bundle);

                    fragmentManager.beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_view, FragmentOne.class, bundle)
                            .commit();
                }
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        toastMsgShow("onViewStateRestored FragmentTwo");
        Log.i("Fragment Two","onViewStateRestored");
        binding = SecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
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

