package com.quranapp.islamic.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.FtsTableInfo;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.quranapp.islamic.data.database.dao.AudioTimingDao;
import com.quranapp.islamic.data.database.dao.AudioTimingDao_Impl;
import com.quranapp.islamic.data.database.dao.AyahDao;
import com.quranapp.islamic.data.database.dao.AyahDao_Impl;
import com.quranapp.islamic.data.database.dao.BookmarkDao;
import com.quranapp.islamic.data.database.dao.BookmarkDao_Impl;
import com.quranapp.islamic.data.database.dao.MemorizationProgressDao;
import com.quranapp.islamic.data.database.dao.MemorizationProgressDao_Impl;
import com.quranapp.islamic.data.database.dao.NoteDao;
import com.quranapp.islamic.data.database.dao.NoteDao_Impl;
import com.quranapp.islamic.data.database.dao.ReadingProgressDao;
import com.quranapp.islamic.data.database.dao.ReadingProgressDao_Impl;
import com.quranapp.islamic.data.database.dao.ReciterDao;
import com.quranapp.islamic.data.database.dao.ReciterDao_Impl;
import com.quranapp.islamic.data.database.dao.SearchDao;
import com.quranapp.islamic.data.database.dao.SearchDao_Impl;
import com.quranapp.islamic.data.database.dao.SurahDao;
import com.quranapp.islamic.data.database.dao.SurahDao_Impl;
import com.quranapp.islamic.data.database.dao.TafsirDao;
import com.quranapp.islamic.data.database.dao.TafsirDao_Impl;
import com.quranapp.islamic.data.database.dao.TranslationDao;
import com.quranapp.islamic.data.database.dao.TranslationDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class QuranDatabase_Impl extends QuranDatabase {
  private volatile SurahDao _surahDao;

  private volatile AyahDao _ayahDao;

  private volatile SearchDao _searchDao;

  private volatile TranslationDao _translationDao;

  private volatile TafsirDao _tafsirDao;

  private volatile BookmarkDao _bookmarkDao;

  private volatile NoteDao _noteDao;

  private volatile ReadingProgressDao _readingProgressDao;

  private volatile MemorizationProgressDao _memorizationProgressDao;

  private volatile ReciterDao _reciterDao;

  private volatile AudioTimingDao _audioTimingDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `surah` (`surahNumber` INTEGER NOT NULL, `nameArabic` TEXT NOT NULL, `nameTransliterated` TEXT NOT NULL, `versesCount` INTEGER NOT NULL, `revelationPlace` TEXT NOT NULL, PRIMARY KEY(`surahNumber`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ayah` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `surah_number` INTEGER NOT NULL, `ayah_number` INTEGER NOT NULL, `text` TEXT NOT NULL, `text_simple` TEXT NOT NULL, `juz` INTEGER NOT NULL, `page` INTEGER NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ayah_surah_number_ayah_number` ON `ayah` (`surah_number`, `ayah_number`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `translation` (`id` INTEGER NOT NULL, `author` TEXT NOT NULL, `text` TEXT NOT NULL, `ayah_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tafsir` (`id` INTEGER NOT NULL, `author` TEXT NOT NULL, `text` TEXT NOT NULL, `ayah_id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `audio_timing` (`id` INTEGER NOT NULL, `ayah_id` INTEGER NOT NULL, `timings` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `reciter` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `style` TEXT, `audio_url` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `bookmark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ayah_id` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `note` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ayah_id` INTEGER NOT NULL, `content` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `reading_progress` (`id` INTEGER NOT NULL, `last_read_surah` INTEGER NOT NULL, `last_read_ayah` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `memorization_progress` (`ayah_id` INTEGER NOT NULL, `level` INTEGER NOT NULL, `next_review_date` INTEGER NOT NULL, `interval` INTEGER NOT NULL, PRIMARY KEY(`ayah_id`))");
        db.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `ayah_fts` USING FTS4(`text` TEXT NOT NULL, content=`ayah`)");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_BEFORE_UPDATE BEFORE UPDATE ON `ayah` BEGIN DELETE FROM `ayah_fts` WHERE `docid`=OLD.`rowid`; END");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_BEFORE_DELETE BEFORE DELETE ON `ayah` BEGIN DELETE FROM `ayah_fts` WHERE `docid`=OLD.`rowid`; END");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_AFTER_UPDATE AFTER UPDATE ON `ayah` BEGIN INSERT INTO `ayah_fts`(`docid`, `text`) VALUES (NEW.`rowid`, NEW.`text`); END");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_AFTER_INSERT AFTER INSERT ON `ayah` BEGIN INSERT INTO `ayah_fts`(`docid`, `text`) VALUES (NEW.`rowid`, NEW.`text`); END");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '34b8bf2cce55760ea272553deeedabf9')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `surah`");
        db.execSQL("DROP TABLE IF EXISTS `ayah`");
        db.execSQL("DROP TABLE IF EXISTS `translation`");
        db.execSQL("DROP TABLE IF EXISTS `tafsir`");
        db.execSQL("DROP TABLE IF EXISTS `audio_timing`");
        db.execSQL("DROP TABLE IF EXISTS `reciter`");
        db.execSQL("DROP TABLE IF EXISTS `bookmark`");
        db.execSQL("DROP TABLE IF EXISTS `note`");
        db.execSQL("DROP TABLE IF EXISTS `reading_progress`");
        db.execSQL("DROP TABLE IF EXISTS `memorization_progress`");
        db.execSQL("DROP TABLE IF EXISTS `ayah_fts`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_BEFORE_UPDATE BEFORE UPDATE ON `ayah` BEGIN DELETE FROM `ayah_fts` WHERE `docid`=OLD.`rowid`; END");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_BEFORE_DELETE BEFORE DELETE ON `ayah` BEGIN DELETE FROM `ayah_fts` WHERE `docid`=OLD.`rowid`; END");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_AFTER_UPDATE AFTER UPDATE ON `ayah` BEGIN INSERT INTO `ayah_fts`(`docid`, `text`) VALUES (NEW.`rowid`, NEW.`text`); END");
        db.execSQL("CREATE TRIGGER IF NOT EXISTS room_fts_content_sync_ayah_fts_AFTER_INSERT AFTER INSERT ON `ayah` BEGIN INSERT INTO `ayah_fts`(`docid`, `text`) VALUES (NEW.`rowid`, NEW.`text`); END");
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsSurah = new HashMap<String, TableInfo.Column>(5);
        _columnsSurah.put("surahNumber", new TableInfo.Column("surahNumber", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSurah.put("nameArabic", new TableInfo.Column("nameArabic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSurah.put("nameTransliterated", new TableInfo.Column("nameTransliterated", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSurah.put("versesCount", new TableInfo.Column("versesCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSurah.put("revelationPlace", new TableInfo.Column("revelationPlace", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSurah = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSurah = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSurah = new TableInfo("surah", _columnsSurah, _foreignKeysSurah, _indicesSurah);
        final TableInfo _existingSurah = TableInfo.read(db, "surah");
        if (!_infoSurah.equals(_existingSurah)) {
          return new RoomOpenHelper.ValidationResult(false, "surah(com.quranapp.islamic.data.database.entities.SurahEntity).\n"
                  + " Expected:\n" + _infoSurah + "\n"
                  + " Found:\n" + _existingSurah);
        }
        final HashMap<String, TableInfo.Column> _columnsAyah = new HashMap<String, TableInfo.Column>(7);
        _columnsAyah.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAyah.put("surah_number", new TableInfo.Column("surah_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAyah.put("ayah_number", new TableInfo.Column("ayah_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAyah.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAyah.put("text_simple", new TableInfo.Column("text_simple", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAyah.put("juz", new TableInfo.Column("juz", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAyah.put("page", new TableInfo.Column("page", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAyah = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAyah = new HashSet<TableInfo.Index>(1);
        _indicesAyah.add(new TableInfo.Index("index_ayah_surah_number_ayah_number", true, Arrays.asList("surah_number", "ayah_number"), Arrays.asList("ASC", "ASC")));
        final TableInfo _infoAyah = new TableInfo("ayah", _columnsAyah, _foreignKeysAyah, _indicesAyah);
        final TableInfo _existingAyah = TableInfo.read(db, "ayah");
        if (!_infoAyah.equals(_existingAyah)) {
          return new RoomOpenHelper.ValidationResult(false, "ayah(com.quranapp.islamic.data.database.entities.AyahEntity).\n"
                  + " Expected:\n" + _infoAyah + "\n"
                  + " Found:\n" + _existingAyah);
        }
        final HashMap<String, TableInfo.Column> _columnsTranslation = new HashMap<String, TableInfo.Column>(4);
        _columnsTranslation.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranslation.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranslation.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranslation.put("ayah_id", new TableInfo.Column("ayah_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTranslation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTranslation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTranslation = new TableInfo("translation", _columnsTranslation, _foreignKeysTranslation, _indicesTranslation);
        final TableInfo _existingTranslation = TableInfo.read(db, "translation");
        if (!_infoTranslation.equals(_existingTranslation)) {
          return new RoomOpenHelper.ValidationResult(false, "translation(com.quranapp.islamic.data.database.entities.TranslationEntity).\n"
                  + " Expected:\n" + _infoTranslation + "\n"
                  + " Found:\n" + _existingTranslation);
        }
        final HashMap<String, TableInfo.Column> _columnsTafsir = new HashMap<String, TableInfo.Column>(4);
        _columnsTafsir.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTafsir.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTafsir.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTafsir.put("ayah_id", new TableInfo.Column("ayah_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTafsir = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTafsir = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTafsir = new TableInfo("tafsir", _columnsTafsir, _foreignKeysTafsir, _indicesTafsir);
        final TableInfo _existingTafsir = TableInfo.read(db, "tafsir");
        if (!_infoTafsir.equals(_existingTafsir)) {
          return new RoomOpenHelper.ValidationResult(false, "tafsir(com.quranapp.islamic.data.database.entities.TafsirEntity).\n"
                  + " Expected:\n" + _infoTafsir + "\n"
                  + " Found:\n" + _existingTafsir);
        }
        final HashMap<String, TableInfo.Column> _columnsAudioTiming = new HashMap<String, TableInfo.Column>(3);
        _columnsAudioTiming.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioTiming.put("ayah_id", new TableInfo.Column("ayah_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAudioTiming.put("timings", new TableInfo.Column("timings", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAudioTiming = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAudioTiming = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAudioTiming = new TableInfo("audio_timing", _columnsAudioTiming, _foreignKeysAudioTiming, _indicesAudioTiming);
        final TableInfo _existingAudioTiming = TableInfo.read(db, "audio_timing");
        if (!_infoAudioTiming.equals(_existingAudioTiming)) {
          return new RoomOpenHelper.ValidationResult(false, "audio_timing(com.quranapp.islamic.data.database.entities.AudioTimingEntity).\n"
                  + " Expected:\n" + _infoAudioTiming + "\n"
                  + " Found:\n" + _existingAudioTiming);
        }
        final HashMap<String, TableInfo.Column> _columnsReciter = new HashMap<String, TableInfo.Column>(4);
        _columnsReciter.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReciter.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReciter.put("style", new TableInfo.Column("style", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReciter.put("audio_url", new TableInfo.Column("audio_url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReciter = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReciter = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReciter = new TableInfo("reciter", _columnsReciter, _foreignKeysReciter, _indicesReciter);
        final TableInfo _existingReciter = TableInfo.read(db, "reciter");
        if (!_infoReciter.equals(_existingReciter)) {
          return new RoomOpenHelper.ValidationResult(false, "reciter(com.quranapp.islamic.data.database.entities.ReciterEntity).\n"
                  + " Expected:\n" + _infoReciter + "\n"
                  + " Found:\n" + _existingReciter);
        }
        final HashMap<String, TableInfo.Column> _columnsBookmark = new HashMap<String, TableInfo.Column>(3);
        _columnsBookmark.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmark.put("ayah_id", new TableInfo.Column("ayah_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmark.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookmark = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookmark = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookmark = new TableInfo("bookmark", _columnsBookmark, _foreignKeysBookmark, _indicesBookmark);
        final TableInfo _existingBookmark = TableInfo.read(db, "bookmark");
        if (!_infoBookmark.equals(_existingBookmark)) {
          return new RoomOpenHelper.ValidationResult(false, "bookmark(com.quranapp.islamic.data.database.entities.BookmarkEntity).\n"
                  + " Expected:\n" + _infoBookmark + "\n"
                  + " Found:\n" + _existingBookmark);
        }
        final HashMap<String, TableInfo.Column> _columnsNote = new HashMap<String, TableInfo.Column>(4);
        _columnsNote.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("ayah_id", new TableInfo.Column("ayah_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNote.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNote = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNote = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNote = new TableInfo("note", _columnsNote, _foreignKeysNote, _indicesNote);
        final TableInfo _existingNote = TableInfo.read(db, "note");
        if (!_infoNote.equals(_existingNote)) {
          return new RoomOpenHelper.ValidationResult(false, "note(com.quranapp.islamic.data.database.entities.NoteEntity).\n"
                  + " Expected:\n" + _infoNote + "\n"
                  + " Found:\n" + _existingNote);
        }
        final HashMap<String, TableInfo.Column> _columnsReadingProgress = new HashMap<String, TableInfo.Column>(4);
        _columnsReadingProgress.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReadingProgress.put("last_read_surah", new TableInfo.Column("last_read_surah", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReadingProgress.put("last_read_ayah", new TableInfo.Column("last_read_ayah", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReadingProgress.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReadingProgress = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReadingProgress = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReadingProgress = new TableInfo("reading_progress", _columnsReadingProgress, _foreignKeysReadingProgress, _indicesReadingProgress);
        final TableInfo _existingReadingProgress = TableInfo.read(db, "reading_progress");
        if (!_infoReadingProgress.equals(_existingReadingProgress)) {
          return new RoomOpenHelper.ValidationResult(false, "reading_progress(com.quranapp.islamic.data.database.entities.ReadingProgressEntity).\n"
                  + " Expected:\n" + _infoReadingProgress + "\n"
                  + " Found:\n" + _existingReadingProgress);
        }
        final HashMap<String, TableInfo.Column> _columnsMemorizationProgress = new HashMap<String, TableInfo.Column>(4);
        _columnsMemorizationProgress.put("ayah_id", new TableInfo.Column("ayah_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemorizationProgress.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemorizationProgress.put("next_review_date", new TableInfo.Column("next_review_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMemorizationProgress.put("interval", new TableInfo.Column("interval", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMemorizationProgress = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMemorizationProgress = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMemorizationProgress = new TableInfo("memorization_progress", _columnsMemorizationProgress, _foreignKeysMemorizationProgress, _indicesMemorizationProgress);
        final TableInfo _existingMemorizationProgress = TableInfo.read(db, "memorization_progress");
        if (!_infoMemorizationProgress.equals(_existingMemorizationProgress)) {
          return new RoomOpenHelper.ValidationResult(false, "memorization_progress(com.quranapp.islamic.data.database.entities.MemorizationProgressEntity).\n"
                  + " Expected:\n" + _infoMemorizationProgress + "\n"
                  + " Found:\n" + _existingMemorizationProgress);
        }
        final HashSet<String> _columnsAyahFts = new HashSet<String>(1);
        _columnsAyahFts.add("text");
        final FtsTableInfo _infoAyahFts = new FtsTableInfo("ayah_fts", _columnsAyahFts, "CREATE VIRTUAL TABLE IF NOT EXISTS `ayah_fts` USING FTS4(`text` TEXT NOT NULL, content=`ayah`)");
        final FtsTableInfo _existingAyahFts = FtsTableInfo.read(db, "ayah_fts");
        if (!_infoAyahFts.equals(_existingAyahFts)) {
          return new RoomOpenHelper.ValidationResult(false, "ayah_fts(com.quranapp.islamic.data.database.entities.AyahFtsEntity).\n"
                  + " Expected:\n" + _infoAyahFts + "\n"
                  + " Found:\n" + _existingAyahFts);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "34b8bf2cce55760ea272553deeedabf9", "f0034189b2fb5b2d95a47638bb1e60b6");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(1);
    _shadowTablesMap.put("ayah_fts", "ayah");
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "surah","ayah","translation","tafsir","audio_timing","reciter","bookmark","note","reading_progress","memorization_progress","ayah_fts");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `surah`");
      _db.execSQL("DELETE FROM `ayah`");
      _db.execSQL("DELETE FROM `translation`");
      _db.execSQL("DELETE FROM `tafsir`");
      _db.execSQL("DELETE FROM `audio_timing`");
      _db.execSQL("DELETE FROM `reciter`");
      _db.execSQL("DELETE FROM `bookmark`");
      _db.execSQL("DELETE FROM `note`");
      _db.execSQL("DELETE FROM `reading_progress`");
      _db.execSQL("DELETE FROM `memorization_progress`");
      _db.execSQL("DELETE FROM `ayah_fts`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SurahDao.class, SurahDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AyahDao.class, AyahDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SearchDao.class, SearchDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TranslationDao.class, TranslationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TafsirDao.class, TafsirDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BookmarkDao.class, BookmarkDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NoteDao.class, NoteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ReadingProgressDao.class, ReadingProgressDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MemorizationProgressDao.class, MemorizationProgressDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ReciterDao.class, ReciterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AudioTimingDao.class, AudioTimingDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public SurahDao surahDao() {
    if (_surahDao != null) {
      return _surahDao;
    } else {
      synchronized(this) {
        if(_surahDao == null) {
          _surahDao = new SurahDao_Impl(this);
        }
        return _surahDao;
      }
    }
  }

  @Override
  public AyahDao ayahDao() {
    if (_ayahDao != null) {
      return _ayahDao;
    } else {
      synchronized(this) {
        if(_ayahDao == null) {
          _ayahDao = new AyahDao_Impl(this);
        }
        return _ayahDao;
      }
    }
  }

  @Override
  public SearchDao searchDao() {
    if (_searchDao != null) {
      return _searchDao;
    } else {
      synchronized(this) {
        if(_searchDao == null) {
          _searchDao = new SearchDao_Impl(this);
        }
        return _searchDao;
      }
    }
  }

  @Override
  public TranslationDao translationDao() {
    if (_translationDao != null) {
      return _translationDao;
    } else {
      synchronized(this) {
        if(_translationDao == null) {
          _translationDao = new TranslationDao_Impl(this);
        }
        return _translationDao;
      }
    }
  }

  @Override
  public TafsirDao tafsirDao() {
    if (_tafsirDao != null) {
      return _tafsirDao;
    } else {
      synchronized(this) {
        if(_tafsirDao == null) {
          _tafsirDao = new TafsirDao_Impl(this);
        }
        return _tafsirDao;
      }
    }
  }

  @Override
  public BookmarkDao bookmarkDao() {
    if (_bookmarkDao != null) {
      return _bookmarkDao;
    } else {
      synchronized(this) {
        if(_bookmarkDao == null) {
          _bookmarkDao = new BookmarkDao_Impl(this);
        }
        return _bookmarkDao;
      }
    }
  }

  @Override
  public NoteDao noteDao() {
    if (_noteDao != null) {
      return _noteDao;
    } else {
      synchronized(this) {
        if(_noteDao == null) {
          _noteDao = new NoteDao_Impl(this);
        }
        return _noteDao;
      }
    }
  }

  @Override
  public ReadingProgressDao readingProgressDao() {
    if (_readingProgressDao != null) {
      return _readingProgressDao;
    } else {
      synchronized(this) {
        if(_readingProgressDao == null) {
          _readingProgressDao = new ReadingProgressDao_Impl(this);
        }
        return _readingProgressDao;
      }
    }
  }

  @Override
  public MemorizationProgressDao memorizationProgressDao() {
    if (_memorizationProgressDao != null) {
      return _memorizationProgressDao;
    } else {
      synchronized(this) {
        if(_memorizationProgressDao == null) {
          _memorizationProgressDao = new MemorizationProgressDao_Impl(this);
        }
        return _memorizationProgressDao;
      }
    }
  }

  @Override
  public ReciterDao reciterDao() {
    if (_reciterDao != null) {
      return _reciterDao;
    } else {
      synchronized(this) {
        if(_reciterDao == null) {
          _reciterDao = new ReciterDao_Impl(this);
        }
        return _reciterDao;
      }
    }
  }

  @Override
  public AudioTimingDao audioTimingDao() {
    if (_audioTimingDao != null) {
      return _audioTimingDao;
    } else {
      synchronized(this) {
        if(_audioTimingDao == null) {
          _audioTimingDao = new AudioTimingDao_Impl(this);
        }
        return _audioTimingDao;
      }
    }
  }
}
