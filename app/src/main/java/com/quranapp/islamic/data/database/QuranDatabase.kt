package com.quranapp.islamic.data.database

import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.quranapp.islamic.data.database.dao.*
import com.quranapp.islamic.data.database.entities.*

/**
 * قاعدة البيانات الرئيسية للتطبيق
 */
@Database(
    entities = [
        SurahEntity::class,
        AyahEntity::class,
        TranslationEntity::class,
        TafsirEntity::class,
        AudioTimingEntity::class,
        ReciterEntity::class,
        BookmarkEntity::class,
        NoteEntity::class,
        ReadingProgressEntity::class,
        MemorizationProgressEntity::class,
        AyahFtsEntity::class
    ],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
@TypeConverters(Converters::class)
abstract class QuranDatabase : RoomDatabase() {
    
    // DAO interfaces
    abstract fun surahDao(): SurahDao
    abstract fun ayahDao(): AyahDao
    abstract fun searchDao(): SearchDao
    abstract fun translationDao(): TranslationDao
    abstract fun tafsirDao(): TafsirDao
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun noteDao(): NoteDao
    abstract fun readingProgressDao(): ReadingProgressDao
    abstract fun memorizationProgressDao(): MemorizationProgressDao
    abstract fun reciterDao(): ReciterDao
    abstract fun audioTimingDao(): AudioTimingDao
    
    companion object {
        const val DATABASE_NAME = "quran_database"
        
        // Migration من الإصدار 1 إلى 2 (للاستخدام المستقبلي)
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // إضافة جداول أو تعديلات مستقبلية
            }
        }
        
        /**
         * Callback لتنفيذ عمليات أثناء إنشاء قاعدة البيانات
         */
        val DATABASE_CALLBACK = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                
                // إنشاء فهارس إضافية لتحسين الأداء
                db.execSQL("""
                    CREATE INDEX IF NOT EXISTS idx_ayah_text_search 
                    ON ayah(text_simple COLLATE NOCASE)
                """)
                
                db.execSQL("""
                    CREATE INDEX IF NOT EXISTS idx_ayah_composite 
                    ON ayah(surah_number, ayah_number)
                """)
                
                // إعداد FTS للبحث السريع
                db.execSQL("""
                    INSERT INTO ayah_fts(ayah_fts) VALUES('rebuild')
                """)
            }
            
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                
                // تفعيل WAL mode لتحسين الأداء
                db.execSQL("PRAGMA journal_mode=WAL")
                
                // تفعيل تحسين الاستعلامات
                db.execSQL("PRAGMA synchronous=NORMAL")
                db.execSQL("PRAGMA cache_size=10000")
                db.execSQL("PRAGMA temp_store=MEMORY")
                
                // تفعيل المفاتيح الخارجية
                db.execSQL("PRAGMA foreign_keys=ON")
            }
        }
    }
}

/**
 * محولات الأنواع لـ Room Database
 */
class Converters {
    
    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.joinToString(",")
    }
    
    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return value?.split(",")?.map { it.trim() }
    }
    
    @TypeConverter
    fun fromLongList(value: List<Long>?): String? {
        return value?.joinToString(",")
    }
    
    @TypeConverter
    fun toLongList(value: String?): List<Long>? {
        return value?.split(",")?.mapNotNull { 
            try { it.trim().toLong() } catch (e: NumberFormatException) { null }
        }
    }
}

/**
 * مزود قاعدة البيانات باستخدام Hilt
 */
@dagger.Module
@dagger.hilt.InstallIn(dagger.hilt.components.SingletonComponent::class)
object DatabaseModule {
    
    @dagger.Provides
    @javax.inject.Singleton
    fun provideQuranDatabase(
        @dagger.hilt.android.qualifiers.ApplicationContext context: android.content.Context
    ): QuranDatabase {
        return androidx.room.Room.databaseBuilder(
            context,
            QuranDatabase::class.java,
            QuranDatabase.DATABASE_NAME
        )
        .addCallback(QuranDatabase.DATABASE_CALLBACK)
        .addMigrations(QuranDatabase.MIGRATION_1_2)
        .fallbackToDestructiveMigration() // للتطوير فقط
        .build()
    }
    
