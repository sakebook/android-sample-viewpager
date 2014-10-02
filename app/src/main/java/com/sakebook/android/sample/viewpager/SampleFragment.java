package com.sakebook.android.sample.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SampleFragment extends Fragment {
    private static final String TEXT = "text";
    private static final String POSITION = "position";

    private String mText = null;
    private int mPosition = 0;

    public static SampleFragment newInstance(String paramStr, int paramInt) {
        SampleFragment fragment = new SampleFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, paramStr);
        args.putInt(POSITION, paramInt);
        fragment.setArguments(args);
        return fragment;
    }
    public SampleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);
            mPosition = getArguments().getInt(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);

        if (mPosition != 0) {
            int c = (int)(Math.random() * 10 * mPosition);
            view.setBackgroundColor(Color.argb(0, c, c, c));
        }
        if (mText != null) {
            ((TextView)view.findViewById(R.id.text)).setText(mText);
        }

        return view;
    }
}
