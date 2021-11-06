package com.example.totalapplecount;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BuyAppleFragment extends Fragment {
    private CommunicationListener listener;
    private String totalApple = "0";
    private EditText et_apple_to_buy;
    private Button btnGoBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            totalApple = getArguments().getString("total");
            Log.d("rkpsx7",totalApple);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_buy_apple, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_apple_to_buy = view.findViewById(R.id.et_bought_apple);
        btnGoBack = view.findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                int rem = Integer.parseInt(totalApple) - Integer.parseInt(et_apple_to_buy.getText().toString());
                bundle.putString("remApple", Integer.toString(rem));
                listener.launchTotalAppleFrag(bundle);
            }
        });

    }
}