package com.quranapp.islamic.data.database.dao;

import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.quranapp.islamic.data.database.entities.TafsirEntity;
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
public final class TafsirDao_Impl implements TafsirDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TafsirEntity> __insertionAdapterOfTafsirEntity;

  public TafsirDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTafsirEntity = new EntityInsertionAdapter<TafsirEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tafsir` (`id`,`author`,`text`,`ayah_id`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TafsirEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getAuthor() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAuthor());
        }
        if (entity.getText() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getText());
        }
        statement.bindLong(4, entity.getAyahId());
      }
    };
  }

  @Override
  public Object insertAll(final List<TafsirEntity> tafsirs,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTafsirEntity.insert(tafsirs);
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
