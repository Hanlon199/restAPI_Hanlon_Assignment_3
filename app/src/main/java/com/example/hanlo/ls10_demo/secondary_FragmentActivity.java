package com.example.hanlo.ls10_demo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hanlo on 4/5/2018.
 */

public class secondary_FragmentActivity extends Fragment {

    private Button returnHome;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_secondary_, container, false);
//        //get arguments from the bundle
//
//        String result       = getArguments().getString("result");
//        String percent      = getArguments().getString("percent");
//        String na           = "NA";
//        int percentage      = 0;
//        TextView percentContent   = (TextView) view.findViewById(R.id.percent_content);
//        TextView resultContent    = (TextView) view.findViewById(R.id.result_content);
//
//        //set the Textviews to the value from the intents
//        if(result == null && percent == null){
//            resultContent.setText(na);
//            percentContent.setText(na);
//            view.findViewById(R.id.love_result).setBackgroundResource(R.drawable.question);
//        }
//        else{
//            percentContent.setText(percent);
//            resultContent.setText(result);
//            percentage = Integer.parseInt(percent);
//            System.out.println("percentage: " + percentage);
//
//        }
//        if(percentage < 20){
//            view.findViewById(R.id.love_result).setBackgroundResource(R.drawable.gravestone);
//        }
//        if(percentage > 20 && percentage < 40){
//            view.findViewById(R.id.love_result).setBackgroundResource(R.drawable.brokenheart);
//        }
//        if(percentage > 40 && percentage < 80){
//            view.findViewById(R.id.love_result).setBackgroundResource(R.drawable.heart);
//        }
//        if(percentage > 80){
//            view.findViewById(R.id.love_result).setBackgroundResource(R.drawable.victory);
//        }
//        System.out.println("Image:" + view.findViewById(R.id.love_result).getTag());
//        //add all get variables here
//        returnHome = (Button) view.findViewById(R.id.returnHome);
//
//        // set on click listener for buttons see video @ 12:00
//        returnHome.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view){
//                //Toast.makeText(getActivity(), "Calculating Love...", Toast.LENGTH_SHORT).show();
//                //navigate to fragment method called
//                //Intent intent = new Intent(getActivity(),secondary_FragmentActivity.class);
//                //startActivity(intent);
//                ((MainActivity)getActivity()).setViewPager(0);
//            }
//        });

        return view;


    }
}
