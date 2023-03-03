package com.example.practice3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import com.example.practice3.databinding.FirstBinding;
import com.example.practice3.databinding.SecondBinding;

public class FragmentOne extends Fragment {

    MainActivity mainActivity;
    FragmentManager fragmentManager;
    FirstBinding binding;
    float rating=0;
    public FragmentOne()
    {
        super((R.layout.first));
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        toastMsgShow("onViewStateRestored FragmentOne");
        Log.i("Fragment One","onViewStateRestored");
        binding = FirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toastMsgShow("OnCreate FragmentOne");
        Log.i("Fragment One","OnCreate");
        fragmentManager =  getParentFragmentManager();
        fragmentManager.setFragmentResultListener("firstfragment", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                rating=result.getFloat("rating result");
                binding.button4.setText("Ваша оценка: " + rating);
            }
        });

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toastMsgShow("onViewCreated FragmentOne");
        Log.i("Fragment One","onViewCreated");
        Button button = view.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putFloat("review text",rating);
                fragmentManager.setFragmentResult("secondfragment",bundle);
                Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_view);
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_view,
                                FragmentTwo.class, bundle)
                        .commit();
            }
        });
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
