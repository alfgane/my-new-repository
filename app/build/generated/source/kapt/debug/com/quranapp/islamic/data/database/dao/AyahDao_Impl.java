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
import com.quranapp.islamic.data.database.entities.AyahEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class AyahDao_Impl implements AyahDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AyahEntity> __insertionAdapterOfAyahEntity;

  public AyahDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAyahEntity = new EntityInsertionAdapter<AyahEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ayah` (`id`,`surah_number`,`ayah_number`,`text`,`text_simple`,`juz`,`page`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AyahEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSurahNumber());
        statement.bindLong(3, entity.getAyahNumber());
        if (entity.getText() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getText());
        }
        if (entity.getTextSimple() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTextSimple());
        }
        statement.bindLong(6, entity.getJuz());
        statement.bindLong(7, entity.getPage());
      }
    };
  }

  @Override
  public Object insertAll(final List<AyahEntity> ayahs,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAyahEntity.insert(ayahs);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AyahEntity>> getAyahsForSurah(final int surahNumber) {
    final String _sql = "SELECT * FROM ayah WHERE surah_number = ? ORDER BY ayah_number ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, surahNumber);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ayah"}, new Callable<List<AyahEntity>>() {
      @Override
      @NonNull
      public List<AyahEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSurahNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "surah_number");
          final int _cursorIndexOfAyahNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "ayah_number");
          final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
          final int _cursorIndexOfTextSimple = CursorUtil.getColumnIndexOrThrow(_cursor, "text_simple");
          final int _cursorIndexOfJuz = CursorUtil.getColumnIndexOrThrow(_cursor, "juz");
          final int _cursorIndexOfPage = CursorUtil.getColumnIndexOrThrow(_cursor, "page");
          final List<AyahEntity> _result = new ArrayList<AyahEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AyahEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpSurahNumber;
            _tmpSurahNumber = _cursor.getInt(_cursorIndexOfSurahNumber);
            final int _tmpAyahNumber;
            _tmpAyahNumber = _cursor.getInt(_cursorIndexOfAyahNumber);
            final String _tmpText;
            if (_cursor.isNull(_cursorIndexOfText)) {
              _tmpText = null;
            } else {
              _tmpText = _cursor.getString(_cursorIndexOfText);
            }
            final String _tmpTextSimple;
            if (_cursor.isNull(_cursorIndexOfTextSimple)) {
              _tmpTextSimple = null;
            } else {
              _tmpTextSimple = _cursor.getString(_cursorIndexOfTextSimple);
            }
            final int _tmpJuz;
            _tmpJuz = _cursor.getInt(_cursorIndexOfJuz);
            final int _tmpPage;
            _tmpPage = _cursor.getInt(_cursorIndexOfPage);
            _item = new AyahEntity(_tmpId,_tmpSurahNumber,_tmpAyahNumber,_tmpText,_tmpTextSimple,_tmpJuz,_tmpPage);
            _result.add(_item);
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
  public Object getTotalAyahCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM ayah";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
