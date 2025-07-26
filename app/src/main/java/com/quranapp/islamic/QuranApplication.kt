package com.quranapp.islamic

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.hilt.android.HiltAndroidApp
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject

/**
 * تطبيق Android الرئيسي مع تكوين Hilt و Firebase
 */
@HiltAndroidApp
class QuranApplication : Application(), Configuration.Provider {
    
    @Inject
    lateinit var workManagerConfiguration: Configuration
    
    companion object {
        private const val TAG = "QuranApplication"
        lateinit var instance: QuranApplication
            private set
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
        
        // تهيئة Firebase
        initializeFirebase()
        
        // تهيئة Crashlytics
        initializeCrashlytics()
        
        // تهيئة Analytics
        initializeAnalytics()
        
        // تهيئة WorkManager
        initializeWorkManager()
        
        Log.d(TAG, "تم تهيئة تطبيق القرآن الكريم بنجاح")
    }
    
    /**
     * تهيئة Firebase
     */
    private fun initializeFirebase() {
        try {
            FirebaseApp.initializeApp(this)
            Log.d(TAG, "تم تهيئة Firebase بنجاح")
        } catch (e: Exception) {
            Log.e(TAG, "خطأ في تهيئة Firebase", e)
        }
    }
    
    /**
     * تهيئة Crashlytics لمراقبة الأخطاء
     */
    private fun initializeCrashlytics() {
        try {
            val crashlytics = FirebaseCrashlytics.getInstance()
            
            // تفعيل جمع تقارير الأخطاء في الإصدار النهائي فقط
            crashlytics.setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
            
            // إعداد معلومات المستخدم للتتبع
            crashlytics.setUserId("anonymous_user")
            crashlytics.setCustomKey("app_version", BuildConfig.VERSION_NAME)
            crashlytics.setCustomKey("build_type", BuildConfig.BUILD_TYPE)
            
            Log.d(TAG, "تم تهيئة Crashlytics بنجاح")
        } catch (e: Exception) {
            Log.e(TAG, "خطأ في تهيئة Crashlytics", e)
        }
    }
    
    /**
     * تهيئة Analytics لتتبع الاستخدام
     */
    private fun initializeAnalytics() {
        try {
            val analytics = FirebaseAnalytics.getInstance(this)
            
            // تفعيل جمع البيانات في الإصدار النهائي فقط
            analytics.setAnalyticsCollectionEnabled(!BuildConfig.DEBUG)
            
            // إعداد خصائص المستخدم الافتراضية
            analytics.setUserProperty("app_version", BuildConfig.VERSION_NAME)
            analytics.setUserProperty("app_language", "ar")
            
            Log.d(TAG, "تم تهيئة Analytics بنجاح")
        } catch (e: Exception) {
            Log.e(TAG, "خطأ في تهيئة Analytics", e)
        }
    }
    
    /**
     * تهيئة WorkManager للمهام في الخلفية
     */
    private fun initializeWorkManager() {
        try {
            WorkManager.initialize(this, workManagerConfiguration)
            Log.d(TAG, "تم تهيئة WorkManager بنجاح")
        } catch (e: Exception) {
            Log.e(TAG, "خطأ في تهيئة WorkManager", e)
        }
    }
    
    /**
     * توفير تكوين WorkManager
     */
    override fun getWorkManagerConfiguration(): Configuration {
        return workManagerConfiguration
    }
}

/**
 * وحدة Hilt لتوفير تكوين WorkManager
 */
@dagger.Module
@dagger.hilt.InstallIn(dagger.hilt.components.SingletonComponent::class)
object ApplicationModule {
    
    @dagger.Provides
    @javax.inject.Singleton
    fun provideWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(
                if (BuildConfig.DEBUG) Log.DEBUG else Log.INFO
            )
            .build()
    }
}

/**
 * فئة لإدارة إعدادات التطبيق العامة
 */
