package com.quranapp.islamic.data.database.dao

import androidx.room.*
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import com.quranapp.islamic.data.database.entities.*

/**
 * واجهة البيانات للسور
 */
@Dao
interface SurahDao {
    
    @Query("SELECT * FROM surah ORDER BY surahNumber ASC")
    fun getAllSurahs(): Flow<List<SurahEntity>>
    
    @Query("SELECT * FROM surah WHERE surahNumber = :surahNumber")
    suspend fun getSurahByNumber(surahNumber: Int): SurahEntity?
    
    @Query("SELECT * FROM surah WHERE surahNumber = :surahNumber")
    fun getSurahByNumberFlow(surahNumber: Int): Flow<SurahEntity?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurah(surah: SurahEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurahs(surahs: List<SurahEntity>)
    
    @Delete
    suspend fun deleteSurah(surah: SurahEntity)
    
    @Query("DELETE FROM surah")
    suspend fun deleteAllSurahs()
}

/**
 * واجهة البيانات للآيات
 */
@Dao
interface AyahDao {
    
    @Query("SELECT * FROM ayah WHERE surah_number = :surahNumber ORDER BY ayah_number ASC")
    fun getAyahsBySurah(surahNumber: Int): Flow<List<AyahEntity>>
    
    @Query("SELECT * FROM ayah WHERE surah_number = :surahNumber ORDER BY ayah_number ASC")
    fun getAyahsBySurahPaging(surahNumber: Int): PagingSource<Int, AyahEntity>
    
    @Query("SELECT * FROM ayah WHERE id = :ayahId")
    suspend fun getAyahById(ayahId: Int): AyahEntity?
    
    @Query("SELECT * FROM ayah WHERE id = :ayahId")
    fun getAyahByIdFlow(ayahId: Int): Flow<AyahEntity?>
    
    @Query("SELECT * FROM ayah WHERE page_number = :pageNumber ORDER BY surah_number ASC, ayah_number ASC")
    fun getAyahsByPage(pageNumber: Int): Flow<List<AyahEntity>>
    
    @Query("SELECT * FROM ayah WHERE juz_number = :juzNumber ORDER BY surah_number ASC, ayah_number ASC")
    fun getAyahsByJuz(juzNumber: Int): Flow<List<AyahEntity>>
    
    @Query("SELECT * FROM ayah WHERE hizb_number = :hizbNumber ORDER BY surah_number ASC, ayah_number ASC")
    fun getAyahsByHizb(hizbNumber: Int): Flow<List<AyahEntity>>
    
    @Query("SELECT * FROM ayah WHERE sajdah = 1 ORDER BY surah_number ASC, ayah_number ASC")
    fun getSajdahAyahs(): Flow<List<AyahEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyah(ayah: AyahEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyahs(ayahs: List<AyahEntity>)
    
    @Delete
    suspend fun deleteAyah(ayah: AyahEntity)
    
    @Query("DELETE FROM ayah WHERE surah_number = :surahNumber")
    suspend fun deleteAyahsBySurah(surahNumber: Int)
    
    @Query("DELETE FROM ayah")
    suspend fun deleteAllAyahs()
    
    // إحصائيات
    @Query("SELECT COUNT(*) FROM ayah")
    suspend fun getTotalAyahCount(): Int
    
    @Query("SELECT COUNT(*) FROM ayah WHERE surah_number = :surahNumber")
    suspend fun getAyahCountBySurah(surahNumber: Int): Int
}

/**
 * واجهة البيانات للبحث بالنص الكامل
 */
@Dao
interface SearchDao {
    
    @Query("""
        SELECT ayah.* FROM ayah 
        JOIN ayah_fts ON ayah.id = ayah_fts.docid 
        WHERE ayah_fts MATCH :searchQuery 
        ORDER BY bm25(ayah_fts) ASC
        LIMIT :limit
    """)
    suspend fun searchAyahs(searchQuery: String, limit: Int = 50): List<AyahEntity>
    
    @Query("""
        SELECT ayah.* FROM ayah 
        WHERE ayah.text_simple LIKE '%' || :query || '%' 
        OR ayah.text_uthmani LIKE '%' || :query || '%'
        ORDER BY ayah.surah_number ASC, ayah.ayah_number ASC
        LIMIT :limit
    """)
    suspend fun searchAyahsSimple(query: String, limit: Int = 50): List<AyahEntity>
    
    @Query("""
        SELECT ayah.* FROM ayah 
        INNER JOIN translation t ON ayah.id = t.ayah_id 
        WHERE t.text LIKE '%' || :query || '%' 
        AND t.language_code = :languageCode
        ORDER BY ayah.surah_number ASC, ayah.ayah_number ASC
        LIMIT :limit
    """)
    suspend fun searchInTranslation(
        query: String, 
        languageCode: String, 
        limit: Int = 50
    ): List<AyahEntity>
    
