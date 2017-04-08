package id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;


/**
 * Created by kyle on 22/09/16.
 */

public class pengingat extends RecyclerView.Adapter<pengingat.ViewHolder> {

    public View.OnClickListener mListener = new reminderClickListener();
    public View.OnLongClickListener mLongListener = new reminderLongClickListener();
    private Context mContext;
    private Cursor mCursor;
    private database database;
    private RecyclerView mRecyclerView;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm, MMM d ''yy");


    public pengingat(Context context, Cursor cursor, RecyclerView recyclerView) {
        mContext = context;
        mCursor = cursor;
        mRecyclerView = recyclerView;
        database = new database(mContext);
    }

    private Context getContext() {
        return mContext;
    }

    // inflating layout from XML and returning the holder
    @Override
    public pengingat.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        if (database.isEmpty()) {
            View emptyView = parent.findViewById(R.id.empty);
            return new ViewHolder(emptyView);
        } else {

            // Inflate the custom layout
            View reminderView = inflater.inflate(R.layout.list, parent, false);

            // set click listener for every view holder
            reminderView.setOnClickListener(mListener);
            reminderView.setOnLongClickListener(mLongListener);

            // Return a new holder
            ViewHolder viewHolder = new ViewHolder(reminderView);
            return viewHolder;
        }
    }

    // Populating the items in the holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int id) {
        mCursor.moveToPosition(id);

        String type = mCursor.getString(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_TYPE1));
        if (type.equalsIgnoreCase("alert")) {
            viewHolder.time.setText(timeFormat.format(mCursor.getLong(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_TIME1))));
            viewHolder.icon.setImageResource(R.drawable.ic_bell_ring_grey600_18dp);
            viewHolder.time.setVisibility(View.VISIBLE);
            viewHolder.icon.setVisibility(View.VISIBLE);
        } else {
            viewHolder.time.setVisibility(View.GONE);
            viewHolder.icon.setVisibility(View.GONE);
        }

        viewHolder.title.setText(mCursor.getString(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_TITLE1)));
        viewHolder.content.setText(mCursor.getString(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_CONTENT1)));


    }

    public int getItemCount() {
        mCursor = database.getAllItems();
        return mCursor.getCount();
    }

    private AlertDialog deleteDialog(int id, final int position) {
        final int deleteId = id;
        final Cursor cursor = database.getItem(id);
        cursor.moveToFirst();

        return new AlertDialog.Builder(mContext)
                .setTitle("Confirm")
                .setMessage("Do you want to delete?")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int i) {

                        // remove the soon to be deleted view from RecyclerView and notify
                        mRecyclerView.removeViewAt(position);

                        // if the selected item for deletion is an alert, cancel the alarm


                        database.deleteItem(deleteId);

                        // sends refresh signal to Main UI
                        Intent refresh = new Intent("REFRESH");
                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(refresh);

                        dialog.dismiss();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();

                    }
                })
                .create();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView content;
        public TextView time;
        public ImageView icon;

        public ViewHolder(View view) {

            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.reminder);
            time = (TextView) view.findViewById(R.id.timeLabel);
            icon = (ImageView) view.findViewById(R.id.icon);

        }
    }

    // short click listener for viewing notes/alerts
    class reminderClickListener implements View.OnClickListener {
        public void onClick(View view) {
            int position = mRecyclerView.getChildAdapterPosition(view);
            mCursor.moveToPosition(position);
            Intent intent;
            String type = mCursor.getString(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_TYPE1));
            {
                intent = new Intent(mContext, createOrEditNote.class);
            }
            intent.putExtra("ID", mCursor.getInt(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_ID1)));
            mContext.startActivity(intent);
        }
    }

    class reminderLongClickListener implements View.OnLongClickListener {
        public boolean onLongClick(View view) {
            int position = mRecyclerView.getChildAdapterPosition(view);
            mCursor.moveToPosition(position);
            int id = mCursor.getInt(mCursor.getColumnIndex(id.sch.smktelkom_mlg.project2.xirpl506101216.duetomorrow.database.DB_COLUMN_ID1));
            deleteDialog(id, position).show();
            return true;
        }
    }

}


