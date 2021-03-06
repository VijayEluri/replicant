// Copyright 2009 Kiel Hodges
package replicant.sample2;

import replicant.*;
import static replicant.Replicant.*;

public class MockWidgetRepository implements WidgetRepository {

  
  public MockWidgetRepository(ExpectationEnforcer expectationEnforcer) {
    findWidget = methodMocker(this, "findWidget").
      mappingResponses().
      enforcingExpectationsWith(expectationEnforcer).
      with1Arg();
    storeWidget = voidMethodMocker(this, "storeWidget").
      enforcingExpectationsWith(expectationEnforcer).
      mappingResponses().
      with1Arg();
  }

  public Widget findWidget(int widgetId) {
    return findWidget.call(widgetId);
  }
  
  public final MethodMocker1<Widget, Integer> findWidget;
  
  
  
  public void storeWidget(Widget widget) {
    storeWidget.call(widget);
  }

  public final MethodMocker1<Void, Widget> storeWidget; 
  
}
