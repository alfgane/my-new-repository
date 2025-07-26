# دليل البدء السريع - تطبيق القرآن الكريم

## 🚀 البدء السريع

### المتطلبات الأساسية

1. **Android Studio** (Hedgehog أو أحدث)
2. **JDK 17+**
3. **Git**
4. **حساب Firebase** (مجاني)

### خطوات التثبيت

#### 1. استنساخ المشروع
```bash
# استنساخ المشروع من المجلد المحلي
# أو من Git repository (إذا تم رفعه لاحقاً)
git clone [repository_url]
cd QuranApp
```

#### 2. فتح المشروع في Android Studio
- افتح Android Studio
- اختر `File > Open`
- انتقل إلى مجلد المشروع واختره
- انتظر حتى يتم تحميل المشروع

#### 3. إعداد Firebase

##### إنشاء مشروع Firebase:
1. اذهب إلى [Firebase Console](https://console.firebase.google.com)
2. انقر على "إنشاء مشروع"
3. اتبع الخطوات لإنشاء المشروع

##### إضافة التطبيق:
1. في Firebase Console، انقر على أيقونة Android
2. أدخل package name: `com.quranapp.islamic`
3. أدخل App nickname: `Quran App`
4. احصل على SHA-1 من Android Studio:
   ```bash
   # في terminal الخاص بـ Android Studio
   ./gradlew signingReport
   ```
5. حمل ملف `google-services.json`
6. ضع الملف في مجلد `app/`

##### تفعيل الخدمات:
- **Authentication**: تفعيل Anonymous و Google Sign-In
- **Firestore Database**: إنشاء قاعدة بيانات
- **Cloud Storage**: تفعيل التخزين السحابي
- **Analytics**: تفعيل التحليلات
- **Crashlytics**: تفعيل مراقبة الأخطاء

#### 4. إعداد البيانات الأولية

##### تحميل بيانات القرآن:
```bash
# إنشاء مجلد البيانات
mkdir -p app/src/main/assets/data

# تحميل بيانات السور
curl -o app/src/main/assets/data/chapters.json "https://api.quran.com/api/v4/chapters"

# تحميل بيانات الآيات (قد يستغرق وقت)
curl -o app/src/main/assets/data/verses.json "https://api.quran.com/api/v4/quran/verses/uthmani"
```

#### 5. تشغيل التطبيق

##### في Android Studio:
1. تأكد من تزامن Gradle (Sync Now)
2. اختر جهاز محاكي أو جهاز فعلي
3. انقر على زر Run ▶️

##### من Terminal:
```bash
# تشغيل على جهاز متصل
./gradlew installDebug

# أو بناء APK
./gradlew assembleDebug
```

## 🔧 حل المشاكل الشائعة

### مشكلة Google Services
```
Error: File google-services.json is missing
```
**الحل**: تأكد من وضع ملف `google-services.json` في مجلد `app/`

### مشكلة Gradle Sync
```
Error: Failed to resolve dependencies
```
**الحل**: 
1. تحديث Android Studio لآخر إصدار
2. تشغيل: `./gradlew clean`
3. إعادة Sync المشروع

### مشكلة Firebase
```
Error: Firebase project not found
```
**الحل**: تحقق من:
1. صحة ملف `google-services.json`
2. تطابق package name في Firebase مع التطبيق
3. تفعيل الخدمات المطلوبة في Firebase Console

### مشكلة Build
```
Error: Compilation failed
```
**الحل**:
1. تحديث Android SDK
2. تشغيل: `./gradlew clean build`
3. التحقق من إصدارات المكتبات في `build.gradle`

## 📁 هيكل المشروع

```
QuranApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/quranapp/islamic/
│   │   │   ├── data/
│   │   │   │   ├── database/
│   │   │   │   │   ├── entities/
│   │   │   │   │   │   └── QuranEntities.kt
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   └── QuranDao.kt
│   │   │   │   │   └── QuranDatabase.kt
│   │   │   │   └── repository/
│   │   │   ├── domain/
│   │   │   ├── presentation/
│   │   │   └── QuranApplication.kt
│   │   ├── res/
│   │   ├── assets/data/
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── google-services.json
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── README.md
├── DEVELOPMENT_GUIDE.md
└── GETTING_STARTED.md
```

## ⚙️ إعدادات التطوير

### متطلبات النظام
- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Compile SDK**: API 34

### مكتبات رئيسية
- **Jetpack Compose**: واجهة المستخدم
- **Room Database**: قاعدة البيانات المحلية
- **Firebase**: الخدمات السحابية
- **ExoPlayer**: تشغيل الصوتيات
- **Hilt**: حقن التبعيات

## 🧪 تشغيل الاختبارات

### اختبارات الوحدة
```bash
./gradlew testDebugUnitTest
```

### اختبارات واجهة المستخدم
```bash
./gradlew connectedAndroidTest
```

### تقرير التغطية
```bash
./gradlew createDebugCoverageReport
```

## 📱 إعداد الجهاز للاختبار

### تفعيل وضع المطور:
1. إعدادات > حول الهاتف
2. اضغط على "رقم الإصدار" 7 مرات
3. ارجع للإعدادات > خيارات المطور
4. تفعيل "تصحيح USB"

### تثبيت ADB:
```bash
# التحقق من الاتصال
adb devices

# تثبيت APK مباشرة
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 🔄 تحديث التطبيق

### تحديث التبعيات
```bash
# التحقق من التحديثات
./gradlew dependencyUpdates

# تحديث Gradle Wrapper
./gradlew wrapper --gradle-version 8.2
```

### تحديث قاعدة البيانات
عند تغيير هيكل قاعدة البيانات:
1. زيادة رقم الإصدار في `@Database`
2. إضافة Migration في `QuranDatabase.kt`
3. اختبار الترقية على جهاز يحتوي بيانات

## 📞 الحصول على المساعدة

### موارد مفيدة
- [Android Developer Guide](https://developer.android.com)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Room Database Guide](https://developer.android.com/training/data-storage/room)

### الإبلاغ عن المشاكل
1. تحقق من قائمة المشاكل المعروفة في المشروع
2. ابحث في Issues على GitHub
3. اكتب issue جديد مع تفاصيل المشكلة

### التواصل
- **Email**: developer@quranapp.com
- **GitHub Issues**: [Repository Issues]
- **Documentation**: راجع `DEVELOPMENT_GUIDE.md`

---

## ✅ قائمة التحقق النهائية

قبل البدء في التطوير، تأكد من:

- [ ] تم تثبيت Android Studio وتحديثه
- [ ] تم إعداد Firebase بشكل صحيح
- [ ] تم وضع ملف `google-services.json`
- [ ] تم تحميل بيانات القرآن الأساسية
- [ ] تم تشغيل التطبيق بنجاح على جهاز أو محاكي
- [ ] تعمل جميع الخدمات الأساسية (قاعدة بيانات، Firebase)

**🎉 مبروك! أنت الآن جاهز لبدء تطوير تطبيق القرآن الكريم!**

---

*للمزيد من التفاصيل حول عملية التطوير، راجع `DEVELOPMENT_GUIDE.md`*
