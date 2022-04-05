package com.example

import com.example.domain.Book
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable

@Fallback
class Service2Fallback implements Service2Client {
    @Override
    Flowable<ArrayList<Book>> findBooks() {
        Book book = new Book()
        book.setTitle("Service 2 is down and will be back shortly")
        return Flowable.just([book])
    }
}
