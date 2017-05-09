package edu.weber.rhilton.cs3270.linearlayoutdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    TextView txvContainerName;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_, container, false);
        txvContainerName = (TextView) rootView.findViewById(R.id.txvContainerName);
        Log.d("test","FragmentA onCreateView()");

        return rootView;
    }

    public void setContainerName(String containerName) {
        Log.d("test","FragmentA setContainerName: " + containerName);
        Log.d("test","FragmentA txvContainerName = " + txvContainerName.toString());
        txvContainerName.setText(containerName);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("test","FragmentA onResume()");
/*        MainActivity ma = (MainActivity) getActivity();
        txvContainerName.setText(ma.getContainerName());*/
    }
}
