package com.example.lql.testdemo.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.lql.testdemo.db.bean.TimingBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TIMING_BEAN".
*/
public class TimingBeanDao extends AbstractDao<TimingBean, Long> {

    public static final String TABLENAME = "TIMING_BEAN";

    /**
     * Properties of entity TimingBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property TimingId = new Property(0, Long.class, "TimingId", true, "_id");
        public final static Property MyTimingId = new Property(1, Integer.class, "MyTimingId", false, "MY_TIMING_ID");
        public final static Property Hour = new Property(2, Integer.class, "Hour", false, "HOUR");
        public final static Property Minute = new Property(3, Integer.class, "Minute", false, "MINUTE");
        public final static Property RepeatTime = new Property(4, String.class, "RepeatTime", false, "REPEAT_TIME");
        public final static Property IsOpen = new Property(5, boolean.class, "IsOpen", false, "IS_OPEN");
    };


    public TimingBeanDao(DaoConfig config) {
        super(config);
    }
    
    public TimingBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TIMING_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: TimingId
                "\"MY_TIMING_ID\" INTEGER," + // 1: MyTimingId
                "\"HOUR\" INTEGER," + // 2: Hour
                "\"MINUTE\" INTEGER," + // 3: Minute
                "\"REPEAT_TIME\" TEXT," + // 4: RepeatTime
                "\"IS_OPEN\" INTEGER NOT NULL );"); // 5: IsOpen
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TIMING_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TimingBean entity) {
        stmt.clearBindings();
 
        Long TimingId = entity.getTimingId();
        if (TimingId != null) {
            stmt.bindLong(1, TimingId);
        }
 
        Integer MyTimingId = entity.getMyTimingId();
        if (MyTimingId != null) {
            stmt.bindLong(2, MyTimingId);
        }
 
        Integer Hour = entity.getHour();
        if (Hour != null) {
            stmt.bindLong(3, Hour);
        }
 
        Integer Minute = entity.getMinute();
        if (Minute != null) {
            stmt.bindLong(4, Minute);
        }
 
        String RepeatTime = entity.getRepeatTime();
        if (RepeatTime != null) {
            stmt.bindString(5, RepeatTime);
        }
        stmt.bindLong(6, entity.getIsOpen() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TimingBean entity) {
        stmt.clearBindings();
 
        Long TimingId = entity.getTimingId();
        if (TimingId != null) {
            stmt.bindLong(1, TimingId);
        }
 
        Integer MyTimingId = entity.getMyTimingId();
        if (MyTimingId != null) {
            stmt.bindLong(2, MyTimingId);
        }
 
        Integer Hour = entity.getHour();
        if (Hour != null) {
            stmt.bindLong(3, Hour);
        }
 
        Integer Minute = entity.getMinute();
        if (Minute != null) {
            stmt.bindLong(4, Minute);
        }
 
        String RepeatTime = entity.getRepeatTime();
        if (RepeatTime != null) {
            stmt.bindString(5, RepeatTime);
        }
        stmt.bindLong(6, entity.getIsOpen() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TimingBean readEntity(Cursor cursor, int offset) {
        TimingBean entity = new TimingBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // TimingId
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // MyTimingId
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // Hour
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // Minute
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // RepeatTime
            cursor.getShort(offset + 5) != 0 // IsOpen
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TimingBean entity, int offset) {
        entity.setTimingId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMyTimingId(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setHour(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setMinute(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setRepeatTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsOpen(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TimingBean entity, long rowId) {
        entity.setTimingId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TimingBean entity) {
        if(entity != null) {
            return entity.getTimingId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