@javax.inject.Singleton
class AppPreferencesManager @javax.inject.Inject constructor(
    @dagger.hilt.android.qualifiers.ApplicationContext 
    private val context: android.content.Context
) {
    
    companion object {
        private const val PREF_NAME = "quran_app_preferences"
        private const val KEY_FIRST_LAUNCH = "first_launch"
        private const val KEY_DATABASE_INITIALIZED = "database_initialized"
        private const val KEY_CURRENT_SURAH = "current_surah"
        private const val KEY_CURRENT_AYAH = "current_ayah"
        private const val KEY_SELECTED_RECITER = "selected_reciter"
        private const val KEY_SELECTED_TRANSLATION = "selected_translation"
    }
    
    private val sharedPreferences = context.getSharedPreferences(PREF_NAME, android.content.Context.MODE_PRIVATE)
    
    /**
     * التحقق من أول تشغيل للتطبيق
     */
    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(KEY_FIRST_LAUNCH, true)
    }
    
    /**
     * تحديد أول تشغيل كمكتمل
     */
    fun setFirstLaunchCompleted() {
        sharedPreferences.edit()
            .putBoolean(KEY_FIRST_LAUNCH, false)
            .apply()
    }
    
    /**
     * التحقق من تهيئة قاعدة البيانات
     */
    fun isDatabaseInitialized(): Boolean {
        return sharedPreferences.getBoolean(KEY_DATABASE_INITIALIZED, false)
    }
    
    /**
     * تحديد تهيئة قاعدة البيانات كمكتملة
     */
    fun setDatabaseInitialized(initialized: Boolean) {
        sharedPreferences.edit()
            .putBoolean(KEY_DATABASE_INITIALIZED, initialized)
            .apply()
    }
    
    /**
     * حفظ موضع القراءة الحالي
     */
    fun saveCurrentPosition(surahNumber: Int, ayahNumber: Int) {
        sharedPreferences.edit()
            .putInt(KEY_CURRENT_SURAH, surahNumber)
            .putInt(KEY_CURRENT_AYAH, ayahNumber)
            .apply()
    }
    
    /**
     * استرجاع موضع القراءة الحالي
     */
    fun getCurrentPosition(): Pair<Int, Int> {
        val surahNumber = sharedPreferences.getInt(KEY_CURRENT_SURAH, 1)
        val ayahNumber = sharedPreferences.getInt(KEY_CURRENT_AYAH, 1)
        return Pair(surahNumber, ayahNumber)
    }
    
    /**
     * حفظ القارئ المختار
     */
    fun setSelectedReciter(reciterId: Int) {
        sharedPreferences.edit()
            .putInt(KEY_SELECTED_RECITER, reciterId)
            .apply()
    }
    
    /**
     * استرجاع القارئ المختار
     */
    fun getSelectedReciter(): Int {
        return sharedPreferences.getInt(KEY_SELECTED_RECITER, 1) // الافتراضي: عبد الباسط
    }
    
    /**
     * حفظ الترجمة المختارة
     */
    fun setSelectedTranslation(translationId: String) {
        sharedPreferences.edit()
            .putString(KEY_SELECTED_TRANSLATION, translationId)
            .apply()
    }
    
    /**
     * استرجاع الترجمة المختارة
     */
    fun getSelectedTranslation(): String {
        return sharedPreferences.getString(KEY_SELECTED_TRANSLATION, "ar.muyassar") ?: "ar.muyassar"
    }
}

/**
 * فئة لإدارة تحليلات التطبيق
 */
@javax.inject.Singleton
class AnalyticsManager @javax.inject.Inject constructor(
    @dagger.hilt.android.qualifiers.ApplicationContext 
    private val context: android.content.Context
) {
    
    private val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)
    private val crashlytics: FirebaseCrashlytics = FirebaseCrashlytics.getInstance()
    
    /**
     * تسجيل حدث مخصص
     */
    fun logEvent(eventName: String, params: Map<String, Any>? = null) {
        if (BuildConfig.DEBUG) return
        
        try {
            val bundle = android.os.Bundle()
            params?.forEach { (key, value) ->
                when (value) {
                    is String -> bundle.putString(key, value)
                    is Int -> bundle.putInt(key, value)
                    is Long -> bundle.putLong(key, value)
                    is Double -> bundle.putDouble(key, value)
                    is Boolean -> bundle.putBoolean(key, value)
                    else -> bundle.putString(key, value.toString())
                }
            }
            analytics.logEvent(eventName, bundle)
        } catch (e: Exception) {
            crashlytics.recordException(e)
        }
    }
    
    /**
     * تسجيل بداية قراءة سورة
     */
    fun logSurahRead(surahNumber: Int, surahName: String) {
        logEvent("surah_read", mapOf(
            "surah_number" to surahNumber,
            "surah_name" to surahName
        ))
    }
    
    /**
     * تسجيل البحث
     */
    fun logSearch(query: String, resultsCount: Int) {
        logEvent("search_performed", mapOf(
            "search_query" to query,
            "results_count" to resultsCount
        ))
    }
    
    /**
     * تسجيل إضافة إشارة مرجعية
     */
    fun logBookmarkAdded(ayahId: Int) {
        logEvent("bookmark_added", mapOf(
            "ayah_id" to ayahId
        ))
    }
    
    /**
     * تسجيل الأخطاء غير الخطيرة
     */
    fun recordNonFatalException(throwable: Throwable) {
        crashlytics.recordException(throwable)
    }
    
    /**
     * تحديد معرف المستخدم
     */
    fun setUserId(userId: String?) {
        analytics.setUserId(userId)
        crashlytics.setUserId(userId ?: "anonymous")
    }
    
    /**
     * تحديد خاصية مستخدم
     */
    fun setUserProperty(name: String, value: String?) {
        analytics.setUserProperty(name, value)
    }
}
