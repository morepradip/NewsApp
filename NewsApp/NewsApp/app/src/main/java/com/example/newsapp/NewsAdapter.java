/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.newsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
//import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news items
        News currentNews = getItem(position);


        // Find the TextView with view section name
        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.section_name);
        // Display the location of the current news in that TextView
        sectionNameView.setText(currentNews.getSectionName());

        // Find the TextView with view title of the news article
        TextView webTitleView = (TextView) listItemView.findViewById(R.id.web_title);
        // Display the title of the current news in that TextView
        webTitleView.setText(currentNews.getWebTitle());

        // Find the TextView with view name of the author
        TextView authorNameView = (TextView) listItemView.findViewById(R.id.author_name);
        // Display the author of the current news in that TextView
        if (currentNews.getAuthorName() != null) {
            authorNameView.setText(currentNews.getAuthorName());
        }else {
            authorNameView.setVisibility(View.GONE);
        }
        
        // Find the TextView with view ID publication date
        TextView dateView = (TextView) listItemView.findViewById(R.id.web_publication_date);

        if (currentNews.getWebPublicationDate() != null ){
        // Display the date of the current news in that TextView
        dateView.setText(currentNews.getWebPublicationDate());
        }else {
            dateView.setVisibility(View.GONE);
        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


}
