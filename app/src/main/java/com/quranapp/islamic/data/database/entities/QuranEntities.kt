package com.quranapp.islamic.data.database.entities

import androidx.room.*
import androidx.room.Fts4

@Entity(tableName = "surah")
data class SurahEntity(
    @PrimaryKey val surahNumber: Int,
    val nameArabic: String,
    val nameTransliterated: String,
    val versesCount: Int,
    val revelationPlace: String
)

@Entity(
    tableName = "ayah",
    indices = [Index(value = ["surah_number", "ayah_number"], unique = true)]
)
data class AyahEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "surah_number") val surahNumber: Int,
    @ColumnInfo(name = "ayah_number") val ayahNumber: Int,
    val text: String,
    @ColumnInfo(name = "text_simple") val textSimple: String,
    val juz: Int,
    val page: Int
)

@Entity(tableName = "translation")
data class TranslationEntity(
    @PrimaryKey val id: Int,
    val author: String,
    val text: String,
    @ColumnInfo(name = "ayah_id") val ayahId: Int
)

@Entity(tableName = "tafsir")
data class TafsirEntity(
    @PrimaryKey val id: Int,
    val author: String,
    val text: String,
    @ColumnInfo(name = "ayah_id") val ayahId: Int
)

@Entity(tableName = "audio_timing")
data class AudioTimingEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "ayah_id") val ayahId: Int,
    val timings: List<Long>
)

@Entity(tableName = "reciter")
data class ReciterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val style: String?,
    @ColumnInfo(name = "audio_url") val audioUrl: String
)

@Entity(tableName = "bookmark")
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "ayah_id") val ayahId: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "ayah_id") val ayahId: Int,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "reading_progress")
data class ReadingProgressEntity(
    @PrimaryKey val id: Int = 1,
    @ColumnInfo(name = "last_read_surah") val lastReadSurah: Int,
    @ColumnInfo(name = "last_read_ayah") val lastReadAyah: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "memorization_progress")
data class MemorizationProgressEntity(
    @PrimaryKey @ColumnInfo(name = "ayah_id") val ayahId: Int,
    val level: Int, // e.g., 1 to 5
    @ColumnInfo(name = "next_review_date") val nextReviewDate: Long,
    val interval: Int
)

@Fts4(contentEntity = AyahEntity::class)
@Entity(tableName = "ayah_fts")
data class AyahFtsEntity(
    val text: String
)