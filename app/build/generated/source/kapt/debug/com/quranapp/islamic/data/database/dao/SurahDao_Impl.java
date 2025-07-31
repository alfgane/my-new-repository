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
import com.quranapp.islamic.data.database.entities.SurahEntity;
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
public final class SurahDao_Impl implements SurahDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SurahEntity> __insertionAdapterOfSurahEntity;

  public SurahDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSurahEntity = new EntityInsertionAdapter<SurahEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `surah` (`surahNumber`,`nameArabic`,`nameTransliterated`,`versesCount`,`revelationPlace`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SurahEntity entity) {
        statement.bindLong(1, entity.getSurahNumber());
        if (entity.getNameArabic() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNameArabic());
        }
        if (entity.getNameTransliterated() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNameTransliterated());
        }
        statement.bindLong(4, entity.getVersesCount());
        if (entity.getRevelationPlace() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getRevelationPlace());
        }
      }
    };
  }

  @Override
  public Object insertAll(final List<SurahEntity> surahs,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSurahEntity.insert(surahs);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SurahEntity>> getAllSurahs() {
    final String _sql = "SELECT * FROM surah ORDER BY surahNumber ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"surah"}, new Callable<List<SurahEntity>>() {
      @Override
      @NonNull
      public List<SurahEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSurahNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "surahNumber");
          final int _cursorIndexOfNameArabic = CursorUtil.getColumnIndexOrThrow(_cursor, "nameArabic");
          final int _cursorIndexOfNameTransliterated = CursorUtil.getColumnIndexOrThrow(_cursor, "nameTransliterated");
          final int _cursorIndexOfVersesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "versesCount");
          final int _cursorIndexOfRevelationPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "revelationPlace");
          final List<SurahEntity> _result = new ArrayList<SurahEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SurahEntity _item;
            final int _tmpSurahNumber;
            _tmpSurahNumber = _cursor.getInt(_cursorIndexOfSurahNumber);
            final String _tmpNameArabic;
            if (_cursor.isNull(_cursorIndexOfNameArabic)) {
              _tmpNameArabic = null;
            } else {
              _tmpNameArabic = _cursor.getString(_cursorIndexOfNameArabic);
            }
            final String _tmpNameTransliterated;
            if (_cursor.isNull(_cursorIndexOfNameTransliterated)) {
              _tmpNameTransliterated = null;
            } else {
              _tmpNameTransliterated = _cursor.getString(_cursorIndexOfNameTransliterated);
            }
            final int _tmpVersesCount;
            _tmpVersesCount = _cursor.getInt(_cursorIndexOfVersesCount);
            final String _tmpRevelationPlace;
            if (_cursor.isNull(_cursorIndexOfRevelationPlace)) {
              _tmpRevelationPlace = null;
            } else {
              _tmpRevelationPlace = _cursor.getString(_cursorIndexOfRevelationPlace);
            }
            _item = new SurahEntity(_tmpSurahNumber,_tmpNameArabic,_tmpNameTransliterated,_tmpVersesCount,_tmpRevelationPlace);
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
  public Object getSurah(final int surahNumber,
      final Continuation<? super SurahEntity> $completion) {
    final String _sql = "SELECT * FROM surah WHERE surahNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, surahNumber);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SurahEntity>() {
      @Override
      @NonNull
      public SurahEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSurahNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "surahNumber");
          final int _cursorIndexOfNameArabic = CursorUtil.getColumnIndexOrThrow(_cursor, "nameArabic");
          final int _cursorIndexOfNameTransliterated = CursorUtil.getColumnIndexOrThrow(_cursor, "nameTransliterated");
          final int _cursorIndexOfVersesCount = CursorUtil.getColumnIndexOrThrow(_cursor, "versesCount");
          final int _cursorIndexOfRevelationPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "revelationPlace");
          final SurahEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpSurahNumber;
            _tmpSurahNumber = _cursor.getInt(_cursorIndexOfSurahNumber);
            final String _tmpNameArabic;
            if (_cursor.isNull(_cursorIndexOfNameArabic)) {
              _tmpNameArabic = null;
            } else {
              _tmpNameArabic = _cursor.getString(_cursorIndexOfNameArabic);
            }
            final String _tmpNameTransliterated;
            if (_cursor.isNull(_cursorIndexOfNameTransliterated)) {
              _tmpNameTransliterated = null;
            } else {
              _tmpNameTransliterated = _cursor.getString(_cursorIndexOfNameTransliterated);
            }
            final int _tmpVersesCount;
            _tmpVersesCount = _cursor.getInt(_cursorIndexOfVersesCount);
            final String _tmpRevelationPlace;
            if (_cursor.isNull(_cursorIndexOfRevelationPlace)) {
              _tmpRevelationPlace = null;
            } else {
              _tmpRevelationPlace = _cursor.getString(_cursorIndexOfRevelationPlace);
            }
            _result = new SurahEntity(_tmpSurahNumber,_tmpNameArabic,_tmpNameTransliterated,_tmpVersesCount,_tmpRevelationPlace);
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
