package com.quranapp.islamic.data.database.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.quranapp.islamic.data.database.entities.AyahEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SearchDao_Impl implements SearchDao {
  private final RoomDatabase __db;

  public SearchDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public Flow<List<AyahEntity>> searchAyahs(final String query) {
    final String _sql = "SELECT * FROM ayah WHERE id IN (SELECT docid FROM ayah_fts WHERE ayah_fts MATCH ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ayah",
        "ayah_fts"}, new Callable<List<AyahEntity>>() {
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
