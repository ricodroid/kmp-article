package ricodroid.kmp.dailypulse.db

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import kotlin.Unit
import ricodroid.kmp.articleapp.db.DailyPulseDatabaseQueries
import ricodroid.kmp.dailypulse.db.shared.newInstance
import ricodroid.kmp.dailypulse.db.shared.schema

public interface DailyPulseDatabase : Transacter {
  public val dailyPulseDatabaseQueries: DailyPulseDatabaseQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = DailyPulseDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): DailyPulseDatabase =
        DailyPulseDatabase::class.newInstance(driver)
  }
}
