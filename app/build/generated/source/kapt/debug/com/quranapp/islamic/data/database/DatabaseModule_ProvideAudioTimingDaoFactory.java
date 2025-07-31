package com.quranapp.islamic.data.database;

import com.quranapp.islamic.data.database.dao.AudioTimingDao;
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
public final class DatabaseModule_ProvideAudioTimingDaoFactory implements Factory<AudioTimingDao> {
  private final Provider<QuranDatabase> databaseProvider;

  public DatabaseModule_ProvideAudioTimingDaoFactory(Provider<QuranDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AudioTimingDao get() {
    return provideAudioTimingDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideAudioTimingDaoFactory create(
      Provider<QuranDatabase> databaseProvider) {
    return new DatabaseModule_ProvideAudioTimingDaoFactory(databaseProvider);
  }

  public static AudioTimingDao provideAudioTimingDao(QuranDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAudioTimingDao(database));
  }
}
