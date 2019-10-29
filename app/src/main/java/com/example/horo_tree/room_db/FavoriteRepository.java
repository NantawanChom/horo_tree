package com.example.horo_tree.room_db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Delete;

import com.example.horo_tree.model.Favorites_Tree;

import java.util.List;

public class FavoriteRepository {
    private Context mContext;

    public FavoriteRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void insertFavorite(Favorites_Tree item, InsertCallback callback){
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    public void getFavorite(CallBack callBack){
        GetTask getTask = new GetTask(mContext, callBack);
        getTask.execute();
    }

    private static class GetTask extends AsyncTask<Void, Void, List<Favorites_Tree>> {
        private Context mContext;
        private CallBack mCallback;

        public GetTask(Context context, CallBack callBack) {
            this.mContext=context;
            this.mCallback=callBack;
        }

        @Override
        protected List<Favorites_Tree> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<Favorites_Tree> itemList = db.FavoriteDao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<Favorites_Tree> FavoriteItemList) {
            super.onPostExecute(FavoriteItemList);

            mCallback.onGetFavorite(FavoriteItemList);
        }
    }

    public interface CallBack{
        void onGetFavorite(List<Favorites_Tree> itemList);
    }

    private static class InsertTask extends AsyncTask<Favorites_Tree, Void, Void>{

        private Context mContext;
        private InsertCallback mCallback;
        public InsertTask(Context context, InsertCallback callback) {
            this.mContext=context;
            this.mCallback=callback;
        }

        @Override
        protected Void doInBackground(Favorites_Tree... Items) {
            AppDatabase db=AppDatabase.getInstance(mContext);
            db.FavoriteDao().insert(Items[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    }

    public interface InsertCallback{
        void onInsertSuccess();
    }

    //Delete Task

    public void DeleteFavorite(Favorites_Tree item, DeleteCallback callback){
        DeleteTask deleteTask = new DeleteTask(mContext, callback);
        deleteTask.execute(item);
    }

    private static class DeleteTask extends AsyncTask<Favorites_Tree, Void, Void>{

        private Context mContext;
        private DeleteCallback mCallback;
        public DeleteTask(Context context, DeleteCallback callback) {
            this.mContext=context;
            this.mCallback=callback;
        }

        @Override
        protected Void doInBackground(Favorites_Tree... Items) {
            AppDatabase db=AppDatabase.getInstance(mContext);
            List<Favorites_Tree>favor=db.FavoriteDao().getAll();
            for(Favorites_Tree f : favor){
                if(f.name.equals(Items[0].name)){
                    db.FavoriteDao().delete(f);
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onDeleteSuccess();
        }
    }

    public interface DeleteCallback{
        void onDeleteSuccess();
    }






}
