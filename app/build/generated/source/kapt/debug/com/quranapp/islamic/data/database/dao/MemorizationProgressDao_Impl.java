package com.quranapp.islamic.data.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.quranapp.islamic.data.database.entities.MemorizationProgressEntity;
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

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MemorizationProgressDao_Impl implements MemorizationProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MemorizationProgressEntity> __insertionAdapterOfMemorizationProgressEntity;

  public MemorizationProgressDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMemorizationProgressEntity = new EntityInsertionAdapter<MemorizationProgressEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `memorization_progress` (`ayah_id`,`level`,`next_review_date`,`interval`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MemorizationProgressEntity entity) {
        statement.bindLong(1, entity.getAyahId());
        statement.bindLong(2, entity.getLevel());
        statement.bindLong(3, entity.getNextReviewDate());
        statement.bindLong(4, entity.getInterval());
      }
    };
  }

  @Override
  public Object saveProgress(final MemorizationProgressEntity progress,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMemorizationProgressEntity.insert(progress);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllMemorizationProgress(
      final Continuation<? super List<MemorizationProgressEntity>> $completion) {
    final String _sql = "SELECT * FROM memorization_progress";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<MemorizationProgressEntity>>() {
      @Override
      @NonNull
      public List<MemorizationProgressEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAyahId = CursorUtil.getColumnIndexOrThrow(_cursor, "ayah_id");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfNextReviewDate = CursorUtil.getColumnIndexOrThrow(_cursor, "next_review_date");
          final int _cursorIndexOfInterval = CursorUtil.getColumnIndexOrThrow(_cursor, "interval");
          final List<MemorizationProgressEntity> _result = new ArrayList<MemorizationProgressEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MemorizationProgressEntity _item;
            final int _tmpAyahId;
            _tmpAyahId = _cursor.getInt(_cursorIndexOfAyahId);
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final long _tmpNextReviewDate;
            _tmpNextReviewDate = _cursor.getLong(_cursorIndexOfNextReviewDate);
            final int _tmpInterval;
            _tmpInterval = _cursor.getInt(_cursorIndexOfInterval);
            _item = new MemorizationProgressEntity(_tmpAyahId,_tmpLevel,_tmpNextReviewDate,_tmpInterval);
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
