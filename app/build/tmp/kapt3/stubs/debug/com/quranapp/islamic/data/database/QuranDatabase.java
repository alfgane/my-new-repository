package com.quranapp.islamic.data.database;

import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.quranapp.islamic.data.database.dao.*;
import com.quranapp.islamic.data.database.entities.*;

/**
 * قاعدة البيانات الرئيسية للتطبيق
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&\u00a8\u0006\u001a"}, d2 = {"Lcom/quranapp/islamic/data/database/QuranDatabase;", "Landroidx/room/RoomDatabase;", "()V", "audioTimingDao", "Lcom/quranapp/islamic/data/database/dao/AudioTimingDao;", "ayahDao", "Lcom/quranapp/islamic/data/database/dao/AyahDao;", "bookmarkDao", "Lcom/quranapp/islamic/data/database/dao/BookmarkDao;", "memorizationProgressDao", "Lcom/quranapp/islamic/data/database/dao/MemorizationProgressDao;", "noteDao", "Lcom/quranapp/islamic/data/database/dao/NoteDao;", "readingProgressDao", "Lcom/quranapp/islamic/data/database/dao/ReadingProgressDao;", "reciterDao", "Lcom/quranapp/islamic/data/database/dao/ReciterDao;", "searchDao", "Lcom/quranapp/islamic/data/database/dao/SearchDao;", "surahDao", "Lcom/quranapp/islamic/data/database/dao/SurahDao;", "tafsirDao", "Lcom/quranapp/islamic/data/database/dao/TafsirDao;", "translationDao", "Lcom/quranapp/islamic/data/database/dao/TranslationDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.quranapp.islamic.data.database.entities.SurahEntity.class, com.quranapp.islamic.data.database.entities.AyahEntity.class, com.quranapp.islamic.data.database.entities.TranslationEntity.class, com.quranapp.islamic.data.database.entities.TafsirEntity.class, com.quranapp.islamic.data.database.entities.AudioTimingEntity.class, com.quranapp.islamic.data.database.entities.ReciterEntity.class, com.quranapp.islamic.data.database.entities.BookmarkEntity.class, com.quranapp.islamic.data.database.entities.NoteEntity.class, com.quranapp.islamic.data.database.entities.ReadingProgressEntity.class, com.quranapp.islamic.data.database.entities.MemorizationProgressEntity.class, com.quranapp.islamic.data.database.entities.AyahFtsEntity.class}, version = 1, exportSchema = true, autoMigrations = {})
@androidx.room.TypeConverters(value = {com.quranapp.islamic.data.database.Converters.class})
public abstract class QuranDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "quran_database";
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    
    /**
     * Callback لتنفيذ عمليات أثناء إنشاء قاعدة البيانات
     */
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.RoomDatabase.Callback DATABASE_CALLBACK = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.quranapp.islamic.data.database.QuranDatabase.Companion Companion = null;
    
    public QuranDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.SurahDao surahDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.AyahDao ayahDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.SearchDao searchDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.TranslationDao translationDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.TafsirDao tafsirDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.BookmarkDao bookmarkDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.NoteDao noteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.ReadingProgressDao readingProgressDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.MemorizationProgressDao memorizationProgressDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.ReciterDao reciterDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.quranapp.islamic.data.database.dao.AudioTimingDao audioTimingDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/quranapp/islamic/data/database/QuranDatabase$Companion;", "", "()V", "DATABASE_CALLBACK", "Landroidx/room/RoomDatabase$Callback;", "getDATABASE_CALLBACK", "()Landroidx/room/RoomDatabase$Callback;", "DATABASE_NAME", "", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_1_2() {
            return null;
        }
        
        /**
         * Callback لتنفيذ عمليات أثناء إنشاء قاعدة البيانات
         */
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.RoomDatabase.Callback getDATABASE_CALLBACK() {
            return null;
        }
    }
}