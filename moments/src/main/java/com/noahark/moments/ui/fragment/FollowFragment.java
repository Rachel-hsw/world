/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.noahark.moments.ui.fragment;

import android.os.Bundle;
import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.noahark.moments.R;
import com.noahark.moments.bean.FollowBean;
import com.noahark.moments.ui.adapter.FollowAdapter;

import java.util.ArrayList;
import java.util.List;

public class FollowFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private ListView mFollowListView;
    private List<FollowBean> mFollowBeanList;
    private FollowAdapter mFollowListAdapter;
//	private ListView mFollowSelectListView;
//	private EditText mFollowSelectEditText;
//	private TextView mFollowSelectCancelBtn;

    private PtrClassicFrameLayout refreshLayout;
    Handler handler = new Handler();

    private int position;

    public static FollowFragment newInstance(int position) {
        FollowFragment followFragment = new FollowFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION, position);
        followFragment.setArguments(bundle);
        return followFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listitem_chat_header,container,false);
        return rootView;
    }


    public void addListItem(FollowBean followBean)
    {
        mFollowBeanList.add(followBean);
        mFollowListAdapter.notifyDataSetChanged(); //通知更新列表
    }
}