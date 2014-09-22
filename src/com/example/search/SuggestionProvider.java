package com.example.search;

import android.content.SearchRecentSuggestionsProvider;

/**
 * ------------------------- SuggestionProvider.java -------------------------
 * Todo say something like how this class works
 * <p/>
 *
 * @author Created by zachary on 14-9-22 15:35.
 */
public class SuggestionProvider extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY = "com.example.search.SuggestionProvider";
    public static final int MODE = DATABASE_MODE_QUERIES;

    public SuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
