package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.ReciterDao;
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
public final class DatabaseModule_ProvideReciterDaoFactory implements Factory<ReciterDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideReciterDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ReciterDao get() {
    return provideReciterDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideReciterDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideReciterDaoFactory(databaseProvider);
  }

  public static ReciterDao provideReciterDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideReciterDao(database));
  }
}
