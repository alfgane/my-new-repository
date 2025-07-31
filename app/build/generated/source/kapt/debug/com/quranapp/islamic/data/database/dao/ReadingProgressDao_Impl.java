package com.quranapp.islamic.data.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.quranapp.islamic.data.database.entities.ReadingProgressEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReadingProgressDao_Impl implements ReadingProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ReadingProgressEntity> __insertionAdapterOfReadingProgressEntity;

  public ReadingProgressDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReadingProgressEntity = new EntityInsertionAdapter<ReadingProgressEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `reading_progress` (`id`,`last_read_surah`,`last_read_ayah`,`timestamp`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ReadingProgressEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getLastReadSurah());
        statement.bindLong(3, entity.getLastReadAyah());
        statement.bindLong(4, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object saveProgress(final ReadingProgressEntity progress,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfReadingProgressEntity.insert(progress);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<ReadingProgressEntity> getProgress() {
    final String _sql = "SELECT * FROM reading_progress WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"reading_progress"}, new Callable<ReadingProgressEntity>() {
      @Override
      @Nullable
      public ReadingProgressEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLastReadSurah = CursorUtil.getColumnIndexOrThrow(_cursor, "last_read_surah");
          final int _cursorIndexOfLastReadAyah = CursorUtil.getColumnIndexOrThrow(_cursor, "last_read_ayah");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final ReadingProgressEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpLastReadSurah;
            _tmpLastReadSurah = _cursor.getInt(_cursorIndexOfLastReadSurah);
            final int _tmpLastReadAyah;
            _tmpLastReadAyah = _cursor.getInt(_cursorIndexOfLastReadAyah);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new ReadingProgressEntity(_tmpId,_tmpLastReadSurah,_tmpLastReadAyah,_tmpTimestamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAllReadingProgress(
      final Continuation<? super List<ReadingProgressEntity>> $completion) {
    final String _sql = "SELECT * FROM reading_progress";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ReadingProgressEntity>>() {
      @Override
      @NonNull
      public List<ReadingProgressEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLastReadSurah = CursorUtil.getColumnIndexOrThrow(_cursor, "last_read_surah");
          final int _cursorIndexOfLastReadAyah = CursorUtil.getColumnIndexOrThrow(_cursor, "last_read_ayah");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<ReadingProgressEntity> _result = new ArrayList<ReadingProgressEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ReadingProgressEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpLastReadSurah;
            _tmpLastReadSurah = _cursor.getInt(_cursorIndexOfLastReadSurah);
            final int _tmpLastReadAyah;
            _tmpLastReadAyah = _cursor.getInt(_cursorIndexOfLastReadAyah);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new ReadingProgressEntity(_tmpId,_tmpLastReadSurah,_tmpLastReadAyah,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
