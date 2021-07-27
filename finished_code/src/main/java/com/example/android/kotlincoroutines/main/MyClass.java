package com.example.android.kotlincoroutines.main;

import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.Queue;

import androidx.annotation.IdRes;

class MyClass {

    /**
     *
     */
    public View findViewById(ViewGroup viewGroup, @IdRes int id) {
        Queue<View> queue = new LinkedList<>();
        queue.add(viewGroup);

        while (!queue.isEmpty()) {
            View v = queue.poll();
            if (v.getId() ==  id) {
                return v;
            }
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i ++) {
                    queue.add(vg.getChildAt(i));
                }
            }
        }
        return null;
    }
}
