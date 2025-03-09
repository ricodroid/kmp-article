package ricodroid.kmp.articleapp.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.String

public class DailyPulseDatabaseQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAllArticles(mapper: (
    title: String,
    desc: String?,
    date: String,
    imageUrl: String?,
  ) -> T): Query<T> = Query(-2_146_209_749, arrayOf("Article"), driver, "DailyPulseDatabase.sq",
      "selectAllArticles", """
  |SELECT Article.*
  |FROM Article
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1),
      cursor.getString(2)!!,
      cursor.getString(3)
    )
  }

  public fun selectAllArticles(): Query<Article> = selectAllArticles { title, desc, date,
      imageUrl ->
    Article(
      title,
      desc,
      date,
      imageUrl
    )
  }

  public fun <T : Any> selectAllSources(mapper: (
    id: String,
    name: String,
    desc: String,
    language: String,
    country: String,
  ) -> T): Query<T> = Query(-1_081_636_854, arrayOf("Source"), driver, "DailyPulseDatabase.sq",
      "selectAllSources", """
  |SELECT Source.*
  |FROM Source
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!
    )
  }

  public fun selectAllSources(): Query<Source> = selectAllSources { id, name, desc, language,
      country ->
    Source(
      id,
      name,
      desc,
      language,
      country
    )
  }

  public fun insertArticle(
    title: String,
    desc: String?,
    date: String,
    imageUrl: String?,
  ) {
    driver.execute(-527_675_322, """
        |INSERT INTO Article(title, desc, date, imageUrl)
        |VALUES(?, ?, ?, ?)
        """.trimMargin(), 4) {
          bindString(0, title)
          bindString(1, desc)
          bindString(2, date)
          bindString(3, imageUrl)
        }
    notifyQueries(-527_675_322) { emit ->
      emit("Article")
    }
  }

  public fun removeAllArticles() {
    driver.execute(-1_673_549_917, """DELETE FROM Article""", 0)
    notifyQueries(-1_673_549_917) { emit ->
      emit("Article")
    }
  }

  public fun insertSource(
    id: String,
    name: String,
    desc: String,
    language: String,
    country: String,
  ) {
    driver.execute(-751_355_189, """
        |INSERT INTO Source(id, name, desc, language, country)
        |VALUES(?, ?, ?, ?, ?)
        """.trimMargin(), 5) {
          bindString(0, id)
          bindString(1, name)
          bindString(2, desc)
          bindString(3, language)
          bindString(4, country)
        }
    notifyQueries(-751_355_189) { emit ->
      emit("Source")
    }
  }

  public fun removeAllSources() {
    driver.execute(-373_653_102, """DELETE FROM Source""", 0)
    notifyQueries(-373_653_102) { emit ->
      emit("Source")
    }
  }
}
