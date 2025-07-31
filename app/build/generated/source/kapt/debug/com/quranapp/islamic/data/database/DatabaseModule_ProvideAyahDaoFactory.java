package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.AyahDao;
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
public final class DatabaseModule_ProvideAyahDaoFactory implements Factory<AyahDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideAyahDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AyahDao get() {
    return provideAyahDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideAyahDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideAyahDaoFactory(databaseProvider);
  }

  public static AyahDao provideAyahDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAyahDao(database));
  }
}
