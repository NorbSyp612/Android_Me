package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {

    private List<Integer> mImageIds;
    private ImageView mGridView;

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mImageIds = AndroidImageAssets.getAll();
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        int i = 0;

        for (int a : mImageIds) {
            mGridView = (ImageView) rootView.findViewById(a);
            mGridView.setImageResource(mImageIds.get(0));
            i++;
        }


        Context context = getContext();
        MasterListAdapter adapter = new MasterListAdapter(context, mImageIds);

    return rootView;
    }



}
