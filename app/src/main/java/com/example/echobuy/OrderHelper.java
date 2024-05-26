package com.example.echobuy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OrderDB";
    private static final String TABLE_ORDERS = "orders";
    private static final String KEY_ID = "id";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_PRICE = "price";

    public OrderHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_IMAGE + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_PRICE + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(CREATE_ORDERS_TABLE);
    }

    public void addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE, order.getImage());
        values.put(KEY_NAME, order.getName());
        values.put(KEY_DESCRIPTION, order.getDescription());
        values.put(KEY_PRICE, order.getPrice());

        db.insert(TABLE_ORDERS, null, values);
        db.close();
    }
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_ORDERS,
                new String[]{KEY_ID, KEY_IMAGE, KEY_NAME, KEY_DESCRIPTION, KEY_PRICE},
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int imageIndex = cursor.getColumnIndex(KEY_IMAGE);
            int nameIndex = cursor.getColumnIndex(KEY_NAME);
            int descriptionIndex = cursor.getColumnIndex(KEY_DESCRIPTION);
            int priceIndex = cursor.getColumnIndex(KEY_PRICE);

            while (cursor.moveToNext()) {
                if (idIndex != -1 && imageIndex != -1 && nameIndex != -1 && descriptionIndex != -1 && priceIndex != -1) {
                    int id = cursor.getInt(idIndex);
                    String image = cursor.getString(imageIndex);
                    String name = cursor.getString(nameIndex);
                    String description = cursor.getString(descriptionIndex);
                    String price = cursor.getString(priceIndex);

                    Order order = new Order( image, name, description, price);
                    orderList.add(order);
                }
            }

            cursor.close();
        }

        db.close();
        return orderList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olderVersion, int newVersion) {
        sqLiteDatabase.execSQL ("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        onCreate(sqLiteDatabase);
    }
}