    // توفير جميع DAO interfaces
    @dagger.Provides
    fun provideSurahDao(database: QuranDatabase): SurahDao = database.surahDao()
    
    @dagger.Provides
    fun provideAyahDao(database: QuranDatabase): AyahDao = database.ayahDao()
    
    @dagger.Provides
    fun provideSearchDao(database: QuranDatabase): SearchDao = database.searchDao()
    
    @dagger.Provides
    fun provideTranslationDao(database: QuranDatabase): TranslationDao = database.translationDao()
    
    @dagger.Provides
    fun provideTafsirDao(database: QuranDatabase): TafsirDao = database.tafsirDao()
    
    @dagger.Provides
    fun provideBookmarkDao(database: QuranDatabase): BookmarkDao = database.bookmarkDao()
    
    @dagger.Provides
    fun provideNoteDao(database: QuranDatabase): NoteDao = database.noteDao()
    
    @dagger.Provides
    fun provideReadingProgressDao(database: QuranDatabase): ReadingProgressDao = database.readingProgressDao()
    
    @dagger.Provides
    fun provideMemorizationProgressDao(database: QuranDatabase): MemorizationProgressDao = database.memorizationProgressDao()
    
    @dagger.Provides
    fun provideReciterDao(database: QuranDatabase): ReciterDao = database.reciterDao()
    
    @dagger.Provides
    fun provideAudioTimingDao(database: QuranDatabase): AudioTimingDao = database.audioTimingDao()
}

/**
 * مساعدة قاعدة البيانات للعمليات المعقدة
 */
@javax.inject.Singleton
class DatabaseHelper @javax.inject.Inject constructor(
    private val database: QuranDatabase
) {
    
    /**
     * تهيئة قاعدة البيانات بالبيانات الأساسية
     */
    suspend fun initializeDatabase() {
        database.runInTransaction {
            // يمكن تنفيذ عمليات التهيئة هنا
            // مثل تحميل بيانات السور والآيات من الموارد
        }
    }
    
    /**
     * تنظيف البيانات المؤقتة
     */
    suspend fun cleanupTempData() {
        database.runInTransaction {
            // حذف البيانات المؤقتة القديمة
            // مثل تقدم القراءة القديم أو الملفات المؤقتة
        }
    }
    
    /**
     * إعادة بناء فهارس البحث
     */
    suspend fun rebuildSearchIndex() {
        database.runInTransaction {
            database.openHelper.writableDatabase.execSQL(
                "INSERT INTO ayah_fts(ayah_fts) VALUES('rebuild')"
            )
        }
    }
    
    /**
     * إحصائيات قاعدة البيانات
     */
    suspend fun getDatabaseStats(): DatabaseStats {
        return database.runInTransaction {
            val surahCount = database.surahDao().getAllSurahs()
            val ayahCount = database.ayahDao().getTotalAyahCount()
            val bookmarkCount = database.bookmarkDao().getBookmarkCount()
            val noteCount = database.noteDao().getNoteCount()
            
            DatabaseStats(
                surahCount = 114, // ثابت
                ayahCount = ayahCount,
                bookmarkCount = bookmarkCount,
                noteCount = noteCount
            )
        }
    }
    
    /**
     * نسخ احتياطي من البيانات المهمة
     */
    suspend fun backupUserData(): UserDataBackup {
        return database.runInTransaction {
            val bookmarks = database.bookmarkDao().getAllBookmarks()
            val notes = database.noteDao().getAllNotes()
            val readingProgress = database.readingProgressDao().getAllReadingProgress()
            val memorizationProgress = database.memorizationProgressDao().getAllMemorizationProgress()
            
            UserDataBackup(
                // سيتم تنفيذها لاحقاً
                timestamp = System.currentTimeMillis(),
                version = 1
            )
        }
    }
}

/**
 * بيانات إحصائيات قاعدة البيانات
 */
data class DatabaseStats(
    val surahCount: Int,
    val ayahCount: Int,
    val bookmarkCount: Int,
    val noteCount: Int
)

/**
 * بيانات النسخ الاحتياطي للمستخدم
 */
data class UserDataBackup(
    val timestamp: Long,
    val version: Int
)
