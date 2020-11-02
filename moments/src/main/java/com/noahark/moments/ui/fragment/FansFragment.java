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
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.noahark.moments.R;
import com.noahark.moments.bean.ChatBean;
import com.noahark.moments.bean.FanBean;
import com.noahark.moments.ui.adapter.ChatAdapter;
import com.noahark.moments.ui.adapter.FansAdapter;

import java.util.ArrayList;
import java.util.List;

public class FansFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private ListView mFanListView;
	private PtrClassicFrameLayout refreshLayout;

	Handler handler = new Handler();


	public static FansFragment newInstance(int position) {
		FansFragment FanFragment = new FansFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(ARG_POSITION, position);
		FanFragment.setArguments(bundle);
		return FanFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_fans,container,false);
		mFanListView = (ListView) rootView.findViewById(R.id.fanlist);

		//读取本地存放的，头像、昵称、时间、最近一条聊天记录！！！！！！！！！！
		List<ChatBean> chatBeanList = new ArrayList<ChatBean>();

		//用户数据
		ChatBean chatBean = new ChatBean();
		chatBean.setAvatar("http://imgsrc.baidu.com/forum/w%3D580/sign=537a10b1b899a9013b355b3e2d940a58/00bacbef76094b36e0e5d748a3cc7cd98d109d33.jpg");
		chatBean.setNickname("黄烁文");
		chatBean.setDate("2019/09/28");
		chatBean.setContent("我想变成一棵树，开心时，在秋天开花。伤心时，在春天落叶。");

		//加入
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);
		chatBeanList.add(chatBean);

		//表项
		ChatAdapter adapter = new ChatAdapter(getContext(),chatBeanList);
		mFanListView.setAdapter(adapter);

		refreshLayout = (PtrClassicFrameLayout)rootView.findViewById(R.id.refresh_layout_fan);

		//初次自动加载
		refreshLayout.postDelayed(new Runnable() {
			@Override
			public void run() {
				refreshLayout.autoRefresh(true);
			}
		}, 150);

		//下拉加载
		refreshLayout.setPtrHandler(new PtrDefaultHandler() {

			@Override
			public void onRefreshBegin(PtrFrameLayout frame) {
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {

						refreshLayout.refreshComplete();
					}
				}, 1500);
			}
		});

		return rootView;
	}

}