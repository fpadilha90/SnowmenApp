package com.fpadilha.snowmen.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fpadilha.snowmen.helpers.SnowmanHelper;
import com.fpadilha.snowmen.models.Snowman;
import com.fpadilha.snowmen.views.SnowmanView;
import com.fpadilha.snowmen.views.SnowmanView_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe on 08/07/2016.
 */
@EBean
public class SnowmenListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    private List<Snowman> items;

    @AfterInject void initAdapter() {
        items = new ArrayList<>();

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Snowman getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final SnowmanView snowmanView;

        Snowman snowman = getItem(position);

        if (convertView == null) {
            snowmanView = SnowmanView_.build(context);
        } else {
            snowmanView = (SnowmanView) convertView;
        }

        snowmanView.bind(snowman);

        return snowmanView;
    }


    public void bind() {
        items = SnowmanHelper.getAll(context);

    }
}
