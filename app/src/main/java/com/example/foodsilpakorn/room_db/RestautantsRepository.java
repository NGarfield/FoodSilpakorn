package com.example.foodsilpakorn.room_db;

import android.os.AsyncTask;
import android.content.Context;

import com.example.foodsilpakorn.model.Restaurants;

import java.util.List;

public class RestautantsRepository {

    private Context mContext;

    public RestautantsRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getRestautants(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertRestautants(Restaurants item, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<Restaurants>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<Restaurants> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<Restaurants> itemList = db.restaurantsDao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<Restaurants> restaurantsItemList) {
            super.onPostExecute(restaurantsItemList);

            mCallback.onGetLedger(restaurantsItemList);
        }
    } // ปิด GetTask

    public interface Callback {
        void onGetLedger(List<Restaurants> itemList);
    }

    private static class InsertTask extends AsyncTask<Restaurants, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(Restaurants... ledgerItems) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.restaurantsDao().insertRestaurants(ledgerItems[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    } // ปิด InsertTask

    public interface InsertCallback {
        void onInsertSuccess();
    }


}
