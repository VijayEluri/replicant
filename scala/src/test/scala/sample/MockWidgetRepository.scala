// Copyright 2011 Kiel Hodges
package sample

import replicant._

class MockWidgetRepository extends MockGenericRepository[Widget] { minder =>

  override val mock: WidgetRepository = new BaseSubject with WidgetRepository {
    def findByPartNumber(partNumber: String): Widget = minder.findByPartNumber(partNumber)
  }
    
  val findByPartNumber = method("findByPartNumber", mock.findByPartNumber _)

}
