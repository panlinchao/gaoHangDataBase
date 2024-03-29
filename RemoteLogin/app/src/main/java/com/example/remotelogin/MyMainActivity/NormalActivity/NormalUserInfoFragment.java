package com.example.remotelogin.MyMainActivity.NormalActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.remotelogin.ActivityCollector;
import com.example.remotelogin.Login.NormalUser;
import com.example.remotelogin.MyMainActivity.NormalActivity.ChangePasswordFunction.ChangePassWordActivity;
import com.example.remotelogin.MyMainActivity.NormalActivity.ChargeFunction.NormalUserChargeActivity;
import com.example.remotelogin.R;

import static com.example.remotelogin.ConstantValues.maincontext;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NormalUserInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NormalUserInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    private NormalUser normalUser;
    private TextView name_txt;
    private TextView ph_txt;
    private TextView room_txt;
    private TextView tp_txt;
    private TextView changePassword;
    private TextView logout;
    private TextView charge;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NormalUserInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NormalUserInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NormalUserInfoFragment newInstance(String param1, String param2) {
        NormalUserInfoFragment fragment = new NormalUserInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_normal_user_info, container, false);
        NormalUserMainActivity activity = (NormalUserMainActivity) getActivity();
        normalUser = activity.getNormalUser();
        name_txt = view.findViewById(R.id.info_name_text_view);
        changePassword = view.findViewById(R.id.changePwd_txt);
        logout = view.findViewById(R.id.normal_user_logout);
        charge = view.findViewById(R.id.normal_user_pay_txt);
        name_txt.setText(normalUser.getName());

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChangePassWordActivity.class);
                intent.putExtra("id", normalUser.getId().toString());
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.myschoolapp.FORCE_OFFLINE");
                maincontext.sendBroadcast(intent);
//                ActivityCollector.finishAll();
            }
        });
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NormalUserChargeActivity.class);
                startActivity(intent);
            }
        });
        // todo 找到房间号
//        room_txt.setText(normalUser.get);
        return view;
    }
}