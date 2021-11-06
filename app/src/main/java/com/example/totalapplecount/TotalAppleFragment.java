package com.example.totalapplecount;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TotalAppleFragment extends Fragment {
    private TextView tv_total_apple;
    private EditText et_total_apple;
    private Button btnNext;
    private String remApple = "0";

    private CommunicationListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            remApple = getArguments().getString("remApple");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apple, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_total_apple = view.findViewById(R.id.tv_totalApple);
        et_total_apple = view.findViewById(R.id.et_total_apple);
        btnNext = view.findViewById(R.id.btnBuyApple);
        tv_total_apple.setText(remApple);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                tv_total_apple.setText(et_total_apple.getText().toString());
                Log.d("rkpsx7",tv_total_apple.getText().toString());
                bundle.putString("total",et_total_apple.getText().toString());
                listener.launchBuyAppleFrag(bundle);
            }
        });

    }
}