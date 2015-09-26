package com.sleekcreative.testinginadroid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    View mRoot;
    TextView textView;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String emailLoginText = bundle.getString(MainActivity.EXTRA);

        mRoot = inflater.inflate(R.layout.fragment_main, container, false);
        textView = (TextView) mRoot.findViewById(R.id.login_email_text);
        textView.setText(emailLoginText);

        return mRoot;
    }
}