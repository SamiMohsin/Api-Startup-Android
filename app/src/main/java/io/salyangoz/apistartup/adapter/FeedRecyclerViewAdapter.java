package io.salyangoz.apistartup.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.salyangoz.apistartup.R;
import io.salyangoz.apistartup.adapter.dummy.DummyContent;
import io.salyangoz.apistartup.fragment.FeedFragment;

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<FeedRecyclerViewAdapter.ViewHolder> {

    private final List<DummyContent.DummyItem> mValues;
    private final FeedFragment.OnListFragmentInteractionListener mListener;

    public FeedRecyclerViewAdapter(List<DummyContent.DummyItem> items, FeedFragment.OnListFragmentInteractionListener listener) {

        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyContent.DummyItem mItem;

        public ViewHolder(View view) {

            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {

            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
