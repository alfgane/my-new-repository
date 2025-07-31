package com.quranapp.islamic;

import android.app.Application;
import android.util.Log;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import dagger.hilt.android.HiltAndroidApp;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import javax.inject.Inject;

/**
 * فئة لإدارة تحليلات التطبيق
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/quranapp/islamic/AnalyticsManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "analytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "crashlytics", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "logBookmarkAdded", "", "ayahId", "", "logEvent", "eventName", "", "params", "", "logSearch", "query", "resultsCount", "logSurahRead", "surahNumber", "surahName", "recordNonFatalException", "throwable", "", "setUserId", "userId", "setUserProperty", "name", "value", "app_debug"})
public final class AnalyticsManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.analytics.FirebaseAnalytics analytics = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.crashlytics.FirebaseCrashlytics crashlytics = null;
    
    @javax.inject.Inject()
    public AnalyticsManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * تسجيل حدث مخصص
     */
    public final void logEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> params) {
    }
    
    /**
     * تسجيل بداية قراءة سورة
     */
    public final void logSurahRead(int surahNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String surahName) {
    }
    
    /**
     * تسجيل البحث
     */
    public final void logSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int resultsCount) {
    }
    
    /**
     * تسجيل إضافة إشارة مرجعية
     */
    public final void logBookmarkAdded(int ayahId) {
    }
    
    /**
     * تسجيل الأخطاء غير الخطيرة
     */
    public final void recordNonFatalException(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    /**
     * تحديد معرف المستخدم
     */
    public final void setUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String userId) {
    }
    
    /**
     * تحديد خاصية مستخدم
     */
    public final void setUserProperty(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
}