package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.TranslationDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideTranslationDaoFactory implements Factory<TranslationDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideTranslationDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TranslationDao get() {
    return provideTranslationDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideTranslationDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTranslationDaoFactory(databaseProvider);
  }

  public static TranslationDao provideTranslationDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTranslationDao(database));
  }
}
