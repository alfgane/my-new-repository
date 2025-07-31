package com.quranapp.islamic.data.database.dao

import androidx.room.*
import com.quranapp.islamic.data.database.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(surahs: List<SurahEntity>)

    @Query("SELECT * FROM surah ORDER BY surahNumber ASC")
    fun getAllSurahs(): Flow<List<SurahEntity>>

    @Query("SELECT * FROM surah WHERE surahNumber = :surahNumber")
    suspend fun getSurah(surahNumber: Int): SurahEntity
}

@Dao
interface AyahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ayahs: List<AyahEntity>)

    @Query("SELECT * FROM ayah WHERE surah_number = :surahNumber ORDER BY ayah_number ASC")
    fun getAyahsForSurah(surahNumber: Int): Flow<List<AyahEntity>>

    @Query("SELECT COUNT(*) FROM ayah")
    suspend fun getTotalAyahCount(): Int
}

@Dao
interface SearchDao {
    @Query("SELECT * FROM ayah WHERE id IN (SELECT docid FROM ayah_fts WHERE ayah_fts MATCH :query)")
    fun searchAyahs(query: String): Flow<List<AyahEntity>>
}

@Dao
interface TranslationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(translations: List<TranslationEntity>)
}

@Dao
interface TafsirDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tafsirs: List<TafsirEntity>)
}

@Dao
interface BookmarkDao {
    @Insert
    suspend fun addBookmark(bookmark: BookmarkEntity)

    @Delete
    suspend fun removeBookmark(bookmark: BookmarkEntity)

    @Query("SELECT * FROM bookmark ORDER BY timestamp DESC")
    fun getAllBookmarksFlow(): Flow<List<BookmarkEntity>>
    
    @Query("SELECT * FROM bookmark")
    suspend fun getAllBookmarks(): List<BookmarkEntity>

    @Query("SELECT COUNT(*) FROM bookmark")
    suspend fun getBookmarkCount(): Int
}

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(note: NoteEntity)

    @Query("SELECT * FROM note WHERE ayah_id = :ayahId")
    suspend fun getNoteForAyah(ayahId: Int): NoteEntity?
    
    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<NoteEntity>

    @Query("SELECT COUNT(*) FROM note")
    suspend fun getNoteCount(): Int
}

@Dao
interface ReadingProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: ReadingProgressEntity)

    @Query("SELECT * FROM reading_progress WHERE id = 1")
    fun getProgress(): Flow<ReadingProgressEntity?>
    
    @Query("SELECT * FROM reading_progress")
    suspend fun getAllReadingProgress(): List<ReadingProgressEntity>
}

@Dao
interface MemorizationProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: MemorizationProgressEntity)
    
    @Query("SELECT * FROM memorization_progress")
    suspend fun getAllMemorizationProgress(): List<MemorizationProgressEntity>
}

@Dao
interface ReciterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(reciters: List<ReciterEntity>)
}

@Dao
interface AudioTimingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(timings: List<AudioTimingEntity>)
}