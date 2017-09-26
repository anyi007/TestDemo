package com.example.lql.testdemo.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.lql.testdemo.db.bean.shop.CommoditySizeBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COMMODITY_SIZE_BEAN".
*/
public class CommoditySizeBeanDao extends AbstractDao<CommoditySizeBean, Long> {

    public static final String TABLENAME = "COMMODITY_SIZE_BEAN";

    /**
     * Properties of entity CommoditySizeBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CommoditySizeId = new Property(0, Long.class, "CommoditySizeId", true, "_id");
        public final static Property CommodityId = new Property(1, Long.class, "CommodityId", false, "COMMODITY_ID");
        public final static Property CommoditySizeContent = new Property(2, String.class, "CommoditySizeContent", false, "COMMODITY_SIZE_CONTENT");
    };


    public CommoditySizeBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CommoditySizeBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COMMODITY_SIZE_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: CommoditySizeId
                "\"COMMODITY_ID\" INTEGER," + // 1: CommodityId
                "\"COMMODITY_SIZE_CONTENT\" TEXT);"); // 2: CommoditySizeContent
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMMODITY_SIZE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CommoditySizeBean entity) {
        stmt.clearBindings();
 
        Long CommoditySizeId = entity.getCommoditySizeId();
        if (CommoditySizeId != null) {
            stmt.bindLong(1, CommoditySizeId);
        }
 
        Long CommodityId = entity.getCommodityId();
        if (CommodityId != null) {
            stmt.bindLong(2, CommodityId);
        }
 
        String CommoditySizeContent = entity.getCommoditySizeContent();
        if (CommoditySizeContent != null) {
            stmt.bindString(3, CommoditySizeContent);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CommoditySizeBean entity) {
        stmt.clearBindings();
 
        Long CommoditySizeId = entity.getCommoditySizeId();
        if (CommoditySizeId != null) {
            stmt.bindLong(1, CommoditySizeId);
        }
 
        Long CommodityId = entity.getCommodityId();
        if (CommodityId != null) {
            stmt.bindLong(2, CommodityId);
        }
 
        String CommoditySizeContent = entity.getCommoditySizeContent();
        if (CommoditySizeContent != null) {
            stmt.bindString(3, CommoditySizeContent);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CommoditySizeBean readEntity(Cursor cursor, int offset) {
        CommoditySizeBean entity = new CommoditySizeBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // CommoditySizeId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // CommodityId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // CommoditySizeContent
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CommoditySizeBean entity, int offset) {
        entity.setCommoditySizeId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCommodityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCommoditySizeContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CommoditySizeBean entity, long rowId) {
        entity.setCommoditySizeId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CommoditySizeBean entity) {
        if(entity != null) {
            return entity.getCommoditySizeId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
