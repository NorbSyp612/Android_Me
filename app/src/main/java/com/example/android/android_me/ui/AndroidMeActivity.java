/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Only create new fragments when there is no previously saved state
        if(savedInstanceState == null) {

            // TODO (5) Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
                // Use setListindex(int index) to set the list index for all BodyPartFragments

            Intent intent = getIntent();



            // Create a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legFragment = new BodyPartFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(1);

            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(1);

            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(1);

            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();

            if (intent != null) {
                Bundle b = intent.getExtras();
                headIndex = b.getInt("headIndex");
                Log.d("TEST", "Head index is " + b.getInt("headIndex"));
                bodyIndex = b.getInt("bodyIndex");
                Log.d("TEST", "Body index is " + b.getInt("bodyIndex"));
                legIndex = b.getInt("legIndex");
                Log.d("TEST", "Leg index is " + b.getInt("legIndex"));


                headFragment.setListIndex(headIndex);
                bodyFragment.setListIndex(bodyIndex);
                legFragment.setListIndex(legIndex);
            }

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            // Create and display the body and leg BodyPartFragments


            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();


            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
