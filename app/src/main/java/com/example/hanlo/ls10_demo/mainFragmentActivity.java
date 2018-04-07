package com.example.hanlo.ls10_demo;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hanlo on 4/5/2018.
 */


public class mainFragmentActivity extends Fragment {

    private Button calculateLoveButton;
    private String mashKey = "zA9LY0fNXNmsh1SOJaOaqsArk9rIp13STo8jsn6YKY40V2zZ3t";
    private String urlParam = "";
    private String json = null;
    private Intent intent = null;
    private String result = null;
    private String percent = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //add all get variables here
        calculateLoveButton = (Button) view.findViewById(R.id.calculateLove);


        // set on click listener for buttons see video @ 12:00
        calculateLoveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Calculating Love...", Toast.LENGTH_SHORT).show();
                //call JSON
                onCalculateLove(view);
                //((MainActivity)getActivity()).setViewPager(1);
            }
        });

        return view;


    }


    //called on click of the main button that takes the two names and sends them to the API
    //the sends the name and results to then next page
    public void onCalculateLove(View view) {
        //get edit text boxes
        EditText firstname = (EditText) view.findViewById(R.id.first_name_input);
        EditText secondname = (EditText) view.findViewById(R.id.second_name_input);
        //convert the textfield to a string value
        String firstinput = firstname.getText().toString().trim();
        String secondinput = secondname.getText().toString().trim();
        System.out.println("FirstInput:" + firstinput);
        System.out.println("SecondInput:" + secondinput);
        //create the concatenated url params for API
        urlParam = "https://love-calculator.p.mashape.com/getPercentage?fname=" + firstinput + "&sname=" + secondinput + "&mashape-key=" + mashKey;
        //Go to async task
        new JSONTask().execute(urlParam);

    }

    //classs to take url and get data in JSON format from API
    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            //create url connection and buffered reader to connect and readliens from the API
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                //open url connection
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                //get input stream
                InputStream stream = connection.getInputStream();

                //create buffered reader to read lines of data
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                try {
                    json = buffer.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //try blocks to wrap up the server connection and close the reader
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //after JSON data has been grabbed execute the intent
            String resultJSON = null;
            String percentageJSON = null;
            try {
                //parse the JSON object into Result and Percentage
                System.out.println("JSON: " + json);
                JSONObject jsonObject = new JSONObject(json);
                resultJSON = jsonObject.getString("result");
                percentageJSON = jsonObject.getString("percentage");
//                result = resultJSON;
//                percent = percentageJSON;

            } catch (JSONException e) {
                e.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString("result", resultJSON);
            bundle.putString("percent", percentageJSON);
            secondary_FragmentActivity secondary_fragmentActivity = new secondary_FragmentActivity();
            secondary_fragmentActivity.setArguments(bundle);

            ((MainActivity) getActivity()).setViewPager(1);

//            //begin intent
//            if (main != null) {
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                secondary_FragmentPagerAdapter secondary_FragmentPagerAdapter= new secondary_FragmentPagerAdapter();
//
//                ((MainActivity)getActivity()).setViewPager(1);
//
//                resultActivity.setData(percentage, result);
//
//                ft.addToBackStack(null);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.commit();
//            } else {
//                //Create intent and send it to the result activity
//                intent = new Intent(MainScreen.this, ResultActivity.class);
//                //add extra information onto the intent
//                intent.putExtra(ResultActivity.RESULT, result);
//                intent.putExtra(ResultActivity.PERCENTAGE, percentage);
//                startActivity(intent);
//            }
        }
    }
}