    @Query("""
        SELECT ayah.* FROM ayah 
        INNER JOIN tafsir t ON ayah.id = t.ayah_id 
        WHERE t.text LIKE '%' || :query || '%' 
        AND t.language_code = :languageCode
        ORDER BY ayah.surah_number ASC, ayah.ayah_number ASC
        LIMIT :limit
    """)
    suspend fun searchInTafsir(
        query: String, 
        languageCode: String, 
        limit: Int = 50
    ): List<AyahEntity>
}

/**
 * واجهة البيانات للترجمات
 */
@Dao
interface TranslationDao {
    
    @Query("SELECT * FROM translation WHERE ayah_id = :ayahId")
    fun getTranslationsByAyah(ayahId: Int): Flow<List<TranslationEntity>>
    
    @Query("SELECT * FROM translation WHERE ayah_id = :ayahId AND language_code = :languageCode")
    fun getTranslationByAyahAndLanguage(ayahId: Int, languageCode: String): Flow<List<TranslationEntity>>
    
    @Query("SELECT DISTINCT author_name FROM translation WHERE language_code = :languageCode")
    suspend fun getTranslationAuthors(languageCode: String): List<String>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTranslation(translation: TranslationEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTranslations(translations: List<TranslationEntity>)
    
    @Delete
    suspend fun deleteTranslation(translation: TranslationEntity)
    
    @Query("DELETE FROM translation WHERE language_code = :languageCode")
    suspend fun deleteTranslationsByLanguage(languageCode: String)
}

/**
 * واجهة البيانات للتفسير
 */
@Dao
interface TafsirDao {
    
    @Query("SELECT * FROM tafsir WHERE ayah_id = :ayahId")
    fun getTafsirByAyah(ayahId: Int): Flow<List<TafsirEntity>>
    
    @Query("SELECT * FROM tafsir WHERE ayah_id = :ayahId AND author_id = :authorId")
    fun getTafsirByAyahAndAuthor(ayahId: Int, authorId: Int): Flow<TafsirEntity?>
    
    @Query("SELECT DISTINCT author_name FROM tafsir WHERE language_code = :languageCode")
    suspend fun getTafsirAuthors(languageCode: String): List<String>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTafsir(tafsir: TafsirEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTafsirs(tafsirs: List<TafsirEntity>)
    
    @Delete
    suspend fun deleteTafsir(tafsir: TafsirEntity)
}

/**
 * واجهة البيانات للإشارات المرجعية
 */
@Dao
interface BookmarkDao {
    
    @Query("""
        SELECT b.*, a.text_uthmani, s.name_arabic as surah_name 
        FROM bookmark b 
        INNER JOIN ayah a ON b.ayah_id = a.id 
        INNER JOIN surah s ON a.surah_number = s.surahNumber 
        ORDER BY b.created_at DESC
    """)
    fun getAllBookmarks(): Flow<List<BookmarkWithAyah>>
    
    @Query("SELECT * FROM bookmark WHERE ayah_id = :ayahId")
    suspend fun getBookmarkByAyah(ayahId: Int): BookmarkEntity?
    
    @Query("SELECT EXISTS(SELECT 1 FROM bookmark WHERE ayah_id = :ayahId)")
    suspend fun isAyahBookmarked(ayahId: Int): Boolean
    
    @Query("SELECT EXISTS(SELECT 1 FROM bookmark WHERE ayah_id = :ayahId)")
    fun isAyahBookmarkedFlow(ayahId: Int): Flow<Boolean>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)
    
    @Delete
    suspend fun deleteBookmark(bookmark: BookmarkEntity)
    
    @Query("DELETE FROM bookmark WHERE ayah_id = :ayahId")
    suspend fun deleteBookmarkByAyah(ayahId: Int)
    
    @Query("SELECT COUNT(*) FROM bookmark")
    suspend fun getBookmarkCount(): Int
}

/**
 * واجهة البيانات للملاحظات
 */
@Dao
interface NoteDao {
    
    @Query("""
        SELECT n.*, a.text_uthmani, s.name_arabic as surah_name 
        FROM note n 
        INNER JOIN ayah a ON n.ayah_id = a.id 
        INNER JOIN surah s ON a.surah_number = s.surahNumber 
        ORDER BY n.updated_at DESC
    """)
    fun getAllNotes(): Flow<List<NoteWithAyah>>
    
    @Query("SELECT * FROM note WHERE ayah_id = :ayahId ORDER BY created_at DESC")
    fun getNotesByAyah(ayahId: Int): Flow<List<NoteEntity>>
    
    @Query("SELECT * FROM note WHERE id = :noteId")
    suspend fun getNoteById(noteId: Long): NoteEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)
    
    @Update
    suspend fun updateNote(note: NoteEntity)
    
    @Delete
    suspend fun deleteNote(note: NoteEntity)
    
    @Query("DELETE FROM note WHERE ayah_id = :ayahId")
    suspend fun deleteNotesByAyah(ayahId: Int)
    
    @Query("SELECT COUNT(*) FROM note")
    suspend fun getNoteCount(): Int
}

/**
 * واجهة البيانات لتقدم القراءة
 */
@Dao
interface ReadingProgressDao {
    
    @Query("SELECT * FROM reading_progress ORDER BY last_read_at DESC")
    fun getAllReadingProgress(): Flow<List<ReadingProgressEntity>>
    
