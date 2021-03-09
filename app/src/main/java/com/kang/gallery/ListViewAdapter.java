package com.kang.gallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    public ListViewAdapter() {}

    @Override
    public int getCount() { return listViewItemList.size(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.album_icon);
        TextView NameTextView = (TextView) convertView.findViewById(R.id.album_title);
        TextView NumTextView = (TextView) convertView.findViewById(R.id.album_num);

        ListViewItem listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        NameTextView.setText(listViewItem.getTitle());
        NumTextView.setText(listViewItem.getNum());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(Drawable icon, String title, String num) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setNum(num);

        listViewItemList.add(item);
    }

    public void deleteItem(int position) { listViewItemList.remove(position); }
}
