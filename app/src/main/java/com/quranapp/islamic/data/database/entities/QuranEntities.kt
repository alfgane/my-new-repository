package com.quranapp.islamic.data.database.entities

import androidx.room.*
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

/**
 * كيان السورة - يمثل سورة كاملة من القرآن الكريم
 */
@Entity(
    tableName = "surah",
    indices = [Index(value = ["surahNumber"], unique = true)]
)
@Parcelize
data class SurahEntity(
    @PrimaryKey 
    val surahNumber: Int,
    
    @ColumnInfo(name = "name_arabic")
    val nameArabic: String,
    
    @ColumnInfo(name = "name_transliterated")
    val nameTransliterated: String,
    
    @ColumnInfo(name = "name_translated")
    val nameTranslated: String,
    
    @ColumnInfo(name = "revelation_type")
    val revelationType: String, // "meccan" or "medinan"
    
    @ColumnInfo(name = "verses_count")
    val versesCount: Int,
    
    @ColumnInfo(name = "juz_count")
    val juzCount: Int,
    
    @ColumnInfo(name = "ruku_count")
    val rukuCount: Int = 0,
    
    @ColumnInfo(name = "bismillah_pre")
    val bismillahPre: Boolean = true
) : Parcelable

/**
 * كيان الآية - يمثل آية واحدة من القرآن الكريم
 */
