package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.ReadingProgressDao;
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
public final class DatabaseModule_ProvideReadingProgressDaoFactory implements Factory<ReadingProgressDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideReadingProgressDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ReadingProgressDao get() {
    return provideReadingProgressDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideReadingProgressDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideReadingProgressDaoFactory(databaseProvider);
  }

  public static ReadingProgressDao provideReadingProgressDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideReadingProgressDao(database));
  }
}
