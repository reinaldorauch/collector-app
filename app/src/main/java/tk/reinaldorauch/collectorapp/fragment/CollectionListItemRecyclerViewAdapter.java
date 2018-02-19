package tk.reinaldorauch.collectorapp.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tk.reinaldorauch.collectorapp.R;
import tk.reinaldorauch.collectorapp.fragment.ItemFragment.OnListFragmentInteractionListener;
import tk.reinaldorauch.collectorapp.database.entity.Collection;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ListItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class CollectionListItemRecyclerViewAdapter extends RecyclerView.Adapter<CollectionListItemRecyclerViewAdapter.ViewHolder> {

    private List<Collection> mValues;
    private final OnListFragmentInteractionListener mListener;

    CollectionListItemRecyclerViewAdapter(List<Collection> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(mValues == null) {
            return;
        }
        holder.bind(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        if (mValues == null) {
            return 0;
        }
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = view.findViewById(R.id.content);
            mIdView = view.findViewById(R.id.id);
        }

        void bind(Collection item) {
            mIdView.setText(String.valueOf(item.getId()));
            mContentView.setText(item.toString());
        }

        @Override
        public String toString() {
            return super.toString() +
                    "#" + mIdView.getText() +
                    " '" + mContentView.getText() + "'";
        }
    }
}
