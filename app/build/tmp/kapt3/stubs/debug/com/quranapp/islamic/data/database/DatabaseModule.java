package com.quranapp.islamic.data.database;

import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.quranapp.islamic.data.database.dao.*;
import com.quranapp.islamic.data.database.entities.*;

/**
 * مزود قاعدة البيانات باستخدام Hilt
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u001e"}, d2 = {"Lcom/quranapp/islamic/data/database/DatabaseModule;", "", "()V", "provideAudioTimingDao", "Lcom/quranapp/islamic/data/database/dao/AudioTimingDao;", "database", "Lcom/quranapp/islamic/data/database/QuranDatabase;", "provideAyahDao", "Lcom/quranapp/islamic/data/database/dao/AyahDao;", "provideBookmarkDao", "Lcom/quranapp/islamic/data/database/dao/BookmarkDao;", "provideMemorizationProgressDao", "Lcom/quranapp/islamic/data/database/dao/MemorizationProgressDao;", "provideNoteDao", "Lcom/quranapp/islamic/data/database/dao/NoteDao;", "provideQuranDatabase", "context", "Landroid/content/Context;", "provideReadingProgressDao", "Lcom/quranapp/islamic/data/database/dao/ReadingProgressDao;", "provideReciterDao", "Lcom/quranapp/islamic/data/database/dao/ReciterDao;", "provideSearchDao", "Lcom/quranapp/islamic/data/database/dao/SearchDao;", "provideSurahDao", "Lcom/quranapp/islamic/data/database/dao/SurahDao;", "provideTafsirDao", "Lcom/quranapp/islamic/data/database/dao/TafsirDao;", "provideTranslationDao", "Lcom/quranapp/islamic/data/database/dao/TranslationDao;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.quranapp.islamic.data.database.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.QuranDatabase provideQuranDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.SurahDao provideSurahDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.AyahDao provideAyahDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.SearchDao provideSearchDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.TranslationDao provideTranslationDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.TafsirDao provideTafsirDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.BookmarkDao provideBookmarkDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.NoteDao provideNoteDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.ReadingProgressDao provideReadingProgressDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.MemorizationProgressDao provideMemorizationProgressDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.ReciterDao provideReciterDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.quranapp.islamic.data.database.dao.AudioTimingDao provideAudioTimingDao(@org.jetbrains.annotations.NotNull()
    com.quranapp.islamic.data.database.QuranDatabase database) {
        return null;
    }
}