package fr.xebia.fabtuto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_rv);
        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 100; i++) {
            adapter.add("Item " + i);
        }
    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

        @NonNull
        private List<String> mItems = new ArrayList<>();

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.view_item, parent, false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            holder.bind(getItem(position));
        }

        private String getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void addAll(List<String> strings) {
            mItems.addAll(strings);
        }

        void add(String s) {
            mItems.add(s);
        }
    }

    private class MainViewHolder extends RecyclerView.ViewHolder {

        private final TextView mItemTextView;

        MainViewHolder(final View itemView) {
            super(itemView);

            mItemTextView = itemView.findViewById(R.id.item_tv);

            mItemTextView.setOnClickListener(
                    v -> DetailActivity.navigate(
                            itemView.getContext(),
                            String.valueOf(mItemTextView.getText())));
        }

        void bind(String item) {
            mItemTextView.setText(item);
        }
    }
}
