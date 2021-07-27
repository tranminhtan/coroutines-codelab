package com.tan.lib.rxjava;

import com.tan.lib.PrintUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import kotlin.Pair;

class MyRxJava {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data(3, 54));
        list.add(new Data(1, 1));
        list.add(new Data(4, 7));
        list.add(new Data(1, 2));
        list.add(new Data(7, 30));
        list.add(new Data(4, 2));
        list.add(new Data(2, 5));
        list.add(new Data(3, 6));

        Observable.fromIterable(list)
                .groupBy(data -> data.key)
                .flatMapSingle(group -> group.count()
                        .map(count -> new Pair<>(group.getKey(), count)))
                .sorted((p1, p2) -> Long.compare(p2.getSecond(), p1.getSecond()))
                .take(1)
                .doOnNext(p -> PrintUtils.print(p.getFirst()))
                .subscribe();

        Observable.fromIterable(list)
                .groupBy(data -> data.key)
                .concatMap(group -> group)
                .doOnNext(PrintUtils::print)
                .subscribe();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Data {
        int key;
        int data;

        public Data(int key, int data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Data{" + "key=" + key + ", data=" + data + '}';
        }
    }
}
