package com.github.mdssjc.mja.cap17;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TempObservable {

    public static Observable<TempInfo> getTemperature(String town) {
        return Observable.create(
                emmiter ->
                        Observable.interval(1L, TimeUnit.SECONDS)
                                  .subscribe(i -> {
                                      if (!emmiter.isDisposed()) {
                                          if (i >= 5) {
                                              emmiter.onComplete();
                                          } else {
                                              try {
                                                  emmiter.onNext(TempInfo.fetch(town));
                                              } catch (Exception e) {
                                                  emmiter.onError(e);
                                              }
                                          }
                                      }
                                  }));
    }

    public static Observable<TempInfo> getCelsiusTemperature(String town) {
        return getTemperature(town).map(
                temp -> new TempInfo(temp.getTown(),
                                     (temp.getTemp() - 32) * 5 / 9));
    }

    public static Observable<TempInfo> getCelsiusTemperatures(String... towns) {
        return Observable.merge(Arrays.stream(towns)
                                      .map(TempObservable::getCelsiusTemperature)
                                      .collect(Collectors.toList()));
    }
}