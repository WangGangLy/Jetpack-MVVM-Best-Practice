/*
 * Copyright 2018-2019 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kunminx.puremusic.ui.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

/**
 * TODO 2020.4.18:
 *  将 DataBinding 实例限制于 base 页面中，不上升为类成员，更不向子类暴露，
 *  通过这样的方式，来彻底解决 视图调用的一致性问题，
 *  如此，视图刷新的安全性将和基于函数式编程的 Jetpack Compose 持平。
 *  而 DataBindingConfig 就是在这样的背景下，用于为 base 页面中的 DataBinding 提供最少必要的绑定项。
 *
 *  如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350 和 https://xiaozhuanlan.com/topic/2356748910
 *
 * Create by KunMinX at 20/4/18
 */
public class DataBindingConfig {

    private int layout;

    private ViewModel stateViewModel;

    private BaseFragment.ClickProxy clickProxy;

    private BaseFragment.EventHandler eventHandler;

    private RecyclerView.Adapter adapter;

    public DataBindingConfig(int layout, ViewModel stateViewModel) {
        this(layout, stateViewModel, null);
    }

    public DataBindingConfig(int layout, @NonNull ViewModel stateViewModel, BaseFragment.ClickProxy clickProxy) {
        this(layout, stateViewModel, clickProxy, null);
    }

    public DataBindingConfig(int layout, @NonNull ViewModel stateViewModel, BaseFragment.ClickProxy clickProxy, BaseFragment.EventHandler eventHandler) {
        this(layout, stateViewModel, clickProxy, eventHandler,null);
    }

    public DataBindingConfig(int layout, @NonNull ViewModel stateViewModel, BaseFragment.ClickProxy clickProxy, BaseFragment.EventHandler eventHandler, RecyclerView.Adapter adapter) {
        this.layout = layout;
        this.stateViewModel = stateViewModel;
        this.clickProxy = clickProxy;
        this.eventHandler = eventHandler;
        this.adapter = adapter;
    }

    public int getLayout() {
        return layout;
    }

    public ViewModel getStateViewModel() {
        return stateViewModel;
    }

    public BaseFragment.ClickProxy getClickProxy() {
        return clickProxy;
    }

    public BaseFragment.EventHandler getEventHandler() {
        return eventHandler;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }
}