    @Query("SELECT * FROM reading_progress WHERE surah_number = :surahNumber ORDER BY last_read_at DESC LIMIT 1")
    suspend fun getLatestProgressBySurah(surahNumber: Int): ReadingProgressEntity?
    
    @Query("SELECT * FROM reading_progress WHERE ayah_id = :ayahId")
    suspend fun getProgressByAyah(ayahId: Int): ReadingProgressEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgress(progress: ReadingProgressEntity)
    
    @Update
    suspend fun updateProgress(progress: ReadingProgressEntity)
    
    @Query("DELETE FROM reading_progress WHERE surah_number = :surahNumber")
    suspend fun deleteProgressBySurah(surahNumber: Int)
    
    // إحصائيات القراءة
    @Query("SELECT SUM(reading_time_seconds) FROM reading_progress")
    suspend fun getTotalReadingTime(): Long?
    
    @Query("SELECT COUNT(DISTINCT surah_number) FROM reading_progress")
    suspend fun getReadSurahCount(): Int
}

/**
 * واجهة البيانات لتقدم الحفظ
 */
@Dao
interface MemorizationProgressDao {
    
    @Query("SELECT * FROM memorization_progress ORDER BY next_review_at ASC")
    fun getAllMemorizationProgress(): Flow<List<MemorizationProgressEntity>>
    
    @Query("SELECT * FROM memorization_progress WHERE next_review_at <= :currentTime ORDER BY next_review_at ASC")
    suspend fun getAyahsDueForReview(currentTime: Long = System.currentTimeMillis()): List<MemorizationProgressEntity>
    
    @Query("SELECT * FROM memorization_progress WHERE ayah_id = :ayahId")
    suspend fun getMemorizationProgressByAyah(ayahId: Int): MemorizationProgressEntity?
    
    @Query("SELECT * FROM memorization_progress WHERE memorization_level = :level")
    fun getProgressByLevel(level: Int): Flow<List<MemorizationProgressEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemorizationProgress(progress: MemorizationProgressEntity)
    
    @Update
    suspend fun updateMemorizationProgress(progress: MemorizationProgressEntity)
    
    @Delete
    suspend fun deleteMemorizationProgress(progress: MemorizationProgressEntity)
    
    // إحصائيات الحفظ
    @Query("SELECT COUNT(*) FROM memorization_progress WHERE memorization_level >= :minLevel")
    suspend fun getMemorizedAyahCount(minLevel: Int = 3): Int
    
    @Query("SELECT AVG(memorization_level) FROM memorization_progress")
    suspend fun getAverageMemorizationLevel(): Float?
}

/**
 * واجهة البيانات للقراء
 */
@Dao
interface ReciterDao {
    
    @Query("SELECT * FROM reciter ORDER BY name ASC")
    fun getAllReciters(): Flow<List<ReciterEntity>>
    
    @Query("SELECT * FROM reciter WHERE id = :reciterId")
    suspend fun getReciterById(reciterId: Int): ReciterEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReciter(reciter: ReciterEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReciters(reciters: List<ReciterEntity>)
    
    @Delete
    suspend fun deleteReciter(reciter: ReciterEntity)
}

/**
 * واجهة البيانات لتوقيت الصوت
 */
@Dao
interface AudioTimingDao {
    
    @Query("SELECT * FROM audio_timing WHERE ayah_id = :ayahId AND reciter_id = :reciterId")
    suspend fun getAudioTiming(ayahId: Int, reciterId: Int): AudioTimingEntity?
    
    @Query("SELECT * FROM audio_timing WHERE reciter_id = :reciterId ORDER BY ayah_id ASC")
    fun getAudioTimingsByReciter(reciterId: Int): Flow<List<AudioTimingEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAudioTiming(timing: AudioTimingEntity)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAudioTimings(timings: List<AudioTimingEntity>)
    
    @Delete
    suspend fun deleteAudioTiming(timing: AudioTimingEntity)
    
    @Query("DELETE FROM audio_timing WHERE reciter_id = :reciterId")
    suspend fun deleteTimingsByReciter(reciterId: Int)
}

// Data classes للعلاقات المعقدة
data class BookmarkWithAyah(
    @Embedded val bookmark: BookmarkEntity,
    @ColumnInfo(name = "text_uthmani") val ayahText: String,
    @ColumnInfo(name = "surah_name") val surahName: String
)

data class NoteWithAyah(
    @Embedded val note: NoteEntity,
    @ColumnInfo(name = "text_uthmani") val ayahText: String,
    @ColumnInfo(name = "surah_name") val surahName: String
)

data class AyahWithDetails(
    @Embedded val ayah: AyahEntity,
    @Relation(
        parentColumn = "surahNumber",
        entityColumn = "surahNumber"
    )
    val surah: SurahEntity,
    
    @Relation(
        parentColumn = "id",
        entityColumn = "ayah_id"
    )
    val translations: List<TranslationEntity>,
    
    @Relation(
        parentColumn = "id",
        entityColumn = "ayah_id"
    )
    val tafsirs: List<TafsirEntity>
)
