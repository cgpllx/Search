package com.example.search;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ------------------------- SearchResultActivity.java -------------------------
 * Todo say something like how this class works
 * <p/>
 *
 * @author Created by zachary on 14-9-22 14:01.
 */
public class SearchResultActivity extends Activity {

    private TextView mTvSearchKey;
    private Button mBtnClearHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        mTvSearchKey = (TextView) findViewById(R.id.tvSearchKey);
        mBtnClearHistory = (Button) findViewById(R.id.btnClearHistory);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this, SuggestionProvider.AUTHORITY, SuggestionProvider.MODE);
            suggestions.saveRecentQuery(query, null);
            mTvSearchKey.setText(query);
        }


        mBtnClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchRecentSuggestions suggestions = new SearchRecentSuggestions(getApplicationContext(), SuggestionProvider.AUTHORITY, SuggestionProvider.MODE);
                suggestions.clearHistory();
            }
        });
    }

}
