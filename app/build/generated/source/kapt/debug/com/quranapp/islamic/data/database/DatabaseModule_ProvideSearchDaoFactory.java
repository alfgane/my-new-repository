package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.SearchDao;
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
public final class DatabaseModule_ProvideSearchDaoFactory implements Factory<SearchDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideSearchDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public SearchDao get() {
    return provideSearchDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideSearchDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideSearchDaoFactory(databaseProvider);
  }

  public static SearchDao provideSearchDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSearchDao(database));
  }
}
