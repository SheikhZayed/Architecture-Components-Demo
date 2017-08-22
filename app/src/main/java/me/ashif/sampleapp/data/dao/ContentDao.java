package me.ashif.sampleapp.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;
import me.ashif.sampleapp.data.model.ContentModel.Content;

/**
 * Created by Ashif on 22/8/17,August,2017
 * github.com/SheikhZayed
 */
@Dao
public interface ContentDao {

  @Query("SELECT * from content")
  LiveData<Content> loadContents();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void saveContent(List<Content> contentList);

  @Query("SELECT * FROM content WHERE id=:id")
  LiveData<Content> getContent();
}