@Entity(
    tableName = "ayah",
    foreignKeys = [
        ForeignKey(
            entity = SurahEntity::class,
            parentColumns = ["surahNumber"],
            childColumns = ["surahNumber"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("surahNumber"),
        Index("ayahNumber"),
        Index("juzNumber"),
        Index("pageNumber"),
        Index("hizbNumber")
    ]
)
@Parcelize
data class AyahEntity(
    @PrimaryKey 
    val id: Int, // Global unique ID (1-6236)
    
    @ColumnInfo(name = "surah_number")
    val surahNumber: Int,
    
    @ColumnInfo(name = "ayah_number")
    val ayahNumber: Int,
    
    @ColumnInfo(name = "text_uthmani")
    val textUthmani: String, // النص بالخط العثماني
    
    @ColumnInfo(name = "text_simple")
    val textSimple: String, // النص المبسط للبحث
    
    @ColumnInfo(name = "text_imlaei")
    val textImlaei: String? = null, // النص الإملائي
    
    @ColumnInfo(name = "juz_number")
    val juzNumber: Int,
    
    @ColumnInfo(name = "page_number")
    val pageNumber: Int,
    
    @ColumnInfo(name = "hizb_number")
    val hizbNumber: Int,
    
    @ColumnInfo(name = "rub_number")
    val rubNumber: Int = 0,
    
    @ColumnInfo(name = "manzil_number")
    val manzilNumber: Int = 0,
    
    @ColumnInfo(name = "sajdah")
    val sajdah: Boolean = false,
    
    @ColumnInfo(name = "sajdah_number")
    val sajdahNumber: Int? = null,
    
    @ColumnInfo(name = "audio_url")
    val audioUrl: String? = null,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable

/**
 * كيان الترجمة - يمثل ترجمة آية إلى لغة معينة
 */
@Entity(
    tableName = "translation",
    foreignKeys = [
        ForeignKey(
            entity = AyahEntity::class,
            parentColumns = ["id"],
            childColumns = ["ayahId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("ayahId"),
        Index("languageCode"),
        Index("authorId")
    ]
)
@Parcelize
data class TranslationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "language_code")
    val languageCode: String, // "ar", "en", "ur", etc.
    
    @ColumnInfo(name = "author_id")
    val authorId: Int,
    
    @ColumnInfo(name = "author_name")
    val authorName: String,
    
    @ColumnInfo(name = "text")
    val text: String,
    
    @ColumnInfo(name = "resource_id")
    val resourceId: Int? = null
) : Parcelable

/**
 * كيان التفسير - يمثل تفسير آية من مصدر معين
 */
@Entity(
    tableName = "tafsir",
    foreignKeys = [
        ForeignKey(
            entity = AyahEntity::class,
            parentColumns = ["id"],
            childColumns = ["ayahId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("ayahId"),
        Index("authorId"),
        Index("languageCode")
    ]
)
@Parcelize
data class TafsirEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "author_id")
    val authorId: Int,
    
    @ColumnInfo(name = "author_name")
    val authorName: String,
    
    @ColumnInfo(name = "language_code")
    val languageCode: String,
    
    @ColumnInfo(name = "text")
    val text: String,
    
    @ColumnInfo(name = "resource_id")
    val resourceId: Int? = null
) : Parcelable

/**
 * كيان توقيت الصوت - يمثل معلومات التوقيت للمزامنة مع الصوت
 */
@Entity(
    tableName = "audio_timing",
    foreignKeys = [
        ForeignKey(
            entity = AyahEntity::class,
            parentColumns = ["id"],
            childColumns = ["ayahId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("ayahId"),
        Index("reciterId")
    ]
)
@Parcelize
data class AudioTimingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "reciter_id")
    val reciterId: Int,
    
    @ColumnInfo(name = "start_time")
    val startTime: Long, // بالمللي ثانية
    
    @ColumnInfo(name = "end_time")
    val endTime: Long, // بالمللي ثانية
    
    @ColumnInfo(name = "word_timings")
    val wordTimings: String? = null, // JSON array of word timings
    
    @ColumnInfo(name = "segments")
    val segments: String? = null // JSON array of segments
) : Parcelable

/**
 * كيان القارئ - يمثل قارئ القرآن الكريم
 */
@Entity(
    tableName = "reciter",
    indices = [Index(value = ["name"], unique = true)]
)
@Parcelize
data class ReciterEntity(
    @PrimaryKey 
    val id: Int,
    
    @ColumnInfo(name = "name")
    val name: String,
    
    @ColumnInfo(name = "arabic_name")
    val arabicName: String,
    
    @ColumnInfo(name = "relative_path")
    val relativePath: String,
    
    @ColumnInfo(name = "format")
    val format: String = "mp3",
    
    @ColumnInfo(name = "bitrate")
    val bitrate: Int = 64
) : Parcelable

/**
 * كيان الإشارة المرجعية - يمثل آية محفوظة من قبل المستخدم
 */
@Entity(
    tableName = "bookmark",
    foreignKeys = [
        ForeignKey(
            entity = AyahEntity::class,
            parentColumns = ["id"],
            childColumns = ["ayahId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("ayahId")]
)
@Parcelize
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "title")
    val title: String? = null,
    
    @ColumnInfo(name = "note")
    val note: String? = null,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
) : Parcelable

/**
 * كيان الملاحظة - يمثل ملاحظة مستخدم على آية معينة
 */
@Entity(
    tableName = "note",
    foreignKeys = [
        ForeignKey(
            entity = AyahEntity::class,
            parentColumns = ["id"],
            childColumns = ["ayahId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("ayahId")]
)
@Parcelize
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "text")
    val text: String,
    
    @ColumnInfo(name = "formatted_content")
    val formattedContent: String? = null,
    
    @ColumnInfo(name = "tags")
    val tags: String? = null, // JSON array of tags
    
    @ColumnInfo(name = "color")
    val color: Int = 0,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
) : Parcelable

/**
 * كيان تقدم التلاوة - يتتبع تقدم المستخدم في التلاوة
 */
@Entity(
    tableName = "reading_progress",
    indices = [
        Index("surahNumber"),
        Index("ayahId"),
        Index("lastReadAt")
    ]
)
@Parcelize
data class ReadingProgressEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "surah_number")
    val surahNumber: Int,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "progress_percentage")
    val progressPercentage: Float = 0f,
    
    @ColumnInfo(name = "reading_time_seconds")
    val readingTimeSeconds: Long = 0,
    
    @ColumnInfo(name = "last_read_at")
    val lastReadAt: Long = System.currentTimeMillis()
) : Parcelable

/**
 * كيان تقدم الحفظ - يتتبع تقدم المستخدم في الحفظ
 */
@Entity(
    tableName = "memorization_progress",
    indices = [
        Index("ayahId"),
        Index("memorizationLevel"),
        Index("nextReviewAt")
    ]
)
@Parcelize
data class MemorizationProgressEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "ayah_id")
    val ayahId: Int,
    
    @ColumnInfo(name = "memorization_level")
    val memorizationLevel: Int = 0, // 0-5 (0 = not started, 5 = fully memorized)
    
    @ColumnInfo(name = "review_count")
    val reviewCount: Int = 0,
    
    @ColumnInfo(name = "success_count")
    val successCount: Int = 0,
    
    @ColumnInfo(name = "failure_count")
    val failureCount: Int = 0,
    
    @ColumnInfo(name = "interval_days")
    val intervalDays: Int = 1,
    
    @ColumnInfo(name = "next_review_at")
    val nextReviewAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "last_reviewed_at")
    val lastReviewedAt: Long? = null,
    
    @ColumnInfo(name = "ease_factor")
    val easeFactor: Float = 2.5f // للخوارزمية المتباعدة
) : Parcelable

/**
 * جدول بحث النص الكامل للآيات
 */
@Entity(tableName = "ayah_fts")
@Fts4(contentEntity = AyahEntity::class)
data class AyahFtsEntity(
    @ColumnInfo(name = "text_uthmani")
    val textUthmani: String,
    
    @ColumnInfo(name = "text_simple")
    val textSimple: String
)
