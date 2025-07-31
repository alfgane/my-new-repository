package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.SurahDao;
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
public final class DatabaseModule_ProvideSurahDaoFactory implements Factory<SurahDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideSurahDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public SurahDao get() {
    return provideSurahDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideSurahDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideSurahDaoFactory(databaseProvider);
  }

  public static SurahDao provideSurahDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSurahDao(database));
  }
}
