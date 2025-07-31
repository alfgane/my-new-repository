package com.quranapp.islamic.data.database.dao;

import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.quranapp.islamic.data.database.Converters;
import com.quranapp.islamic.data.database.entities.AudioTimingEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AudioTimingDao_Impl implements AudioTimingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AudioTimingEntity> __insertionAdapterOfAudioTimingEntity;

  private final Converters __converters = new Converters();

  public AudioTimingDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAudioTimingEntity = new EntityInsertionAdapter<AudioTimingEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `audio_timing` (`id`,`ayah_id`,`timings`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AudioTimingEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getAyahId());
        final String _tmp = __converters.fromLongList(entity.getTimings());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
      }
    };
  }

  @Override
  public Object insertAll(final List<AudioTimingEntity> timings,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAudioTimingEntity.insert(timings);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
